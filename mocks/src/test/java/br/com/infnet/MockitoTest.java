package br.com.infnet;

import br.com.infnet.cambio.clientRefatorado.CambioClient;
import br.com.infnet.cambio.clientRefatorado.CambioClientReal;
import br.com.infnet.cambio.clientRefatorado.ConversorMoedaServiceRefatorado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {
    @Mock
    CambioClient client;
    @InjectMocks
    ConversorMoedaServiceRefatorado service;

    @Test
    void mockBasicoInjetado(){
        when(client.buscarCotacao("USD")).thenReturn(5.0);
        var service = new ConversorMoedaServiceRefatorado(client);
        assertEquals(250.0,service.converterParaReais("USD",50.0));
    }
    @Test
    void verificarChamadas() {
        when(client.buscarCotacao("EUR")).thenReturn(6.0);
        var service = new ConversorMoedaServiceRefatorado(client);
        service.converterParaReais("EUR", 8.0);
        verify(client).buscarCotacao("EUR");
        verify(client, times(1)).buscarCotacao("EUR");
        verifyNoMoreInteractions(client);
    }
    @Test
    void thenAnswerMatchers(){
        var client2 = mock(CambioClient.class); // Chamada Alternativa
        when(client2.buscarCotacao(anyString())).thenAnswer(inv -> {
            String moeda = inv.getArgument(0, String.class);
            return "EUR".equals(moeda) ? 6.0 : 5.0;
        });
        var service = new ConversorMoedaServiceRefatorado(client2);
        assertEquals(50.0,service.converterParaReais("USD", 10),1e-6);
        assertEquals(48.0,service.converterParaReais("EUR", 8),1e-6);
    }
    @ParameterizedTest(name = "[{index} {0} X {1} = {2}]")
    @CsvSource({
            "USD,10.00,50.00",
            "EUR,8.00,48.00",
            "GBP,2.00,13.00",
            "OUTRA,3.33,3.33"
    })
    void thenAnswerPorArgumentos(String moeda, double valor, double esperado) {
        var client2 = mock(CambioClient.class); // Chamada Alternativa
        when(client2.buscarCotacao(anyString())).thenAnswer(inv -> switch (inv.getArgument(0,String.class)){
             case "USD" -> 5.0;
             case "EUR" -> 6.0;
            case "GBP" -> 6.5;
             default -> 1.0;
         });
        var service = new ConversorMoedaServiceRefatorado(client2);
        double resultado  = service.converterParaReais(moeda, valor);
        assertEquals(esperado,resultado,1e-6);
    }
    @Test
    void capturaMoedasEnviadas(){

        var client2 = mock(CambioClient.class); // Chamada Alternativa
        when(client2.buscarCotacao(anyString())).thenReturn(5.0);
        var service = new ConversorMoedaServiceRefatorado(client2);
        service.converterParaReais("USD",1);
        service.converterParaReais("EUR",1);
        service.converterParaReais("TES",1);
        ArgumentCaptor<String> cap = ArgumentCaptor.forClass(String.class);
        verify(client2,times(3)).buscarCotacao(cap.capture());
        assertEquals(List.of("USD","EUR","TES"),cap.getAllValues());
    }
    @Test
    void verificaOrdem(){
        var client2 = mock(CambioClient.class); // Chamada Alternativa
        when(client2.buscarCotacao(anyString())).thenReturn(5.0);
        var service = new ConversorMoedaServiceRefatorado(client2);
        service.converterParaReais("USD",1);
        service.converterParaReais("EUR",1);

        InOrder in = inOrder(client2);
        in.verify(client2).buscarCotacao("USD");
        in.verify(client2).buscarCotacao("EUR");
        verifyNoMoreInteractions(client2);

    }
    @Test
    void spyParcial(){
        CambioClientReal cambioClientReal = new CambioClientReal();
        CambioClientReal spy = spy(cambioClientReal);

        doReturn(7.0).when(spy).buscarCotacao("USD");
        var service = new ConversorMoedaServiceRefatorado(spy);
        double usd = service.converterParaReais("USD", 1.0);
        service.qqCoisa();
        assertEquals(usd,7,1e-6);

    }


}
