package br.com.infnet.calculadora;

public class Pessoa extends Object {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    @Override
    public boolean equals(Object obj){
       if(!(obj instanceof Pessoa p )) return false;
       return this.nome.equals(p.nome);
    }

}
