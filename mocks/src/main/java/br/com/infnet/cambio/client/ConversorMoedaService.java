package br.com.infnet.cambio.client;

public class ConversorMoedaService {
    public double converterParaReais(String moeda, double valor){
        CambioClient cambioClient = new CambioClient();
        double cotacao = cambioClient.buscarCotacao(moeda);
        return valor * cotacao;
    }

}
