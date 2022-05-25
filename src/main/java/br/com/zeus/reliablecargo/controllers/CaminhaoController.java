package br.com.zeus.reliablecargo.controllers;

import br.com.zeus.reliablecargo.dto.CaminhaoDto;
import br.com.zeus.reliablecargo.model.Caminhao;
import br.com.zeus.reliablecargo.repository.CaminhaoRepository;
import br.com.zeus.reliablecargo.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@Controller
public class CaminhaoController {
    @Autowired
    private CaminhaoService caminhaoService;
    @Autowired
    private CaminhaoRepository caminhaoRepository;

    private static String errorParser(List<FieldError> errors) {
        List<String> msgs = new ArrayList<>();
        for (FieldError error : errors) {
            msgs.add(error.getDefaultMessage());
        }
        return String.join(", ", msgs) + '.';
    }
    @ExceptionHandler
    public String handleException(Exception e, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        if (e instanceof BindException) {
            redirectAttributes.addFlashAttribute("error", "Verifique os dados informados: " + errorParser(((BindException) e).getFieldErrors()));
            return "redirect:" + request.getHeader("Referer");
        } else {
            redirectAttributes.addFlashAttribute("error", "Ops... Algo deu errado: " + e.getMessage());
            return "redirect:/caminhao";
        }
    }

    @GetMapping("/caminhao")
    public String index(Model model) {
        model.addAttribute("caminhoes", caminhaoService.all());
        return "caminhao/index";
    }

    @GetMapping("/caminhao/novo")
    public String createForm(Model model) {
        model.addAttribute("caminhao", new CaminhaoDto());
        return "caminhao/new";
    }
    @PostMapping("/caminhao")
    public String create(@ModelAttribute @Valid CaminhaoDto caminhaoForm, RedirectAttributes redirectAttributes) {
        Caminhao caminhao = caminhaoService.create(caminhaoForm);
        redirectAttributes.addFlashAttribute("success", "Caminhão adicionado com sucesso");
        return "redirect:/caminhao/" + caminhao.getPlaca();
    }

    @GetMapping("/caminhao/{placa}")
    public String read(@PathVariable String placa, Model model, RedirectAttributes redirectAttributes) {
        Caminhao caminhao = caminhaoService.findByPlaca(placa);
        model.addAttribute("caminhao", caminhao);
        return "caminhao/update";
    }

    @PostMapping("/caminhao/{placa}")
    public String update(@PathVariable String placa, @ModelAttribute @Valid CaminhaoDto caminhaoDto, RedirectAttributes redirectAttributes) {
        caminhaoService.update(placa, caminhaoDto);
        redirectAttributes.addFlashAttribute("success", "Caminhão atualizado com sucesso!");
        return "redirect:/caminhao/" + placa;
    }

    @GetMapping("/caminhao/{placa}/delete")
    public String delete(@PathVariable String placa, RedirectAttributes redirectAttributes) {
        caminhaoService.delete(placa);
        redirectAttributes.addFlashAttribute("success", "Caminhão apagado com sucesso!");
        return "redirect:/caminhao";
    }
}
