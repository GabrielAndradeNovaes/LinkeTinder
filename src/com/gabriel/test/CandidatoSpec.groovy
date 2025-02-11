package com.gabriel.test

import com.gabriel.model.Candidato
import spock.lang.Specification

class CandidatoSpec extends Specification {

    def "Deve criar um candidato e validar os atributos"() {
        when: "Um novo candidato é criado"
        def competencias = ["Java", "Groovy"]
        Candidato candidato = new Candidato("João Silva", "joao@email.com", "123.456.789-10", 30, "SP", "01000-000", competencias)

        then: "Os atributos devem ser corretamente atribuídos"
        candidato.nome == "João Silva"
        candidato.email == "joao@email.com"
        candidato.cpf == "123.456.789-10"
        candidato.idade == 30
        candidato.estado == "SP"
        candidato.cep == "01000-000"
        candidato.competencias == competencias
    }
}
