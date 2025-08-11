package br.com.infnet.exemplo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        Cachorro cachorro2 = new Cachorro();
        cachorro.respirar();
        Baleia baleia = new Baleia();
        baleia.respirar();

        Animal a = new Cachorro();
        Baleia b = new Baleia();
        // a = b ?? Compila
        a = b;

        List<Cachorro> canil = new ArrayList<>();
        canil.add(cachorro);
        canil.add(cachorro2);
        canil.forEach(Cachorro::respirar);





    }
}
