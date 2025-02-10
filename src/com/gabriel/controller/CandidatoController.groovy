package com.gabriel.controller

import com.gabriel.model.*
import java.util.Scanner

class CandidatoController {
    private Linketinder linketinder = new Linketinder()
    private Scanner scanner = new Scanner(System.in)

    void listarCandidatos() {
        if (linketinder.listarCandidatos().isEmpty()) {
            println("Nenhum candidato cadastrado.")
        } else {
            linketinder.listarCandidatos().each {
                String competenciasFormatadas = it.competencias.join(", ")
                println("${it.nome} - ${it.email} - ${it.cpf} - ${it.idade} anos - ${it.estado} - ${it.cep} - Competências: ${competenciasFormatadas}")
            }
        }
    }

    void adicionarCandidato() {
        scanner.nextLine()
        println("Adicionar novo candidato:")

        print("Nome: ")
        String nome = scanner.nextLine()

        print("Email: ")
        String email = scanner.nextLine()

        print("CPF: ")
        String cpf = scanner.nextLine()

        print("Idade: ")
        int idade = scanner.nextInt()
        scanner.nextLine()

        print("Estado: ")
        String estado = scanner.nextLine()

        print("CEP: ")
        String cep = scanner.nextLine()

        List<String> competencias = []
        print("Quantas competências deseja adicionar? ")
        int qtdCompetencias = scanner.nextInt()
        scanner.nextLine()

        for (int i = 1; i <= qtdCompetencias; i++) {
            print("Digite a competência ${i}: ")
            competencias.add(scanner.nextLine())
        }

        Candidato candidato = new Candidato(nome, email, cpf, idade, estado, cep, competencias)
        linketinder.adicionarCandidato(candidato)

        println("Candidato adicionado com sucesso!")
    }

}
