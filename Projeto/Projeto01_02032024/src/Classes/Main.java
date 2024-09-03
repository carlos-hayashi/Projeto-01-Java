package Classes;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean condicaoMenu = true;       
        while (condicaoMenu) {
            menu();
            int opcao;
            try {
                opcao = Integer.parseInt(sc.nextLine().trim()); // Lê a opção como uma linha inteira
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                continue; // Volta para o início do loop
            }
            switch(opcao) {
                case 1:
                    System.out.println("Opção escolhida: 1\n");
                    System.out.print("Digite a expressão aritmética na notação infixa: ");
                    String expressao = sc.nextLine();
                    if (verificarParenteses(expressao)) {
                        System.out.println("Os parênteses estão balanceados.");
                    } else {
                        System.out.println("Os parênteses não estão balanceados.");
                    }
                    System.out.println("Expressão digitada: " + expressao);
                    boolean retorno = expressao.matches("\\s*\\(?\\d+(\\s*[+\\-*/]\\s*\\d+)*\\)?\\s*");
                    System.out.println("Expressão válida: " + retorno);
                    break;
                case 2:
                    // Implementar a criação da árvore binária de expressão aritmética
                    break;
                case 3:
                    // Implementar a exibição da árvore binária de expressão aritmética
                    break;
                case 4:
                    // Implementar o cálculo da expressão (realizando o percurso da árvore)
                    break;
                case 5:
                    System.out.println("\nObrigado por utilizar o nosso sistema!");
                    condicaoMenu = false;
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
                    break;
            }
        }
        
        sc.close();
    }
    
    public static void menu() {
        System.out.print("1. Entrada da expressão aritmética na notação infixa.\n"
                + "2. Criação da árvore binária de expressão aritmética.\n"
                + "3. Exibição da árvore binária de expressão aritmética.\n"
                + "4. Cálculo da expressão (realizando o percurso da árvore).\n"
                + "5. Encerramento do programa.\n\n"
                + "Digite sua opção: ");
    }
    
    public static boolean verificarParenteses(String expressao) {
        Stack<Character> pilha = new Stack<>();
        
        for (char caractere : expressao.toCharArray()) {
            switch (caractere) {
                case '(':
                    pilha.push(caractere);
                    break;
                case ')':
                    if (pilha.isEmpty()) {
                        return false; // Parêntese de fechamento sem correspondente de abertura
                    }
                    pilha.pop();
                    break;
                // Você pode adicionar mais casos aqui para outros tipos de parênteses, como [], {}
            }
        }
        
        // Se a pilha estiver vazia, todos os parênteses foram balanceados
        return pilha.isEmpty();
    }
}
