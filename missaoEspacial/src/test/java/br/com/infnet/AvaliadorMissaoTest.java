package br.com.infnet;
import br.com.infnet.model.Missao;
import br.com.infnet.util.AvaliadorDeMissao;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AvaliadorMissaoTest {
    AvaliadorDeMissao avaliadorDeMissao;
    @BeforeEach
    public void setUp(){
        avaliadorDeMissao = new AvaliadorDeMissao();

    }
    @Test
    @DisplayName("Deve Calcular pontuacao para missao bem sucedida")
    public void pontuacaoBaseMissaoBemSucedida(){
        Missao missao = new Missao("NASA", "Neil",true, false, false, "LUA", 2035,false);
        int pontuacao = avaliadorDeMissao.calcularPontuacao(missao);
        assertEquals(150,pontuacao);
    }
    @Test
    @DisplayName("Deve Calcular pontuacao para missao com falha critica")
    public void pontuacaoBaseFalhaCritica(){
        Missao missao = new Missao("NASA","Neil", false, true, false, "LUA",2035,false);
        int pontuacao = avaliadorDeMissao.calcularPontuacao(missao);
        assertEquals(70,pontuacao);

    }
    @Test
    @DisplayName("Deve Calcular pontuacao para astronauta veterano")
    public void pontuacaoBaseAtronautaVeterano(){
        Missao missao = new Missao("NASA", "Neil", false, false, true, "LUA",2035,false);
        int pontuacao = avaliadorDeMissao.calcularPontuacao(missao);
        assertEquals(120,pontuacao);

    }
    @Test
    @DisplayName("Deve Calcular pontuacao para astronauta que foiu para Marte")
    public void pontuacaoBaseParaLua(){
        Missao missao = new Missao("NASA","Neil", false, false, false, "MARTE",2035,false);
        int pontuacao = avaliadorDeMissao.calcularPontuacao(missao);
        assertEquals(110,pontuacao);

    }
    @Test
    @DisplayName("Deve Calcular pontuacao para astronauta que foi para Europa")
    public void pontuacaoBaseParaEuropa(){
        Missao missao = new Missao("NASA","Neil", false, false, false, "EUROPA",2035,false);
        int pontuacao = avaliadorDeMissao.calcularPontuacao(missao);
        assertEquals(95,pontuacao);
    }

}
