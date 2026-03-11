package br.dev_anderson.sistema_de_chaves.controller;

import br.dev_anderson.sistema_de_chaves.model.Funcionarios;
import br.dev_anderson.sistema_de_chaves.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class FuncionariosController {
    @Autowired
    private FuncionariosRepository funcionariosrepository;

    @GetMapping("/cadastrar")
    public String cadastro(){
        return "cadastrarusuarios";
    }

    @PostMapping("/cadastrar")
    public String cadastrarpeao(Funcionarios funcionarios){
        funcionariosrepository.save(funcionarios);
        return "/cadastrarusuarios";
    }

    @GetMapping("/listadeusuarios")
    public String Listafuncionarios(Model model){
        model.addAttribute( "listadeusuarios", funcionariosrepository.findAll());
        return "listadeusuarios";
    }
    @GetMapping("/listadeusuarios/editar/{id}")
    public String alterarFuncionario(@PathVariable int id, Model model){
        Funcionarios funcionarios = funcionariosrepository.findById(id).orElse(null);
        model.addAttribute("funcionarios", funcionarios);
        return "alterarfuncionario";
    }

    @PostMapping("listadeusuarios/editar")
    public String salvar(@ModelAttribute Funcionarios funcionarios){
        funcionariosrepository.save(funcionarios);
        return "redirect:/listadeusuarios";
    }
    @GetMapping("/listadeusuarios/excluir/{id}")
    public String deletar(@PathVariable int id){
        funcionariosrepository.deleteById(id);
        return "redirect:/listadeusuarios";
    }
}
