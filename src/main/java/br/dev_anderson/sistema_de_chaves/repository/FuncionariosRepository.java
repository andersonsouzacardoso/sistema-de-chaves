package br.dev_anderson.sistema_de_chaves.repository;

import br.dev_anderson.sistema_de_chaves.model.Funcionarios;
import org.springframework.data.repository.CrudRepository;

public interface FuncionariosRepository extends CrudRepository <Funcionarios, Integer> {
    Funcionarios findByMatricula(String matricula);
}
