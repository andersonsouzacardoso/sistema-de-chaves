package br.dev_anderson.sistema_de_chaves.controller;

import br.dev_anderson.sistema_de_chaves.model.Chaves;
import br.dev_anderson.sistema_de_chaves.model.Funcionarios;
import br.dev_anderson.sistema_de_chaves.model.Sistema;
import br.dev_anderson.sistema_de_chaves.repository.ChavesRepository;
import br.dev_anderson.sistema_de_chaves.repository.FuncionariosRepository;
import br.dev_anderson.sistema_de_chaves.repository.SistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
public class SistemaController {
    @Autowired
    private FuncionariosRepository funcionariosRepository;
    @Autowired
    private ChavesRepository chavesRepository;
    @Autowired
    private SistemaRepository sistemarepository;

    @GetMapping("/retirarchave")
    public String telaRetirada(Model model){
        model.addAttribute("chaves", chavesRepository.findAll());
        return "sistema";
    }

    @PostMapping("/retirarchave")
    public String retirarChave(
            String matricula,
            int idChave
    ){

        Funcionarios func =

                funcionariosRepository.findByMatricula(matricula);

        Chaves chave =
                chavesRepository.findById(idChave).orElse(null);

        Sistema registro = new Sistema();

        registro.setMatricula(func.getMatricula());
        registro.setNomeFuncionario(func.getNome());
        registro.setNomeChave(chave.getSetor());

        registro.setDataRetirada(LocalDate.now());
        registro.setHoraRetirada(LocalTime.now());

        sistemarepository.save(registro);

        return "redirect:/chavesemprestadas";
    }

    @PostMapping("/devolverchave/{id}")
    public String devolver(@PathVariable int id){

        Sistema registro =
                sistemarepository.findById(id).orElse(null);

        registro.setDataDevolucao(LocalDate.now());
        registro.setHoraDevolucao(LocalTime.now());

        sistemarepository.save(registro);

        return "redirect:/retirarchave";
    }

    @GetMapping("/chavesemprestadas")
    public String listaEmprestadas(Model model){

        model.addAttribute("registros",
                sistemarepository.findAll());

        return "chavesemprestadas";
    }

    @GetMapping("/chavesemprestadas/excluir/{id}")
    public String deletar(@PathVariable int id){
        sistemarepository.deleteById(id);
        return "redirect:/chavesemprestadas";
    }




}
