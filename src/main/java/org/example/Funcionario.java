package org.example;

public class Funcionario implements Autenticavel {
    protected String Nome;
    protected String Senha;
    public Funcionario(String Nome, String Senha) {
        this.Nome = Nome;
        this.Senha = Senha;
    }

    @Override
    public boolean autenticar(String Nome, String Senha) {
        return this.Nome.equals(Nome) && this.Senha.equals(Senha);
    }
}
