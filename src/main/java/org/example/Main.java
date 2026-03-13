package org.example;

import java.util.Scanner;

public class Main {

    static Banco banco = new Banco();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n===== BANCO JAVA =====");
            System.out.println("1 - Criar conta");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Consultar saldo");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    criarConta();
                    break;

                case 2:
                    banco.listarContas();
                    break;

                case 3:
                    depositar();
                    break;

                case 4:
                    sacar();
                    break;

                case 5:
                    transferir();
                    break;

                case 6:
                    consultarSaldo();
                    break;

            }

        } while (opcao != 0);

    }

    public static void criarConta() {

        scanner.nextLine();

        System.out.print("Nome do titular: ");
        String nome = scanner.nextLine();
        if (nome.trim().isEmpty()){
            System.out.println("Nome do titular não pode ser vazio.");
            return;
        };

        System.out.println("Tipo de conta:");
        System.out.println("1 - Corrente");
        System.out.println("2 - Poupança");

        int tipo = scanner.nextInt();
        if (tipo != 1 && tipo != 2){
            System.out.println("tipo da conta inválido.");
            return;
        }
        banco.criarConta(nome, tipo);
    }

    public static void depositar() {

        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();

        Conta conta = banco.buscarConta(numero);

        if (conta != null) {

            System.out.print("Valor: ");
            double valor = scanner.nextDouble();

            conta.depositar(valor);

            System.out.println("Depósito realizado.");

        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void sacar() {

        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();

        Conta conta = banco.buscarConta(numero);

        if (conta != null) {

            System.out.print("Valor: ");
            double valor = scanner.nextDouble();

            if (valor <= 0){
                System.out.println("Valor inválido.");
                return;
            };
            if (conta.sacar(valor)) {
                System.out.println("Saque realizado.");
            } else {
                System.out.println("Saldo insuficiente.");
            }

        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public static void transferir() {

        System.out.print("Conta origem: ");
        int origem = scanner.nextInt();

        System.out.print("Conta destino: ");
        int destino = scanner.nextInt();

        Conta contaOrigem = banco.buscarConta(origem);
        Conta contaDestino = banco.buscarConta(destino);

        if (contaOrigem != null && contaDestino != null) {
        if (contaOrigem == contaDestino){
            System.out.println("Não é possível transferir para a mesma conta.");
            return;
        };
            System.out.print("Valor: ");
            double valor = scanner.nextDouble();
            if (valor <= 0){
                System.out.println("valor invalido.");
                return;
            };

            contaOrigem.transferir(contaDestino, valor);

            System.out.println("Transferência realizada.");

        } else {
            System.out.println("Conta inválida.");
        }
    }

    public static void consultarSaldo() {

        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();

        Conta conta = banco.buscarConta(numero);

        if (conta != null) {

            System.out.println("Saldo: " + conta.getSaldo());

        } else {
            System.out.println("Conta não encontrada.");
        }
    }

}