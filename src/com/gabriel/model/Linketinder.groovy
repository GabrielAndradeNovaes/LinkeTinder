package com.gabriel.model

class Linketinder {

    List<Candidato> candidatos = []
    List<Empresa> empresas = []

    Linketinder() {
        inicializarCandidatos()
        inicializarEmpresas()
    }


    private void inicializarCandidatos() {
        candidatos.add(new Candidato(nome: "João", email: "joao@email.com", cpf: "123.456.789-00", idade: 30, estado: "SP", cep: "01000-000", competencias: ["Java", "Spring Boot"]))
        candidatos.add(new Candidato(nome: "Maria", email: "maria@email.com", cpf: "987.654.321-00", idade: 28, estado: "RJ", cep: "02000-000", competencias: ["Python", "Django"]))
        candidatos.add(new Candidato(nome: "Carlos", email: "carlos@email.com", cpf: "112.233.445-66", idade: 35, estado: "MG", cep: "03000-000", competencias: ["JavaScript", "React"]))
        candidatos.add(new Candidato(nome: "Ana", email: "ana@email.com", cpf: "223.344.556-77", idade: 26, estado: "SP", cep: "04000-000", competencias: ["Java", "Spring Boot", "Docker"]))
        candidatos.add(new Candidato(nome: "Lucas", email: "lucas@email.com", cpf: "334.455.667-88", idade: 32, estado: "BA", cep: "05000-000", competencias: ["C#", "ASP.NET"]))
    }

    private void inicializarEmpresas() {
        empresas.add(new Empresa(nome: "TechCorp", emailCorporativo: "contato@techcorp.com", cnpj: "12.345.678/0001-99", pais: "Brasil", estado: "SP", cep: "06000-000", competencias: ["Java", "Spring", "AWS"]))
        empresas.add(new Empresa(nome: "DevSolutions", emailCorporativo: "contato@devsolutions.com", cnpj: "23.456.789/0001-88", pais: "Brasil", estado: "RJ", cep: "07000-000", competencias: ["Python", "Flask", "Kubernetes"]))
        empresas.add(new Empresa(nome: "CodeFactory", emailCorporativo: "contato@codefactory.com", cnpj: "34.567.890/0001-77", pais: "Brasil", estado: "MG", cep: "08000-000", competencias: ["JavaScript", "React", "Node.js"]))
        empresas.add(new Empresa(nome: "InnovativeTech", emailCorporativo: "contato@innovativetech.com", cnpj: "45.678.901/0001-66", pais: "Brasil", estado: "BA", cep: "09000-000", competencias: ["C#", "Azure", "SQL Server"]))
        empresas.add(new Empresa(nome: "SoftTech", emailCorporativo: "contato@softtech.com", cnpj: "56.789.012/0001-55", pais: "Brasil", estado: "RS", cep: "10000-000", competencias: ["Ruby", "Rails", "PostgreSQL"]))
    }


    void adicionarCandidato(Candidato candidato) {
        candidatos.add(candidato)
    }

    void adicionarEmpresa(Empresa empresa) {
        empresas.add(empresa)
    }

    List<Candidato> listarCandidatos() {
        return candidatos
    }

    List<Empresa> listarEmpresas() {
        return empresas
    }

}
