package org.example;

public class ContaCorrente extends Conta {
    private double limite;
    public ContaCorrente(int numero, String titular){
        super(numero, titular);
        this.limite = 500;
    }
    @Override
    public boolean sacar(double valor){
        if(saldo + limite >= valor){
            saldo -= valor;
            return true;
        }
        return false;
    }
    public double getLimite(){
        return limite;
    }
}
