package br.com.infnet;

import br.com.infnet.cambio.client.ConversorMoedaService;
import br.com.infnet.cambio.clientRefatorado.CambioClientFalso;
import br.com.infnet.cambio.clientRefatorado.CambioClientReal;
import br.com.infnet.cambio.clientRefatorado.ConversorMoedaServiceRefatorado;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConversorTest {
    @ParameterizedTest(name = "[{index} {0} X {1} = {2}]")
    @CsvSource({
            "USD,10.00,50.00",
            "EUR,8.00,48.00",
            "GBP,2.00,13.00",
            "OUTRA,3.33,3.33"
    })
    void convertValoresConhecidos(String moeda, double valor, double esperado ){
        ConversorMoedaServiceRefatorado service = new ConversorMoedaServiceRefatorado(new CambioClientReal());
        double resultado = service.converterParaReais(moeda, valor);

        assertEquals(esperado,resultado,1e-6);
    }
    @ParameterizedTest
    @ValueSource(strings = {"USD","EUR","GBP","YEN"})
    void resultadoNuncaNegativo(String moeda){
        ConversorMoedaServiceRefatorado service = new ConversorMoedaServiceRefatorado(new CambioClientReal());
        double result = service.converterParaReais(moeda, 0.01);
        assertTrue(result > 0.0);

    }


    @Test@Disabled
    void divisaoDeFloats(){
        double a = 1.2;
        double b = 2.42;
        float c = 1.1f;
        float d = 2.24f;
        double result = a * b;
        double result2 = c / d;
        System.out.println(result2);
        assertEquals(0.4910714,result2,1e-6);

    }

}
