package br.com.zeus.goassistence.controllers;

import br.com.zeus.goassistence.dto.MotoristaDto;
import br.com.zeus.goassistence.model.Motorista;
import br.com.zeus.goassistence.repository.MotoristaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class MotoristaController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @GetMapping("/motorista")
    public String index(Model model) {
        model.addAttribute("caminhoes", motoristaRepository.findAll());
        return "motorista/index";
    }

    @GetMapping("/motorista/novo")
    public String createForm(Model model) {
        model.addAttribute("motorista", new MotoristaDto("", (long) 0, "", false));
        return "motorista/new";
    }

    @PostMapping("/motorista")
    public String create(@ModelAttribute MotoristaDto motoristaDto, RedirectAttributes redirectAttributes) {
        try {
            Motorista motorista = mapper.map(motoristaDto, Motorista.class);
            motorista = motoristaRepository.save(motorista);
            redirectAttributes.addFlashAttribute("success", "Caminhão adicionado com sucesso");
            return "redirect:/motorista/" + motorista.getId();
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Falha ao adicionar caminhão: " + e.getMessage());
            return "redirect:/motorista";
        }
    }

    @GetMapping("/motorista/{id}")
    public String read(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Motorista> motorista = motoristaRepository.findById(id);
        if (motorista.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Caminhão não encontrado");
            return "redirect:/motorista";
        }
        model.addAttribute("motorista", motorista.get());
        return "motorista/update";
    }

    @PostMapping("/motorista/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Motorista motoristaForm, RedirectAttributes redirectAttributes) {
        try {
            Motorista motorista = motoristaRepository.save(motoristaForm);
            redirectAttributes.addFlashAttribute("success", "Caminhão atualizado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao atualizar caminhão(" + e.getMessage() + ")");
        }
        return "redirect:/motorista/" + id;
    }

    @GetMapping("/motorista/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            Optional<Motorista> motorista = motoristaRepository.findById(id);
            if (motorista.isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "Caminhão não encontrado");
                return "redirect:/motorista";
            }
            motoristaRepository.delete(motorista.get());
            redirectAttributes.addFlashAttribute("success", "Caminhão apagado com sucesso!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao apagar caminhão (" + e.getMessage() + ")");
        }
        return "redirect:/motorista";
    }
}
