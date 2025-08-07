package br.com.infnet;

import net.jqwik.api.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PropriedadesBasicasTest {
    @Test
    public void helloWorld(){
        System.out.println("Ola");
        assertEquals(1,1);
    }
    @Example
    public void helloWorld2(){
        System.out.println("Ola");
        assertEquals(1,1);
    }
    @Property
    public boolean propriedadeComutativaDaSoma(@ForAll  int a, @ForAll int b){
        System.out.printf("%s + %s\n", a,b);
        return a + b == b + a;
    }
    @Property
    public boolean comprimetoPreservado(@ForAll String s){
        System.out.println(s);
        return s.length() == new StringBuilder(s).reverse().toString().length();
    }
    @Property
    public boolean concatenarPreservaTamanho(@ForAll List<Integer> a, @ForAll List<Integer> b ){
        List<Integer> c = new ArrayList<>(a);
        c.addAll(b);
        return c.size() == a.size() + b.size();
    }
    @Property
    boolean sempreImpares(@ForAll("impares")  int n){
        System.out.println(n);
        return n % 2 != 0;
    }
    @Provide
    Arbitrary<Integer> impares(){

        return Arbitraries.integers().between(1,Integer.MAX_VALUE).filter(n -> n % 2 != 0);
    }
    @Property
    boolean startsWithTest(@ForAll("minhasPalavras2") String a,
                           @ForAll("minhasPalavras2") String b){
        System.out.printf("%s + %s \n",a,b);
        return (a + b).startsWith(a);
    }
    @Provide
    Arbitrary<String> minhasPalavras(){
        return Arbitraries.strings().alpha().ofMinLength(1).ofMaxLength(10);


    }
    @Provide
    Arbitrary<String> minhasPalavras2(){
        return Arbitraries.strings().withCharRange('a','z')
                .ofMaxLength(16).ofMinLength(3);

    }
    @Property
    boolean testaSenha(@ForAll("senhasComplexas2") String senha){
        System.out.println(senha);
        return true;

    }
    @Provide
    Arbitrary<String> senhasComplexas(){
        String caracteresPermitidos = "abcdefghijklmnopqrstuvwxyz" +
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "0123456789" +
                "!@#$%^&*()-_=+[]{};:,.<>?";
        return Arbitraries.strings().withChars(caracteresPermitidos)
                .ofMinLength(8)
                .ofMaxLength(16);
    }
    @Provide
    Arbitrary<String> senhasComplexas2(){
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{};:,.<>?";
        return Arbitraries.strings().withChars(chars)
                .ofMinLength(8).ofMaxLength(16)
                .filter(s -> s.matches("^[a-zA-Z0-9].*"));

    }










}
