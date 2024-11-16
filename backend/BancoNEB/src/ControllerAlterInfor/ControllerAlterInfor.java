package ControllerAlterInfor;

import ServiceAlterInfor.ServiceAlterInforClie;
import UtilVerifString.UtilVericSenhaAutoriz;
import java.util.Scanner;

public class ControllerAlterInfor {

    UtilVericSenhaAutoriz utilVericSenhaAutoriz = new UtilVericSenhaAutoriz();
    ServiceAlterInforClie serviceAlterInforClie = new ServiceAlterInforClie();
    Scanner scanner = new Scanner(System.in);

    public void ControllerAlterInfor(int idClienteController, int escolhaAlter) {
        System.out.println("Digite a sua senha de autorização da conta");
        String senhaAutor = scanner.nextLine();

        boolean vericCreden = utilVericSenhaAutoriz.vericCred(idClienteController, senhaAutor);

        if (vericCreden) {
            switch (escolhaAlter) {
                case 1:
                    System.out.println("Digite o novo email:");
                    String novoEmail = scanner.nextLine();

                    boolean vericAlterEmailClie = serviceAlterInforClie.serviceAlterEmailClie(idClienteController, novoEmail);

                    if (vericAlterEmailClie) {
                        System.out.println("Atualização feita com sucesso!");
                    } else {
                        System.out.println("Ocorreu um problema na atualização do email, tente novamente mais tarde.");
                    }

                    break;

                case 2:
                    System.out.println("Digite o novo telefone:");
                    String novoTelefone = scanner.nextLine();

                    boolean vericAlterTelefoneClie = serviceAlterInforClie.serviceAlterTelefoneClie(idClienteController, novoTelefone);

                    if (vericAlterTelefoneClie) {
                        System.out.println("Atualização feita com sucesso!");
                    } else {
                        System.out.println("Ocorreu um problema na atualização do telefone, tente novamente mais tarde.");
                    }

                    break;

                case 3:
                    System.out.println("Digite a nova senha de entrada:");
                    String novaSenhaEntrada = scanner.nextLine();

                    boolean vericAlterSenhaEntradaClie = serviceAlterInforClie.serviceAlterSenhaEntradaClie(idClienteController, novaSenhaEntrada);

                    if (vericAlterSenhaEntradaClie) {
                        System.out.println("Atualização feita com sucesso!");
                    } else {
                        System.out.println("Ocorreu um problema na atualização da senha de entrada, tente novamente mais tarde.");
                    }

                    break;

                case 4:
                    System.out.println("Digite a nova senha de autorização:");
                    String novaSenhaAutorizacao = scanner.nextLine();

                    boolean vericAlterSenhaAutorizacaoClie = serviceAlterInforClie.serviceAlterSenhaAutorizacaoClie(idClienteController, novaSenhaAutorizacao);

                    if (vericAlterSenhaAutorizacaoClie) {
                        System.out.println("Atualização feita com sucesso!");
                    } else {
                        System.out.println("Ocorreu um problema na atualização da senha de autorização, tente novamente mais tarde.");
                    }

                    break;

                case 5:
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();

                    boolean vericAlterNomeClie = serviceAlterInforClie.serviceAlterNomeClie(idClienteController, novoNome);

                    if (vericAlterNomeClie) {
                        System.out.println("Atualização feita com sucesso!");
                    } else {
                        System.out.println("Ocorreu um problema na atualização do nome, tente novamente mais tarde.");
                    }

                    break;

                case 6:
                    // Método para alterar endereço - ainda em branco
                    System.out.println("Alteração de endereço ainda não implementada.");
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } else {
            System.out.println("Senha incorreta, por favor tente novamente.");
        }

        scanner.nextLine(); // Pause após o processo
    }
}

