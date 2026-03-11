package br.dev_anderson.sistema_de_chaves.controller;

import br.dev_anderson.sistema_de_chaves.model.Chaves;
import br.dev_anderson.sistema_de_chaves.model.Funcionarios;
import br.dev_anderson.sistema_de_chaves.repository.ChavesRepository;
import br.dev_anderson.sistema_de_chaves.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class ChavesController {
    @Autowired
    private ChavesRepository chavesRepository;
    @Autowired
    private FuncionariosRepository funcionariosrepository;

    @GetMapping("/chaves")
    public String adicionar(){
        return "minhaschaves";
    }
    @PostMapping("/chaves")
    public String adicionar(Chaves chaves){
        chavesRepository.save(chaves);
        return "redirect:/chaves";
    }
    @GetMapping("/chaveslistadas")
    public String ListadasChaves(Model model){
        model.addAttribute("chaveslistadas", chavesRepository.findAll());
        return "controle";
    }

    @GetMapping("/chaveslistadas/alterarchaves/{id}")
    public String alterar(@PathVariable int id, Model model){
        Chaves chaves = chavesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário inválido: " + id));
        model.addAttribute("chaves", chaves);
        return "alterarchaves";
    }

    @PostMapping("/chaveslistadas/alterarchaves")
    public String atualizar(@ModelAttribute Chaves chaves) {

        chavesRepository.save(chaves);
        return "redirect:/chaveslistadas";
    }
    @GetMapping("/chaveslistadas/deletar/{id}")
    public String excluir(@PathVariable int id){
            chavesRepository.deleteById(id);
        return "redirect:/chaveslistadas";
    }
}
