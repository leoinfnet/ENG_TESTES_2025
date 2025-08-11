package br.com.infnet.util.regras;

import br.com.infnet.model.Missao;

public class RegraVeterano implements RegraPontuacao{
    @Override
    public int aplicar(Missao missao) {
        return missao.isEhVeterando() ? 20 : 0;
    }
}
