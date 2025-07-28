package br.com.infnet;

import br.com.infnet.calculadora.Calculadora;
import org.junit.jupiter.api.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;

import  static  org.junit.jupiter.api.Assertions.*;
public class CalculadoraTest {
    Calculadora calculadora;

    @BeforeAll
    public static void init(){
        System.out.println("Roda uma vez só");
    }
    @BeforeEach
    public void setUp(){
        calculadora = new Calculadora();

    }
    @Test@DisplayName("Deve Testar A Soma")
    public void testaSoma(){
        int soma = calculadora.soma(1, 1);
        assertEquals(2,soma);
    }
    @Test
    public void testaSubtracao(){
        assertEquals(2,calculadora.subtrai(5,3));
    }
    @Test
    public void testaMultiplicacao(){
        assertEquals(20,calculadora.multiplica(4,5));
    }
    @Test
    public void testaDivisao(){
        assertEquals(4,calculadora.divide(8,2));
    }
    @Test
    public void divisaoPorZero(){
        ArithmeticException arithmeticException = assertThrows(ArithmeticException.class, () -> {
            calculadora.divide(8, 0);
        });
        String message = arithmeticException.getMessage();
        assertEquals("/ by zero", message, "Divisao Falhou");
    }
    @Test
    public void testaVarios(){
        int soma = calculadora.soma(1, 1);
        int subtrai = calculadora.subtrai(2, 1);

        assertAll("Operações báscias",
                () -> assertEquals(2,calculadora.soma(1,1),"Soma Falhou"),
                () -> assertEquals(0,calculadora.subtrai(1,1))
        );
    }
    @Test
    public void naoPodeDemorarMuito(){
        assertTimeout(Duration.ofMillis(500), ()->{
            Thread.sleep(200);
        });
    }
    @RepeatedTest(3)
    public void repetirTeste(RepetitionInfo info){
        System.out.println("Rodando repetição: " + info.getCurrentRepetition());
    }
    @Test
    @Disabled
    public void divisaoDePontoFlutuante(){
        fail("Teste Não Implementado");
    }
    @AfterEach
    public void tearDown(){
        System.out.println("Rodando Ao Final de CADA UM!");
    }
    @AfterAll
    public static void destroy(){
        System.out.println("Roda uma vez só ao final");
    }
}
