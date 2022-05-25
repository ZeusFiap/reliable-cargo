package br.com.zeus.reliablecargo.controllers;

import br.com.zeus.reliablecargo.dto.MotoristaDto;
import br.com.zeus.reliablecargo.model.Motorista;
import br.com.zeus.reliablecargo.repository.MotoristaRepository;
import br.com.zeus.reliablecargo.service.MotoristaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MotoristaController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MotoristaService motoristaService;

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
            return "redirect:/motorista";
        }
    }

    @GetMapping("/motorista")
    public String index(Model model) {
        model.addAttribute("motoristas", motoristaService.all());
        return "motorista/index";
    }

    @GetMapping("/motorista/novo")
    public String createForm(Model model) {
        model.addAttribute("motorista", new MotoristaDto("", (long) 0, "", false));
        return "motorista/new";
    }

    @PostMapping("/motorista")
    public String create(@ModelAttribute @Valid MotoristaDto motoristaDto, RedirectAttributes redirectAttributes) {
        Motorista motorista = motoristaService.create(motoristaDto);
        redirectAttributes.addFlashAttribute("success", "Motorista adicionado com sucesso");
        return "redirect:/motorista/" + motorista.getId();
    }

    @GetMapping("/motorista/{id}")
    public String read(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Motorista motorista = motoristaService.findById(id);
        model.addAttribute("motorista", motorista);
        return "motorista/update";
    }

    @PostMapping("/motorista/{id}")
    public String update(@PathVariable Long id, @ModelAttribute MotoristaDto motoristaDto, RedirectAttributes redirectAttributes) {
        motoristaService.update(id, motoristaDto);
        redirectAttributes.addFlashAttribute("success", "Motorista atualizado com sucesso!");
        return "redirect:/motorista/" + id;
    }

    @GetMapping("/motorista/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        motoristaService.delete(id);
        redirectAttributes.addFlashAttribute("success", "Motorista apagado com sucesso!");
        return "redirect:/motorista";
    }
}
