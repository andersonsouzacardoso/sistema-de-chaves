package br.dev_anderson.sistema_de_chaves.repository;

import br.dev_anderson.sistema_de_chaves.model.Chaves;
import org.springframework.data.repository.CrudRepository;

public interface ChavesRepository extends CrudRepository<Chaves, Integer> {

}
