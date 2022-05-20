package br.com.zeus.goassistence.controllers;

import br.com.zeus.goassistence.model.Caminhao;
import br.com.zeus.goassistence.repository.CaminhaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CaminhaoController {
    @Autowired
    private CaminhaoRepository caminhaoRepository;

    @GetMapping("/caminhao")
    public String index(Model model) {
        model.addAttribute("caminhoes", caminhaoRepository.findAll());
        return "caminhao/index";
    }

    @GetMapping("/caminhao/novo")
    public String createForm(Model model) {
        model.addAttribute("caminhao", new Caminhao());
        return "caminhao/new";
    }

    @PostMapping("/caminhao")
    public String create(@ModelAttribute Caminhao caminhaoForm, RedirectAttributes redirectAttributes) {
        try {
            Caminhao caminhao = caminhaoRepository.save(caminhaoForm);
            redirectAttributes.addFlashAttribute("success", "Caminhão adicionado com sucesso");
            return "redirect:/caminhao/" + caminhao.getPlaca();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Falha ao adicionar caminhão: " + e.getMessage());
            return "redirect:/caminhao";
        }
    }

    @GetMapping("/caminhao/{placa}")
    public String read(@PathVariable String placa, Model model, RedirectAttributes redirectAttributes) {
        Caminhao caminhao = caminhaoRepository.findByPlaca(placa);
        if (caminhao == null) {
            redirectAttributes.addFlashAttribute("error", "Caminhão não encontrado");
            return "redirect:/caminhao";
        }
        model.addAttribute("caminhao", caminhao);
        return "caminhao/update";
    }

    @PostMapping("/caminhao/{placa}")
    public String update(@PathVariable String placa, @ModelAttribute Caminhao caminhaoForm, RedirectAttributes redirectAttributes) {
        try {
            Caminhao caminhao = caminhaoRepository.save(caminhaoForm);
            redirectAttributes.addFlashAttribute("success", "Caminhão atualizado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao atualizar caminhão(" + e.getMessage() + ")");
        }
        return "redirect:/caminhao/" + placa;
    }

    @GetMapping("/caminhao/{placa}/delete")
    public String delete(@PathVariable String placa, RedirectAttributes redirectAttributes) {
        try {
            Caminhao caminhao = caminhaoRepository.findByPlaca(placa);
            caminhaoRepository.delete(caminhao);
            redirectAttributes.addFlashAttribute("success", "Caminhão apagado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao apagar caminhão (" + e.getMessage() + ")");
        }
        return "redirect:/caminhao";
    }
}
