package br.com.infnet.util.regras;

import br.com.infnet.model.Missao;

public class RegraSucesso implements RegraPontuacao {
    @Override
    public int aplicar(Missao missao) {
        return missao.isTeveSucesso() ? 50 : 0;
    }
}
