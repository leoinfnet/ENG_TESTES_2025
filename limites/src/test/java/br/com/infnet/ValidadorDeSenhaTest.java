package br.com.infnet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorDeSenhaTest {
    private ValidadorDeSenha validadorDeSenha;
    //AOP
    @BeforeEach
    void setUp(){
        validadorDeSenha = new ValidadorDeSenha();
    }
    @Nested
    @DisplayName("Testes de Partição")
    class ParticaoTest{
        @Test
        @DisplayName("Senha com apenas numeros deve ser inválida")
        public void senhaComLetrasInvalida(){
            assertFalse(validadorDeSenha.senhaValida("123456"));
        }
        @Test
        @DisplayName("Senha com apenas letras deve ser inválida")
        public void senhaSoComLetrasInvalida(){
            assertFalse(validadorDeSenha.senhaValida("ABCDE"));
        }
        @Test
        @DisplayName("Senha com letras e numeros deve ser valida")
        public void senhaComLetrasENumerosValida(){
            assertFalse(validadorDeSenha.senhaValida("leo123456"));
        }
    }
    @Nested
    @DisplayName("Testes de limite")
    class LimitesTest{
        @Test
        @DisplayName("Senha Com 7 Chars deve ser invalida")
        public void senhaCom7CharsInvalida(){
            assertFalse(validadorDeSenha.senhaValida("leo1237"));
        }
          @Test
          @DisplayName("Senha Com 8 chars tem q ser valida se tiver letra e numero")
          public void senhaValidaCom8Chars(){
            assertTrue(validadorDeSenha.senhaValida("abc12345"));

          }
        @Test
        @DisplayName("Senha Com 16 chars tem q ser valida se tiver letra e numero")
        public void senhaValidaCom16Chars(){
            assertTrue(validadorDeSenha.senhaValida("abc1234567891012"));

        }






    }



}
