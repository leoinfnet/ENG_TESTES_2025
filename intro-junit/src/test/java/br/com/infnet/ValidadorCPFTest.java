package br.com.infnet;

import br.com.infnet.validador.ValidadorCPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorCPFTest {
    @Test
    public void cpfValido(){
        assertTrue(new ValidadorCPF().ehValido("12496329788"));
    }
    @Test
    public void cpfInvalidoPorTamanho(){
        assertFalse(new ValidadorCPF().ehValido("123"));
    }
    @Test
    public void cpfComLetras(){
        assertFalse(new ValidadorCPF().ehValido("12422233Ss"));
    }
    @Test
    public void cpfNull(){
        assertFalse(new ValidadorCPF().ehValido(null));
    }
}
