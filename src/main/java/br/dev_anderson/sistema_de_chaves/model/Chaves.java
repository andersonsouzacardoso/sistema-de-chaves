package br.dev_anderson.sistema_de_chaves.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.NotFound;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Chaves {
    @lombok.Setter
    @lombok.Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotFound
    private String chave;
    @NotFound
    private String setor;


    public Chaves(int id, String chave, String setor) {
        this.id = id;
        this.chave = chave;
        this.setor = setor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Chaves() {
    }
}
