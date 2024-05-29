package br.unipar.fila_pilhaatividade;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Fila_pilha01 {

    public static void main(String[] args) {
        try ( 
                Scanner scanner = new Scanner(System.in)) {
            Queue<String> filaPaciente = new LinkedList<>();
            int maxPacienteDia = 20;
            int opcao;
            
            do {
                System.out.println("\nMenu:");
                System.out.println("1 - Adicionar paciente");
                System.out.println("2 - Chamar próximo paciente");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();  
                
                switch (opcao) {
                    case 1 -> {
                        if (filaPaciente.size() < maxPacienteDia) {
                            System.out.print("Digite o nome do paciente: ");
                            String nome = scanner.nextLine();
                            filaPaciente.add(nome);
                            System.out.println("Paciente " + nome + " adicionado à fila.");
                        } else {
                            System.out.println("Fila cheia! Não é possível adicionar mais pacientes hoje.");
                        }
                    }
                        
                    case 2 -> {
                        if (!filaPaciente.isEmpty()) {
                            String proximoPaciente = filaPaciente.poll();
                            System.out.println("Próximo paciente: " + proximoPaciente);
                        } else {
                            System.out.println("Nenhum paciente na fila.");
                        }
                    }
                        
                    case 3 -> System.out.println("Sistema encerrado...");
                        
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 3);
        }
    }
}
