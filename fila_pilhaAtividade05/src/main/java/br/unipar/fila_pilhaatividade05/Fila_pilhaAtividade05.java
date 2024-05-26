package br.unipar.fila_pilhaatividade05;

import java.util.Scanner;
import java.util.Stack;

public class Fila_pilhaAtividade05 {

    private static final int NUMERO_DE_PILHAS = 5;
    private static final int LIMITE_PILHA = 10;
    private static Stack<Produtos>[] pilhasDeProdutos = new Stack[NUMERO_DE_PILHAS];
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        for (int i = 0; i < NUMERO_DE_PILHAS; i++) {
            pilhasDeProdutos[i] = new Stack<>();
        }

        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Retirar produto");
            System.out.println("3 - Listar produtos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> retirarProduto();
                case 3 -> listarProdutos();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarProduto() {
        int pilhaEscolhida = escolherPilha();

        if (pilhasDeProdutos[pilhaEscolhida].size() >= LIMITE_PILHA) {
            System.out.println("A pilha está cheia. Não é possível adicionar mais produtos.");
            return;
        }

        System.out.print("Digite o código do produto: ");
        int codProduto = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        System.out.print("Digite a descrição do produto: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite a data de entrada (dd/MM/yyyy): ");
        String dataEntrada = scanner.nextLine();

        System.out.print("Digite a UF de origem: ");
        String ufOrigem = scanner.nextLine();

        System.out.print("Digite a UF de destino: ");
        String ufDestino = scanner.nextLine();

        Produtos novoProduto = new Produtos(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
        pilhasDeProdutos[pilhaEscolhida].push(novoProduto);
        System.out.println("Produto adicionado à pilha " + (pilhaEscolhida + 1) + ".");

        listarProdutos();
    }

    private static void retirarProduto() {
        int pilhaEscolhida = escolherPilha();

        if (pilhasDeProdutos[pilhaEscolhida].isEmpty()) {
            System.out.println("A pilha está vazia. Nenhum produto para retirar.");
        } else {
            Produtos produtoRemovido = pilhasDeProdutos[pilhaEscolhida].pop();
            System.out.println("Produto removido da pilha " + (pilhaEscolhida + 1) + ": " + produtoRemovido);
        }

        listarProdutos();
    }

    private static void listarProdutos() {
        for (int i = 0; i < NUMERO_DE_PILHAS; i++) {
            System.out.println("\nProdutos na pilha " + (i + 1) + ":");
            if (pilhasDeProdutos[i].isEmpty()) {
                System.out.println("A pilha de produtos está vazia.");
            } else {
                for (int j = pilhasDeProdutos[i].size() - 1; j >= 0; j--) {
                    System.out.println((pilhasDeProdutos[i].size() - j) + ": " + pilhasDeProdutos[i].get(j));
                }
            }
        }
    }

    private static int escolherPilha() {
        int pilhaEscolhida;
        do {
            System.out.print("Escolha a pilha (1 a " + NUMERO_DE_PILHAS + "): ");
            pilhaEscolhida = scanner.nextInt();
            scanner.nextLine();  

            if (pilhaEscolhida < 1 || pilhaEscolhida > NUMERO_DE_PILHAS) {
                System.out.println("Pilha inválida! Tente novamente.");
            }
        } while (pilhaEscolhida < 1 || pilhaEscolhida > NUMERO_DE_PILHAS);

        return pilhaEscolhida - 1; 
    }
}
