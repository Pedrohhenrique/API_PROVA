package com.example.demo.entity;

import javax.persistence.*;

import java.util.List;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String Idade;
    private String nome;
    private Integer mesesTrabaladosNoAno;
    private Double salario;
    private Double bonusPorIdade;
    private 

    public Funcionario(Long id, String cpf, String idade, String nome, Integer mesesTrabaladosNoAno, Double salario, Double bonusPorIdade) {
        this.id = id;
        this.cpf = cpf;
        Idade = idade;
        this.nome = nome;
        this.mesesTrabaladosNoAno = mesesTrabaladosNoAno;
        this.salario = salario;
        this.bonusPorIdade = bonusPorIdade;
    }

    public Funcionario() {
    }

    public Long getId() {
        return id;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return Idade;
    }

    public void setIdade(String idade) {
        Idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMesesTrabaladosNoAno() {
        return mesesTrabaladosNoAno;
    }

    public void setMesesTrabaladosNoAno(Integer mesesTrabaladosNoAno) {
        this.mesesTrabaladosNoAno = mesesTrabaladosNoAno;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getBonusPorIdade() {
        return bonusPorIdade;
    }

    public void setBonusPorIdade(Double bonusPorIdade) {
        this.bonusPorIdade = bonusPorIdade;
    }
}