package org.example;

public class ContaCorrente extends Conta implements Tributavel{
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
    @Override
    public double CalcularTributo(){
        return this.saldo * 0.01; //1% de imposto
    }

    public double getLimite(){
        return limite;
    }
}
