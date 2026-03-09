package org.example;

public class Conta {

    protected String titular;
    protected double saldo;

    public Conta(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void calcularRendimento() {
        System.out.println("Conta comum não possui rendimento específico.");
    }

    public void exibirDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: R$ " + saldo);
    }
}


class ContaCorrente extends Conta {

    private double taxaManutencao = 20.0;

    public ContaCorrente(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void calcularRendimento() {
        saldo -= taxaManutencao; // Desconta taxa ao invés de render juros
        System.out.println("Taxa de manutenção descontada: R$ " + taxaManutencao);
    }
}


class ContaPoupanca extends Conta {

    private double taxaRendimento = 0.05; // 5%

    public ContaPoupanca(String titular, double saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public void calcularRendimento() {
        double rendimento = saldo * taxaRendimento;

        saldo += rendimento;

        System.out.println("Rendimento aplicado: R$ " + rendimento);
    }
}