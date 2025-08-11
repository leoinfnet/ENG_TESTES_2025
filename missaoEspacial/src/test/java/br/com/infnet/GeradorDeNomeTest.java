package br.com.infnet;

import br.com.infnet.model.Missao;
import br.com.infnet.util.GeradorDeCodigoMissao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeradorDeNomeTest {
    @Test
    void deveGerarNomeSmimplesParaMissaoNaoSecreta(){
        //NASA MARTE 2035 PUBLICA
        Missao missao = new Missao("NASA","NEIL", false, false, false, "MARTE", 2035 , false);
        GeradorDeCodigoMissao geradorDeCodigoMissao = new GeradorDeCodigoMissao();
        String codigo = geradorDeCodigoMissao.gerarCodigo(missao);
        missao.gerarCodigo();

        assertEquals("N-MAR-2035", codigo);
    }
}
