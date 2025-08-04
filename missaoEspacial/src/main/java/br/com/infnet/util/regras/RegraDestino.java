package br.com.infnet.util.regras;

import br.com.infnet.model.Missao;

public class RegraDestino implements RegraPontuacao{
    @Override
    public int aplicar(Missao missao) {
        return switch (missao.getDestino().toLowerCase()) {
            case "marte" -> 10;
            case "europa" -> -5;
            default -> 0;
        };
    }
}
