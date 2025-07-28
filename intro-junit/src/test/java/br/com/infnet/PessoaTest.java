package br.com.infnet;

import br.com.infnet.calculadora.Pessoa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PessoaTest {
    @Test
    public void testaObjetos(){
        Pessoa p = new Pessoa("Joao",30);
        Pessoa joao = new Pessoa("Joao", 30);
        assertEquals(joao,p);
    }
}
