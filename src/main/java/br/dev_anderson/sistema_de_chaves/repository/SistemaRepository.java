package br.dev_anderson.sistema_de_chaves.repository;

import br.dev_anderson.sistema_de_chaves.model.Sistema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SistemaRepository extends JpaRepository<Sistema, Integer> {
}
