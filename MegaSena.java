package br.com.vainaweb.backendt3.Desafio1;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MegaSena {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numerosEscolhidos = new int[7];
        Random numAleatorio = new Random();
        int countAcertos = 0;

        System.out.println("Bem-vindo ao Sorteio da Mega Sena");
        System.out.println("Você terá 7 chances de acertar os números que serão sorteados.\n");

        int[] numerosEscolhidosVetor = new int[7];
        boolean numeroRepetido;

        for (int i = 0; i < numerosEscolhidos.length; i++) {
            try {
                int numero;
                do {
                    System.out.print("Por favor, informe um número entre 0 e 100: ");
                    numero = sc.nextInt();

                    if (numero < 0 || numero > 100 || contemNumero(numerosEscolhidosVetor, numero)) {
                        System.err.println("Número fora do intervalo permitido ou já escolhido. Tente novamente.");
                    }
                } while (numero < 0 || numero > 100 || contemNumero(numerosEscolhidosVetor, numero));

                numerosEscolhidosVetor[i] = numero;

            } catch (InputMismatchException e) {
                System.err.println("Por favor, informar somente números inteiros!");
                sc.nextLine(); // Limpa o buffer do Scanner
                i--; // Volte uma posição no vetor para reentrar o número
            }
        }

        System.out.println("\nNúmeros sorteados: ");

        for (int i = 0; i < numerosEscolhidos.length; i++) {
            int random;
            do {
                random = numAleatorio.nextInt(100) + 1;
            } while (contemNumero(numerosEscolhidosVetor, random));

            System.out.print(random + " ");

            if (contemNumero(numerosEscolhidosVetor, random)) {
                countAcertos++;
            }
        }
        System.out.println("\n");

        if (countAcertos >= 5 && countAcertos < 6) {
            System.out.printf("Parabéns! Você acertou %d e ganhou um prêmio de 10 mil reais!%n", countAcertos);
        } else if (countAcertos >= 6) {
            System.out.printf("Parabéns! Você acertou %d e ganhou um prêmio de 50 mil reais!%n", countAcertos);
        } else {
            System.out.println("Não foi dessa vez! Tente na próxima!");
        }

        sc.close();
    }

    // Método para verificar se um número já existe no vetor
    private static boolean contemNumero(int[] vetor, int numero) {
        for (int i : vetor) {
            if (i == numero) {
                return true;
            }
        }
        return false;
    }
}
