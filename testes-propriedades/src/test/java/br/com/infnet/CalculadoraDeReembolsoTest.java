package br.com.infnet;

import br.com.infnet.reembolso.CalculadoraDeReembolso;
import br.com.infnet.reembolso.TipoTransporte;
import br.com.infnet.reembolso.Viagem;
import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;
import net.jqwik.api.constraints.IntRange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraDeReembolsoTest {
    CalculadoraDeReembolso calculadora = new CalculadoraDeReembolso();

    @Example
    void reembolsoAviaoComDistanciaValida(){
        Viagem v = new Viagem("SP", "Belem", 1000,
                3_000, false, TipoTransporte.AVIAO);
        assertEquals(3_000,calculadora.calcular(v));
    }
    @Test
    void reembolsoCArroProprioPorKM(){
        Viagem v = new Viagem("SP", "BH", 1000,
                3_000, true, TipoTransporte.CARRO_PARTICULAR);
        assertEquals(750,calculadora.calcular(v));
    }
    @Property
    boolean avialReembolsoCondicional(@ForAll @IntRange(min = 0,max=1_000) int km,
                                     @ForAll @DoubleRange(min=0.0, max = 10_000.0) double custoTotal){
        Viagem v = new Viagem("A","B",km,custoTotal,false,TipoTransporte.AVIAO);
        System.out.printf("%d | %f\n", km, custoTotal);
        if(km < 500) return calculadora.calcular(v) == 0.0;
        return calculadora.calcular(v) == custoTotal;
    }
    @Property
    boolean tremSempreAMetade(@ForAll @DoubleRange(min = 1.0, max = 10_000.0) double custo,
                              @ForAll @IntRange(max = 100_000, min = 5 )int km ){
        System.out.printf("%d | %f\n", km, custo);
        Viagem v = new Viagem("A","B",km,custo,false,TipoTransporte.TREM);
        return calculadora.calcular(v) == custo * 0.5;
    }
    @Provide
    Arbitrary<Viagem> viagensValidas(){
        return Combinators.combine(
                Arbitraries.integers().between(50, 5_000),
                Arbitraries.doubles().between(0.0, 50_000.0),
                Arbitraries.of(TipoTransporte.values())
        ).as((distacia, custo, transporte) ->
                new Viagem("A", "B", distacia, custo, false, transporte));
    }
    @Provide
    Arbitrary<Viagem> viagensInvalidas(){
        return Combinators.combine(
                Arbitraries.integers().between(50, 5_000),
                Arbitraries.doubles().between(0.0, 50_000.0),
                Arbitraries.of(true,false),
                Arbitraries.of(List.of(TipoTransporte.DISCO_VOADOR))
        ).as((distacia, custo, ,carroProprio, transporte) ->
                new Viagem("A", "B", distacia, custo, transporte, transporte));
    }

    @Property
    boolean reembolsoNuncaNegativo(@ForAll("viagensValidas") Viagem v){
        System.out.println(v);
        return calculadora.calcular(v) >= 0.0;
    }
    @Property
    void viagensInvalidas (@ForAll("viagensInvalidas") Viagem v){
        System.out.println(v);
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            calculadora.calcular(v);
        });
    }
}
