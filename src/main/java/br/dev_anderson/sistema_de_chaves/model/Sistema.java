package br.dev_anderson.sistema_de_chaves.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
public class Sistema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String matricula;
    private String nomeFuncionario;
    private String nomeChave;

    private LocalDate dataRetirada;
    private LocalTime horaRetirada;
    private LocalDate dataDevolucao;
    private LocalTime horaDevolucao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getNomeChave() {
        return nomeChave;
    }

    public void setNomeChave(String nomeChave) {
        this.nomeChave = nomeChave;
    }

    public LocalDate getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public LocalTime getHoraRetirada() {
        return horaRetirada;
    }

    public void setHoraRetirada(LocalTime horaRetirada) {
        this.horaRetirada = horaRetirada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalTime getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(LocalTime horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }
}
