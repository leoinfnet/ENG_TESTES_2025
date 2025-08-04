package br.com.infnet.util.regras;

import br.com.infnet.model.Missao;

public class RegraFalhaCritica implements RegraPontuacao{
    @Override
    public int aplicar(Missao missao) {
        return missao.isTeveFalhaCritica() ? -30 : 0;
    }
}
