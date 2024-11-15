package ControllerSaldoClient;

import ServiceSaldoClient.ServiceVericSaldo;

public class ControllerVericSaldo {

    public Double controllerVericSaldoAtual(int idClienteController) {
        Double saldoAtualController;

        ServiceVericSaldo serviceVericSaldo = new ServiceVericSaldo();
        saldoAtualController = serviceVericSaldo.serviceVericSaldoAtual(idClienteController);

        if (saldoAtualController != null) {
            return saldoAtualController;
        } else {
            return null;
        }

    }
}
