package br.com.infnet.reembolso;

public class CalculadoraDeReembolso {
    public double calcular(Viagem viagem){
        switch (viagem.getTransporte()){
            case AVIAO:
                if(viagem.getDistanciaEmKm() < 500) return 0.0;
                return viagem.getCustoTotal();
            case TREM:
                return viagem.getCustoTotal() * 0.5;
            case CARRO_PARTICULAR:
                return viagem.getDistanciaEmKm() * 0.75;
            case CARRO_EMPRESA: return 0.0;
            default:
                throw new IllegalArgumentException("Transporte Invalido");
        }
    }
}
