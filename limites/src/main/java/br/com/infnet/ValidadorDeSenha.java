package br.com.infnet;

public class ValidadorDeSenha {

    public boolean senhaValida(String senha){
        if(senha == null) return false;
        if(senha.length() < 8 || senha.length() > 16) return false;
        boolean temLetra = senha.matches(".*[a-zA-Z].*");
        boolean temNumero = senha.matches(".*\\d.*");
        return temLetra && temNumero;
    }
}
