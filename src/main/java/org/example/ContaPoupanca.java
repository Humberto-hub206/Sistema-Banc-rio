package org.example;

public class ContaPoupanca extends Conta {
    private double limiteSaque = 1000;
    public ContaPoupanca(int numero, String titular){
        super(numero, titular);
    }

    @Override
    public boolean sacar(double valor){
        if (valor > limiteSaque){
            System.out.println("Conta poupança permite sacar no máximo 1000 R$ por operação.");
            return false;
        }
        return super.sacar(valor);
    }
    public double getLimiteSaque(){
        return limiteSaque;
    }
}
