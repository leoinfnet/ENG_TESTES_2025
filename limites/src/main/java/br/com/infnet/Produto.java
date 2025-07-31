package br.com.infnet;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        if(nome == null || nome.length() < 3)
            throw new IllegalArgumentException("Nome Inválido");
        if(preco < 10 || preco > 1000 )
            throw new IllegalArgumentException("Preço Inválido");
        if(quantidade <= 0 || quantidade > 1000)
            throw new IllegalArgumentException("Quantidade Inválida");

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
}
