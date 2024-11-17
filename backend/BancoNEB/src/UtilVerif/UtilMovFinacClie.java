
package UtilVerif;

import ServiceMovFinacClient.ServiceMovFinacClient;

public class UtilMovFinacClie {
    public Double utilVericParcel( double valorCompraUtil, int numParcelaUtil, String tipoPagamentoUtil){
        ServiceMovFinacClient serviceMovFinacClient = new ServiceMovFinacClient();
        
        double valorParcelaUtil = serviceMovFinacClient.serviceParcValor(valorCompraUtil, numParcelaUtil, tipoPagamentoUtil);
        
        return valorParcelaUtil;
        
    }
}
