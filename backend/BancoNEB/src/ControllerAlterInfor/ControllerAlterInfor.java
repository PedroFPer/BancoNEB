package ControllerAlterInfor;

import DOT.EnderecoDot;
import ServiceAlterInfor.ServiceAlterInforClie;
import UtilVerif.UtilVericSenha;
import UtilVerif.UtilVericSenhaAutoriz;
import UtilVerif.UtilVerifTelefone;
import java.util.Scanner;

public class ControllerAlterInfor {

    UtilVerifTelefone utilVerifTelefone = new UtilVerifTelefone();
    UtilVericSenhaAutoriz utilVericSenhaAutoriz = new UtilVericSenhaAutoriz();
    ServiceAlterInforClie serviceAlterInforClie = new ServiceAlterInforClie();
    UtilVericSenha utilVericSenha = new UtilVericSenha();
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
                    boolean vericTelefone;
                    String novoTelefone;
                    do {
                        System.out.println("Digite o novo telefone:");
                        novoTelefone = scanner.nextLine();

                        vericTelefone = utilVerifTelefone.vericQuant(novoTelefone);

                        if (!vericTelefone) {
                            System.out.println("Formato incorreto! Por favor, lembre-se de adicionar o DDD e o 9.");
                        }
                    } while (!vericTelefone);
                    boolean vericAlterTelefoneClie = serviceAlterInforClie.serviceAlterTelefoneClie(idClienteController, novoTelefone);

                    if (vericAlterTelefoneClie) {
                        System.out.println("Atualização feita com sucesso!");
                    } else {
                        System.out.println("Ocorreu um problema na atualização do telefone, tente novamente mais tarde.");
                    }

                    break;

                case 3:
                    boolean vericSenhaEntrada;
                    String novaSenhaEntrada;
                    do {
                        System.out.println("Digite a nova senha de entrada:");
                        novaSenhaEntrada = scanner.nextLine();

                        vericSenhaEntrada = utilVericSenha.vericQuant(novaSenhaEntrada);

                        if (!vericSenhaEntrada) {
                            System.out.println("Formato incorreto! A senha deve conter 8 caracteres.");
                        }
                    } while (!vericSenhaEntrada);

                    boolean vericAlterSenhaEntradaClie = serviceAlterInforClie.serviceAlterSenhaEntradaClie(idClienteController, novaSenhaEntrada);

                    if (vericAlterSenhaEntradaClie) {
                        System.out.println("Atualização feita com sucesso!");
                    } else {
                        System.out.println("Ocorreu um problema na atualização da senha de entrada, tente novamente mais tarde.");
                    }

                    break;

                case 4:
                    boolean vericSenhaAutoriz;
                    String novaSenhaAutoriz;
                    do {
                        System.out.println("Digite a nova senha de entrada:");
                        novaSenhaAutoriz = scanner.nextLine();

                        vericSenhaAutoriz = utilVericSenha.vericQuant(novaSenhaAutoriz);

                        if (!vericSenhaAutoriz) {
                            System.out.println("Formato incorreto! A senha deve conter 8 caracteres");
                        }
                    } while (!vericSenhaAutoriz);

                    boolean vericAlterSenhaAutorizacaoClie = serviceAlterInforClie.serviceAlterSenhaAutorizacaoClie(idClienteController, novaSenhaAutoriz);

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
                    System.out.println("Digite o novo logradouro:");
                    String logradouro = scanner.nextLine();

                    System.out.println("Digite o novo bairro:");
                    String bairro = scanner.nextLine();

                    System.out.println("Digite o novo cidade:");
                    String cidade = scanner.nextLine();

                    System.out.println("Digite o novo estado:");
                    String estado = scanner.nextLine();

                    System.out.println("Digite o novo pais:");
                    String pais = scanner.nextLine();

                    System.out.println("Digite o novo referencia:");
                    String referencia = scanner.nextLine();

                    EnderecoDot enderecoDot = new EnderecoDot(logradouro, bairro, cidade, estado, pais, referencia);

                    boolean vericAlterEnder = serviceAlterInforClie.serviceAlterEnderClie(idClienteController, enderecoDot);

                    if (vericAlterEnder) {
                        System.out.println("Atualização feita com sucesso!");
                    } else {
                        System.out.println("Ocorreu um problema na atualização do nome, tente novamente mais tarde.");
                    }

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
