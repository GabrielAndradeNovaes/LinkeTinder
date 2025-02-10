package com.gabriel.view

import com.gabriel.controller.*
import java.util.Scanner

class Menu {
    private CandidatoController candidatoController = new CandidatoController()
    private EmpresaController empresaController = new EmpresaController()
    private Scanner scanner = new Scanner(System.in)

    void exibirMenu() {
        int opcao = 0

        while (opcao != 6) {
            println("\n----- Menu -----")
            println("1. Listar candidatos")
            println("2. Listar empresas")
            println("3. Adicionar candidato")
            println("4. Adicionar empresa")
            println("5. Sair")
            print("Escolha uma opção: ")

            try {
                opcao = scanner.nextInt()
                scanner.nextLine()

                switch (opcao) {
                    case 1:
                        candidatoController.listarCandidatos()
                        break
                    case 2:
                        empresaController.listarEmpresas()
                        break
                    case 3:
                        candidatoController.adicionarCandidato()
                        break
                    case 4:
                        empresaController.adicionarEmpresa()
                        break
                    case 5:
                        println("Saindo...")
                        break
                    default:
                        println("Opção inválida! Tente novamente.")
                }
            } catch (Exception e) {
                println("Entrada inválida. Tente novamente.")
                scanner.nextLine()
            }
        }
    }
}
