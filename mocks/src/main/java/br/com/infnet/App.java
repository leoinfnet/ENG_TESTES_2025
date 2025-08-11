package br.com.infnet;

import br.com.infnet.cambio.client.ConversorMoedaService;
import br.com.infnet.cambio.clientRefatorado.CambioClientReal;
import br.com.infnet.cambio.clientRefatorado.ConversorMoedaServiceRefatorado;
import br.com.infnet.cambio.oo.Animal;
import br.com.infnet.cambio.oo.Cachorro;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        System.out.println( "Hello World!" );
        ConversorMoedaServiceRefatorado service =
                new ConversorMoedaServiceRefatorado(new CambioClientReal());
        double usd = service.converterParaReais("USD", 200);
        System.out.println("Valor Devido " + usd);
//        Animal animal = new Animal();
//        animal.fazerBarulho();
//        Cachorro cachorro = new Cachorro();
//        cachorro.fazerBarulho();
//        System.out.println("====================");
//        Animal qq = new Cachorro();
//        qq.fazerBarulho();
    }
}
