package ControllerLogin;

import UtilVerifString.UtilVericCpf;
import UtilVerifString.UtilVericSenha;
import ServiceLoginDAO.ServiceLoginClienDAO;
import java.util.Scanner;

public class ControllerLoginCliente {

    Scanner scanner = new Scanner(System.in);

    UtilVericCpf vericCpf = new UtilVericCpf();
    UtilVericSenha vericSenha = new UtilVericSenha();

    public boolean loginEntrada() {
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

            ServiceLoginClienDAO serviceLoginClienDao = new ServiceLoginClienDAO();

            boolean vericEntradaDao = serviceLoginClienDao.resqLoginCliDAO(cpf, senha);

            if (vericEntradaDao) {
                return true;
            } else {
                return false;
            }

        } while (true);
    }

}
