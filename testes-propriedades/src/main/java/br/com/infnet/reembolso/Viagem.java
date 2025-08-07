package br.com.infnet.reembolso;

public class Viagem {
    private String origem;
    private String destino;
    private int distanciaEmKm;
    private double custoTotal;
    private boolean usouCarroProprio;
    private TipoTransporte transporte;

    @Override
    public String toString() {
        return "Viagem{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", distanciaEmKm=" + distanciaEmKm +
                ", custoTotal=" + custoTotal +
                ", usouCarroProprio=" + usouCarroProprio +
                ", transporte=" + transporte +
                '}';
    }

    public Viagem(String origem, String destino, int distanciaEmKm, double custoTotal, boolean usouCarroProprio, TipoTransporte transporte) {
        this.origem = origem;
        this.destino = destino;
        this.distanciaEmKm = distanciaEmKm;
        this.custoTotal = custoTotal;
        this.usouCarroProprio = usouCarroProprio;
        this.transporte = transporte;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDistanciaEmKm() {
        return distanciaEmKm;
    }

    public void setDistanciaEmKm(int distanciaEmKm) {
        this.distanciaEmKm = distanciaEmKm;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public boolean isUsouCarroProprio() {
        return usouCarroProprio;
    }

    public void setUsouCarroProprio(boolean usouCarroProprio) {
        this.usouCarroProprio = usouCarroProprio;
    }

    public TipoTransporte getTransporte() {
        return transporte;
    }

    public void setTransporte(TipoTransporte transporte) {
        this.transporte = transporte;
    }
}
