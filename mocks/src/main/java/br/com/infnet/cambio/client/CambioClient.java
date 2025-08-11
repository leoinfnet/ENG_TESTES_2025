package br.com.infnet.cambio.client;

import java.util.concurrent.ThreadLocalRandom;

public class CambioClient {
    public CambioClient() {
        System.out.println("Inicializando service de cambio");
        try { Thread.sleep(1_000); } catch (InterruptedException e) { throw new RuntimeException(e);}

    }

    public double buscarCotacao(String moeda){
        double jitter = ThreadLocalRandom.current().nextDouble(0.95,1.05);
        int delay = ThreadLocalRandom.current().nextInt(400,3000);
        try { Thread.sleep(delay); } catch (InterruptedException e) { throw new RuntimeException(e);}
        return base(moeda) * jitter;
    }
    public double buscarCotacao2(String moeda){
        return base(moeda);
    }
    public double buscarCotacao2(int moeda){
        return 0.0;
    }

    private double base(String moeda){
        buscarCotacao2(1);
        return switch(moeda){
            case "USD" -> 5.0;
            case "EUR" -> 6.0;
            case "GBP" -> 6.5;
            default -> 1.0;
        };
    }
}
