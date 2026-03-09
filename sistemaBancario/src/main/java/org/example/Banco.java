package org.example;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Conta> contas =  new ArrayList<>();
    private int proximoNumero = 1;

    public void criarConta(String titular, int tipo){
        Conta conta;

        if (tipo == 1){
            conta = new ContaPoupanca(proximoNumero, titular);
        } else {
            conta = new ContaCorrente(proximoNumero, titular);
        }

        contas.add(conta);
        proximoNumero++;

        System.out.println("Conta Criada com Sucesso!");
    }

    public void listarContas(){
        if (contas.isEmpty()){
            System.out.println("Nenhum conta foi cadastrada!");
        }

        for(Conta c : contas){
            String tipo;
            if(c instanceof ContaCorrente){
                tipo = "Corrente";
            } else {
                tipo = "poupança";
            }
            System.out.println("Conta: " + c.getNumero() +
                    " | Titular: " + c.getTitular() +
                    " | Tipo: " + tipo +
                    " | Saldo: " + c.getSaldo());
        }
    }

    public Conta buscarConta(int numero){
        for (Conta c : contas){
            if (c.getNumero() == numero){
                return c;
            }
        } return null;
    }
}
