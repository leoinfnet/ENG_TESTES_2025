package br.com.infnet.cambio.clientRefatorado;

import java.util.concurrent.ThreadLocalRandom;

public class CambioClientReal implements CambioClient {
    @Override
    public double buscarCotacao(String moeda){
        double jitter = ThreadLocalRandom.current().nextDouble(0.95,1.05);
        int delay = ThreadLocalRandom.current().nextInt(400,3000);
        try { Thread.sleep(delay); } catch (InterruptedException e) { throw new RuntimeException(e);}
        return base(moeda) * jitter;
    }

    @Override
    public void qqCoisaAleatoria() {
        System.out.println("Real");
    }

    private double base(String moeda){
        return switch(moeda){
            case "USD" -> 5.0;
            case "EUR" -> 6.0;
            case "GBP" -> 6.5;
            default -> 1.0;
        };
    }
}
