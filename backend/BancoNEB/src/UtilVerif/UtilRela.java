
package UtilVerif;

import ServiceMovFinacClient.ServiceMovFinacClient;
import ServiceRelatorio.ServiceRelatClien;

public class UtilRela {
    public Double utilVericParcel( double valorCompraUtil, int numParcelaUtil, String tipoPagamentoUtil){
        ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
        
        double valorParcelaUtil = serviceRelatClien.serviceParcValor(valorCompraUtil, numParcelaUtil, tipoPagamentoUtil);
        
        return valorParcelaUtil;
        
    }
}
