package br.com.infnet;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProdutoTest {
    private String nomeValido;
    private double precoValido;
    private int quantidadeValida;

    @BeforeEach
    void setUp(){
        nomeValido = "Garrafa";
        precoValido = 100.00;
        quantidadeValida = 10;
    }

    @Nested
    class Limites {
        @Test
        @DisplayName("")
        public void algumaCoisa() {

        }
    }
    @Nested
    class Particoes {
        @Test
        @Tag("particao")
        @Tag("valido")
        @DisplayName("Deve aceitar um produto valido")
        public void deveAceitarProdutoValido() {
            assertDoesNotThrow(() -> new Produto(nomeValido, precoValido, quantidadeValida));

        }
        @Test
        @Tag("particao")
        @Tag("invalido")
        @DisplayName("Deve lancar uma exception com preco maior que 3000")
        public void deveLancarExcepcaoPrecoAlto() {
            assertThrows(IllegalArgumentException.class,() -> new Produto(nomeValido, 5000, quantidadeValida));

        }


    }



}
