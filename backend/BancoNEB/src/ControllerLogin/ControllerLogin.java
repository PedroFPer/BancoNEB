package ControllerLogin;

import ServiceVericCreden.ServiceVericCreden;
import UtilVerif.UtilVericCpf;
import UtilVerif.UtilVericSenha;

import java.util.Scanner;

public class ControllerLogin {

    Scanner scanner = new Scanner(System.in);
    
    ServiceVericCreden serviceVericCreden = new ServiceVericCreden();

    public Integer loginEntrada(String cpf, String senhaEntra) {

        Integer idClienteControl = serviceVericCreden.serviceResqLoginCli(cpf, senhaEntra);
        return idClienteControl;

    }
}
