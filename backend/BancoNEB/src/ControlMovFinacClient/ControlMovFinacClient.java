package ControlMovFinacClient;

import ServiceMovFinacClient.ServiceMovFinacClient;

public class ControlMovFinacClient {

    ServiceMovFinacClient serviceMovFinacClient = new ServiceMovFinacClient(); 
    
    public Double controllerVericSaldoAtual(int idClienteController) {
        Double saldoAtualController;

        saldoAtualController = serviceMovFinacClient.serviceVericSaldoAtual(idClienteController);

        if (saldoAtualController != null) {
            return saldoAtualController;
        } else {
            return null;
        }

    }

    public Double VericCreditoAtual(int idClienteController) {
        Double creditoAtualController;

        creditoAtualController = serviceMovFinacClient.serviceVericCreditDisp(idClienteController);

        if (creditoAtualController != null) {
            return creditoAtualController;
        } else {
            return null;
        }

    }
}
