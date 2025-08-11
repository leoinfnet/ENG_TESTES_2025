package br.com.infnet.util;

import br.com.infnet.model.Missao;

public class GeradorDeCodigoMissao {
    public String gerarCodigo(Missao missao) {
        String codigo = "";
        codigo  += missao.getAgencia().substring(0, 1).toUpperCase();
        codigo += "-";
        codigo += missao.getDestino().substring(0,3).toUpperCase();
        codigo += "-";
        codigo += missao.getAno();
        if(missao.isSecreta()){
            codigo += "-X";
        }
        return codigo;
    }
}
