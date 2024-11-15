package ControllerSaldoClient;

import ServiceSaldoClient.ServiceVericCredito;


public class ControllerVericCredito {

    public Double VericCreditoAtual(int idClienteController) {
        Double creditoAtualController;

        ServiceVericCredito serviceVericCredito = new ServiceVericCredito();
        creditoAtualController = serviceVericCredito.VericCreditoDisp(idClienteController);

        if (creditoAtualController != null) {
            return creditoAtualController;
        } else {
            return null;
        }

    }
}
