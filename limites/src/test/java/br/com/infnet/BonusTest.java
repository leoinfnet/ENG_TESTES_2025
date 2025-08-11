package br.com.infnet;

import br.com.infnet.bonus.Bonificacao;
import br.com.infnet.bonus.Categoria;
import br.com.infnet.bonus.CategoriaInvalidaException;
import br.com.infnet.bonus.Funcionario;
import org.junit.jupiter.api.*;

import static br.com.infnet.bonus.Categoria.JUNIOR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusTest {
    Bonificacao bonificacao;
    @BeforeEach
    void setUp(){
        bonificacao = new Bonificacao();
    }
    @Nested
    @DisplayName("Testes de Categoria")
    class CategoriaTest{
          @Test@Tag("valido")
          @DisplayName("Bonificacao Para JR deve ser 5%")
          public void bonusJunior() throws IllegalAccessException {
              Funcionario funcionario = new Funcionario("Joao", 1000.00, Categoria.JUNIOR, 0);
              assertEquals(50.0,bonificacao.calcularBonus(funcionario));
          }
        @Test@Tag("valido")
        @DisplayName("Bonificacao Para PL deve ser 10%")
        public void bonusPleno() throws IllegalAccessException {
            Funcionario funcionario = new Funcionario("Joao", 1000.00, Categoria.PLENO, 0);
            assertEquals(100.0,bonificacao.calcularBonus(funcionario));
        }
        @Test@Tag("valido")
        @DisplayName("Bonificacao Para SR deve ser 15%")
        public void bonusSenior() throws IllegalAccessException {
            Funcionario funcionario = new Funcionario("Joao", 1000.00, Categoria.SENIOR, 0);
            assertEquals(150.0,bonificacao.calcularBonus(funcionario));
        }
        @Test@Tag("invalido")
        @DisplayName("Categoria invalida Deve Lancar uma Exception")
        public void deveLancarExceptionCategoriaInvalida() throws IllegalAccessException {
            Funcionario funcionario = new Funcionario("Joao", 1000.00, Categoria.MASTER, 0);
            assertThrows(CategoriaInvalidaException.class, () -> bonificacao.calcularBonus(funcionario));

        }

    }
}
