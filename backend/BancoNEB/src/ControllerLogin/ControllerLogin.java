package ControllerLogin;

import UtilVerifString.UtilVericCpf;
import UtilVerifString.UtilVericSenha;
import ServiceLoginDAO.ServiceLoginDAO;
import java.util.Scanner;

public class ControllerLogin {

    Scanner scanner = new Scanner(System.in);

    UtilVericCpf vericCpf = new UtilVericCpf();
    UtilVericSenha vericSenha = new UtilVericSenha();

    public Integer loginEntrada() {
        boolean vericQuantCpf;
        boolean vericQuantSenha;
        String cpf;
        String senha;

        do {
            do {
                System.out.println("Digite o seu cpf:");
                cpf = scanner.nextLine();

                vericQuantCpf = vericCpf.vericQuant(cpf);

                if (vericQuantCpf) {
                    break;
                } else {
                    System.out.println("CPF invalido! CPF precisa de 11 digitos");
                }

            } while (true);

            do {
                System.out.println("Digite sua senha:");
                senha = scanner.nextLine();

                vericQuantSenha = vericSenha.vericQuant(senha);

                if (vericQuantSenha) {
                    break;
                } else {
                    System.out.println("Senha invalida! A senha precisa de 8 digitos");
                }

            } while (true);

            ServiceLoginDAO serviceLoginDAO = new ServiceLoginDAO();

            Integer idClienteControl = serviceLoginDAO.serviceResqLoginCli(cpf, senha);

            if (idClienteControl != null) {
                return idClienteControl;
            } else {
                return null;
            }

        } while (true);
    }

}
