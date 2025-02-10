package com.gabriel.controller

import com.gabriel.model.*
import java.util.Scanner

class EmpresaController {
    private Linketinder linketinder = new Linketinder()
    private Scanner scanner = new Scanner(System.in)

    void listarEmpresas() {
        if (linketinder.listarEmpresas().isEmpty()) {
            println("Nenhuma empresa cadastrada.")
        } else {
            linketinder.listarEmpresas().each {
                String competenciasFormatadas = it.competencias.join(", ")
                println("${it.nome} - ${it.emailCorporativo} - ${it.cnpj} - ${it.pais} - ${it.estado} - ${it.cep} - Competências: ${competenciasFormatadas}")
            }
        }
    }

    void adicionarEmpresa() {
        println("\nAdicionar nova empresa:")

        print("Nome da empresa: ")
        String nome = scanner.nextLine()

        print("Email corporativo: ")
        String emailCorporativo = scanner.nextLine()

        print("CNPJ: ")
        String cnpj = scanner.nextLine()

        print("País: ")
        String pais = scanner.nextLine()

        print("Estado: ")
        String estado = scanner.nextLine()

        print("CEP: ")
        String cep = scanner.nextLine()

        List<String> competencias = []
        print("Quantas competências deseja adicionar? ")
        int numCompetencias = scanner.nextInt()
        scanner.nextLine()

        for (int i = 0; i < numCompetencias; i++) {
            print("Digite a competência ${i+1}: ")
            competencias.add(scanner.nextLine())
        }

        Empresa empresa = new Empresa(nome, emailCorporativo, cnpj, pais, estado, cep, competencias)
        linketinder.adicionarEmpresa(empresa)
        println("Empresa adicionada com sucesso!")
    }
}
