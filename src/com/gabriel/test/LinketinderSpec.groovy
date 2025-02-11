package com.gabriel.test

import com.gabriel.model.*
import spock.lang.Specification

class LinketinderSpec extends Specification {

    def "Deve adicionar um novo candidato à lista"() {
        given: "Um sistema Linketinder e um novo candidato"
        def linketinder = new Linketinder()
        def candidato = new Candidato("Pedro", "pedro@email.com", "111.222.333-44", 25, "SP", "12345-678", ["Java", "Spring"])

        when: "O candidato é adicionado"
        linketinder.adicionarCandidato(candidato)

        then: "O candidato deve estar na lista"
        linketinder.listarCandidatos().contains(candidato)
    }

    def "Deve adicionar uma nova empresa à lista"() {
        given: "Um sistema Linketinder e uma nova empresa"
        def linketinder = new Linketinder()
        def empresa = new Empresa("NewTech", "contato@newtech.com", "66.777.888/0001-22", "Brasil", "SP", "54321-876", ["Python", "Django"])

        when: "A empresa é adicionada"
        linketinder.adicionarEmpresa(empresa)

        then: "A empresa deve estar na lista"
        linketinder.listarEmpresas().contains(empresa)
    }

    def "A lista de candidatos deve crescer após adicionar um novo candidato"() {
        given: "Um sistema Linketinder com uma lista inicial de candidatos"
        def linketinder = new Linketinder()
        int tamanhoInicial = linketinder.listarCandidatos().size()

        and: "Um novo candidato"
        def candidato = new Candidato("Carlos", "carlos@email.com", "999.888.777-66", 27, "MG", "87654-321", ["JavaScript", "React"])

        when: "O candidato é adicionado"
        linketinder.adicionarCandidato(candidato)

        then: "A lista de candidatos deve aumentar em 1"
        linketinder.listarCandidatos().size() == tamanhoInicial + 1
    }

    def "A lista de empresas deve crescer após adicionar uma nova empresa"() {
        given: "Um sistema Linketinder com uma lista inicial de empresas"
        def linketinder = new Linketinder()
        int tamanhoInicial = linketinder.listarEmpresas().size()

        and: "Uma nova empresa"
        def empresa = new Empresa("SoftDev", "contato@softdev.com", "22.333.444/0001-55", "Brasil", "RJ", "98765-432", ["C#", ".NET"])

        when: "A empresa é adicionada"
        linketinder.adicionarEmpresa(empresa)

        then: "A lista de empresas deve aumentar em 1"
        linketinder.listarEmpresas().size() == tamanhoInicial + 1
    }
}
