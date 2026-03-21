package org.example;

public class Gerente extends Funcionario{
    public Gerente( String nome, String Senha) {
        super(nome, Senha);
    }

    public boolean autenticar(String Nome, String Senha){
        return this.Nome.equals(Nome) && this.Senha.equals(Senha);
    }
}
