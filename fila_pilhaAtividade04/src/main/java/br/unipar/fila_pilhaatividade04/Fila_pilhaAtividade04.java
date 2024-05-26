package br.unipar.fila_pilhaatividade04;

import java.util.Scanner;
import java.util.Stack;

public class Fila_pilhaAtividade04 {

    private static Stack<Produto> pilhaDeProdutos = new Stack<>();
    private static final int LIMITE_PILHA = 10;
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
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
        if (pilhaDeProdutos.size() >= LIMITE_PILHA) {
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

        Produto novoProduto = new Produto(codProduto, descricao, dataEntrada, ufOrigem, ufDestino);
        pilhaDeProdutos.push(novoProduto);
        System.out.println("Produto adicionado à pilha.");

        listarProdutos();
    }

    private static void retirarProduto() {
        if (pilhaDeProdutos.isEmpty()) {
            System.out.println("A pilha está vazia. Nenhum produto para retirar.");
        } else {
            Produto produtoRemovido = pilhaDeProdutos.pop();
            System.out.println("Produto removido: " + produtoRemovido);
        }

        listarProdutos();
    }

    private static void listarProdutos() {
        if (pilhaDeProdutos.isEmpty()) {
            System.out.println("A pilha de produtos está vazia.");
        } else {
            System.out.println("Produtos na pilha:");
            for (int i = pilhaDeProdutos.size() - 1; i >= 0; i--) {
                System.out.println((pilhaDeProdutos.size() - i) + ": " + pilhaDeProdutos.get(i));
            }
        }
        
    }
}
