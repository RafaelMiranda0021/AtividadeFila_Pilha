package br.unipar.fila_pilhaatividade03;

import java.util.Scanner;
import java.util.Stack;

public class Fila_pilhaAtividade03 {
    
    private static Stack<Livro> pilhaDeLivros = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Retirar livro");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  

            switch (opcao) {
                case 1 -> adicionarLivro();
                case 2 -> listarLivros();
                case 3 -> retirarLivro();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarLivro() {
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        String autor = scanner.nextLine();

        Livro novoLivro = new Livro(titulo, autor);
        pilhaDeLivros.push(novoLivro);
        System.out.println("Livro adicionado à pilha.");
    }

    private static void listarLivros() {
        if (pilhaDeLivros.isEmpty()) {
            System.out.println("A pilha de livros está vazia.");
        } else {
            System.out.println("Livros na pilha:");
            for (Livro livro : pilhaDeLivros) {
                System.out.println(livro);
            }
        }
    }

    private static void retirarLivro() {
        if (pilhaDeLivros.isEmpty()) {
            System.out.println("A pilha de livros está vazia. Nenhum livro para retirar.");
        } else {
            Livro livroRemovido = pilhaDeLivros.pop();
            System.out.println("Livro removido: " + livroRemovido);
        }
    }
    }

