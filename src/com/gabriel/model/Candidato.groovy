package com.gabriel.model

class Candidato {

    String nome
    String email
    String cpf
    int idade
    String estado
    String cep
    List<String> competencias = []

    Candidato(){

    }

    Candidato(String nome, String email, String cpf, int idade, String estado, String cep, List<String> competencias) {
        this.nome = nome
        this.email = email
        this.cpf = cpf
        this.idade = idade
        this.estado = estado
        this.cep = cep
        this.competencias = competencias
    }
}
