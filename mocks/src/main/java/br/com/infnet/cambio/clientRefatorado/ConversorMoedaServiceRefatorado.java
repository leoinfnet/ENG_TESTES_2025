package br.com.infnet.cambio.clientRefatorado;


public class ConversorMoedaServiceRefatorado {
    CambioClient client;

    public ConversorMoedaServiceRefatorado(CambioClient client) {
        this.client = client;
    }

    public double converterParaReais(String moeda, double valor){
        //Tratamentos da String
        // REULSTA eur
        double cotacao = client.buscarCotacao(moeda);
       // client.qqCoisaAleatoria();
        return valor * cotacao;
    }
    public void qqCoisa(){
        System.out.println("QQ coisa");
    }


}
