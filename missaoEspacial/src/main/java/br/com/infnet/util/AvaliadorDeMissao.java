package br.com.infnet.util;

import br.com.infnet.model.Missao;
import br.com.infnet.util.regras.*;

import java.util.List;

public class AvaliadorDeMissao {
    private final List<RegraPontuacao> regras = List.of(
            new RegraSucesso(),
            new RegraFalhaCritica(),
            new RegraVeterano(),
            new RegraDestino()

    );
    public int calcularPontuacao(Missao missao) {
        return 100 + regras.stream()
                .mapToInt(r -> r.aplicar(missao))
                .sum();
    }


}
