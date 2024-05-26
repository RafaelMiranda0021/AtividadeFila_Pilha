package br.unipar.fila_pilhaatividade;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Fila_pilha01 {

    public static void main(String[] args) {
        try ( 
                Scanner scanner = new Scanner(System.in)) {
            Queue<String> filaDePacientes = new LinkedList<>();
            int maxPacientesPorDia = 20;
            int opcao;
            
            do {
                System.out.println("\nMenu:");
                System.out.println("1 - Adicionar paciente");
                System.out.println("2 - Chamar próximo paciente");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();  
                
                switch (opcao) {
                    case 1 -> {
                        if (filaDePacientes.size() < maxPacientesPorDia) {
                            System.out.print("Digite o nome do paciente: ");
                            String nome = scanner.nextLine();
                            filaDePacientes.add(nome);
                            System.out.println("Paciente " + nome + " adicionado à fila.");
                        } else {
                            System.out.println("Fila cheia! Não é possível adicionar mais pacientes hoje.");
                        }
                    }
                        
                    case 2 -> {
                        if (!filaDePacientes.isEmpty()) {
                            String proximoPaciente = filaDePacientes.poll();
                            System.out.println("Próximo paciente: " + proximoPaciente);
                        } else {
                            System.out.println("Nenhum paciente na fila.");
                        }
                    }
                        
                    case 0 -> System.out.println("Encerrando o sistema...");
                        
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 0);
        }
    }
}
