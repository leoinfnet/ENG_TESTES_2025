package br.com.infnet.util.regras;

import br.com.infnet.model.Missao;

public interface RegraPontuacao {
    int aplicar(Missao missao);
}
