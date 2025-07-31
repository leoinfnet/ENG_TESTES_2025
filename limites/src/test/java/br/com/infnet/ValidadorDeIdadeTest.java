package br.com.infnet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorDeIdadeTest {
    ValidadorDeIdade validadorDeIdade;

    @BeforeEach
    public void setUp(){
        validadorDeIdade = new ValidadorDeIdade();
    }

    @Test
    @DisplayName("Particao Válida 18-65 - Idade Igual a 20")
    public void idadeIgualA18DeveSerValida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(20);
        assertTrue(valido);
    }
    @Test
    @DisplayName("Particao inválida <= 18 - Idade Menor que 18")
    public void idadeMenorQue18DeveSerInvalida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(10);
        assertFalse(valido);
    }
    @Test
    @DisplayName("Particao inválida >= 65 - Idade Maior que 65")
    public void idadeMaiorQue65DeveSerInvalida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(10);
        assertFalse(valido);
    }
    @Test
    @DisplayName("Teste De Limite - - Idade Igual a 18")
    public void idadeIgualA18deveSerValida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(18);
        assertTrue(valido);
    }
    @Test
    @DisplayName("Teste De Limite - - Idade Igual a 19")
    public void idadeIgualA19deveSerValida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(19);
        assertTrue(valido);
    }

    @Test
    @DisplayName("Teste De Limite -Uma unidade abaixo deve ser valida")
    public void idadeIgualA64deveSerValida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(64);
        assertTrue(valido);
    }
    @Test
    @DisplayName("Teste De Limite - - Idade Igual a 17 deve ser invalida")
    public void idadeIgualA17deveSerInvalida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(17);
        assertFalse(valido);
    }
    @Test
    @DisplayName("Teste De Limite - - Idade Igual a 66 deve ser invalida")
    public void idadeIgualA66deveSerInvalida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(66);
        assertFalse(valido);
    }
    @Test
    @DisplayName("Teste De Limite - - Idade Igual a 65")
    public void idadeIgualA65deveSerValida(){
        boolean valido = validadorDeIdade.idadeParaCadasrtro(65);
        assertTrue(valido);
    }

}
