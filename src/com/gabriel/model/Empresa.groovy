package com.gabriel.model

class Empresa {

    String nome
    String emailCorporativo
    String cnpj
    String pais
    String estado
    String cep
    List<String> competencias = []

    Empresa(){

    }

    Empresa(String nome, String emailCorporativo, String cnpj, String pais, String estado, String cep, List<String> competencias) {
        this.nome = nome
        this.emailCorporativo = emailCorporativo
        this.cnpj = cnpj
        this.pais = pais
        this.estado = estado
        this.cep = cep
        this.competencias = competencias
    }
}
