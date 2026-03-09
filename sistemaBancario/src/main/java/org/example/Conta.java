package org.example;

public abstract class Conta {
    protected double saldo;
    protected String titular;
    protected int numero;

    public Conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public void transferir(Conta destino, double valor){
        if(sacar(valor)){
            destino.depositar(valor);
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public int getNumero(){
        return numero;
    }

    public String getTitular(){
        return titular;
    }
}