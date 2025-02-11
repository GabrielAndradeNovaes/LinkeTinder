package com.gabriel.test

import com.gabriel.model.Empresa
import spock.lang.Specification

class EmpresaSpec extends Specification {

    def "Deve criar uma empresa e validar os atributos"() {
        when: "Uma nova empresa é criada"
        def competencias = ["Java", "Groovy", "Spring"]
        Empresa empresa = new Empresa("Tech Solutions", "contato@tech.com", "12.345.678/0001-99", "Brasil", "SP", "01000-000", competencias)

        then: "Os atributos devem ser corretamente atribuídos"
        empresa.nome == "Tech Solutions"
        empresa.emailCorporativo == "contato@tech.com"
        empresa.cnpj == "12.345.678/0001-99"
        empresa.pais == "Brasil"
        empresa.estado == "SP"
        empresa.cep == "01000-000"
        empresa.competencias == competencias
    }
}
