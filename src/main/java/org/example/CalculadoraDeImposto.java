package org.example;

public class CalculadoraDeImposto {
    private double totalImposto = 0;
    public void registrar(Tributavel t){
        totalImposto += t.CalcularTributo();
    }

    public double getTotalImposto(){
        return totalImposto;
    }
}
