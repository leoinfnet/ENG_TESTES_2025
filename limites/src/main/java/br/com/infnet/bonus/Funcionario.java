package br.com.infnet.bonus;

public class Funcionario {
    private String nome;
    private double salarioBase;
    //private String categoria; //JUNIOR , PLENO, SENIOR
    private Categoria categoria;
    private int metasAtingidas;

    public Funcionario(String nome, double salarioBase, Categoria categoria, int metasAtingidas) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.categoria = categoria;
        this.metasAtingidas = metasAtingidas;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getMetasAtingidas() {
        return metasAtingidas;
    }
}
