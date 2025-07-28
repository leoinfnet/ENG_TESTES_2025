package br.com.infnet.validador;

public class ValidadorCPF {
    public boolean ehValido(String cpf){
        if(cpf == null || cpf.length() != 11) return false;
        return cpf.chars().allMatch(Character::isDigit);
    }
}
