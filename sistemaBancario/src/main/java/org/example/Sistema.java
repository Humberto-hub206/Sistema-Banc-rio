package org.example;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do titular:");
        String titular = scanner.nextLine();

        System.out.println("Digite o saldo inicial:");
        double saldo = scanner.nextDouble();

        System.out.println("Escolha o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");

        int tipo = scanner.nextInt();

        Conta conta;

        if (tipo == 1) {
            conta = new ContaCorrente(titular, saldo);
        } else {
            conta = new ContaPoupanca(titular, saldo);
        }

        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Calcular rendimento");
            System.out.println("4 - Exibir dados");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Valor para depositar:");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;

                case 2:
                    System.out.println("Valor para sacar:");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;

                case 3:
                    conta.calcularRendimento();
                    break;

                case 4:
                    conta.exibirDados();
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}