package br.com.infnet.bonus;

import static br.com.infnet.bonus.Categoria.*;

public class Bonificacao {
    // JUNIOR -> 5% ; PLENO -> 10% , SENIOR -> 15
    public double calcularBonus(Funcionario funcionario) throws IllegalAccessException {

        double percentualBase = switch (funcionario.getCategoria()) {
            case JUNIOR -> 0.05;
            case PLENO -> 0.10;
            case SENIOR -> 0.15;
            default ->
                throw new CategoriaInvalidaException("Categoria invalida");

        };
        double baseBonus = percentualBase * funcionario.getSalarioBase();
        double metas = Math.min(funcionario.getMetasAtingidas(), 5);
        double bonusMetas = metas * 100;
        double bonusTotal = baseBonus + bonusMetas;
        return Math.min(bonusTotal,2000);
    }
}
