package br.com.infnet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter@AllArgsConstructor
public class Missao {
    private String agencia;
    private String nomeDoAtronauta;
    private boolean teveSucesso;
    private boolean teveFalhaCritica;
    private boolean ehVeterando;
    private String destino;
    private int ano;
    private boolean secreta;


    // SpringDATA ->
    //Plain Old JAVA Object
    //VO DTO
    public String gerarCodigo(){
        return null;
    }
}