package br.unipar.fila_pilhaatividade02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Fila_pilha02 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Queue<Cliente> filaPrioritaria = new LinkedList<>();
            Queue<Cliente> filaNormal = new LinkedList<>();
            int senhaAtual = 1;
            int atendidosPrioritarios = 0;
            int opcao;
            
            do {
                System.out.println("\nMenu:");
                System.out.println("1 - Adicionar cliente");
                System.out.println("2 - Chamar próximo cliente");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();  
                
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o nome do cliente: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o ano de nascimento do cliente: ");
                        int anoNascimento = scanner.nextInt();
                        scanner.nextLine();  
                        
                        Cliente cliente = new Cliente(senhaAtual++, nome, anoNascimento);
                        if (cliente.getIdade() > 65) {
                            filaPrioritaria.add(cliente);
                            System.out.println("Cliente " + nome + " adicionado à fila prioritária.");
                        } else {
                            filaNormal.add(cliente);
                            System.out.println("Cliente " + nome + " adicionado à fila normal.");
                        }
                    }
                        
                    case 2 -> {
                        if (!filaPrioritaria.isEmpty() && (atendidosPrioritarios < 2 || filaNormal.isEmpty())) {
                            Cliente cliente = filaPrioritaria.poll();
                            System.out.println("Atendendo cliente prioritário: " + cliente);
                            atendidosPrioritarios++;
                        } else if (!filaNormal.isEmpty()) {
                            Cliente cliente = filaNormal.poll();
                            System.out.println("Atendendo cliente normal: " + cliente);
                            atendidosPrioritarios = 0;
                        } else if (!filaPrioritaria.isEmpty()) {
                            Cliente cliente = filaPrioritaria.poll();
                            System.out.println("Atendendo cliente prioritário: " + cliente);
                            atendidosPrioritarios++;
                        } else {
                            System.out.println("Nenhum cliente na fila.");
                        }
                    }
                        
                    case 3 -> System.out.println("Sistema encerrado");
                        
                    default -> System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 3);
        }
    }
}
