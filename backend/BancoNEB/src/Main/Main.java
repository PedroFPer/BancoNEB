package Main;

import ControllerLogin.ControllerLoginCliente;
import ControllerMenu.ControllerMenInicClient;
import ControllerMenu.ControllerMenTelClien;
import ControllerMenu.ControllerMenTipUsua;
import ControllerMenu.ControllerMenuCreditoInicial;
import ControllerSaldoClient.ControllerVericCredito;
import ControllerSaldoClient.ControllerVericSaldo;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ControllerMenTipUsua menuTipUsua = new ControllerMenTipUsua();

        System.out.println("Bem vindo(a)!");

        int opcaoTipoUsua = menuTipUsua.escolherOpcao();

        switch (opcaoTipoUsua) {
            case 1:
                menuTipoCliente();
                break;

            case 2:
                System.out.println("Funcionario");
                break;

            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
        }

    }

    private static void menuTipoCliente() {
        ControllerMenInicClient menuIniClie = new ControllerMenInicClient();

        int opcaoTipClie = menuIniClie.escolherOpcao();

        switch (opcaoTipClie) {
            case 1:
                ControllerLoginCliente controllerLoginCliente = new ControllerLoginCliente();

                Integer idCliente = controllerLoginCliente.loginEntrada();

                if (idCliente != null) {
                    menuInicClie(idCliente);
                }

                break;
            case 2:
                System.out.println("Cadastro");
                break;

            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
        }
    }

    private static void menuInicClie(Integer idCliente) {
        Scanner scanner = new Scanner(System.in);

        do {

            ControllerMenTelClien controllerMenTelClien = new ControllerMenTelClien();

            int escolhaMenuInicClie = controllerMenTelClien.escolherOpcao();
            
            switch (escolhaMenuInicClie) {
                case 1:

                    ControllerVericSaldo controllerVericSaldo = new ControllerVericSaldo();
                    Double saldoAtual = controllerVericSaldo.controllerVericSaldoAtual(idCliente);

                    if (saldoAtual != null) {
                        System.out.println("Saldo: " + saldoAtual);

                        scanner.nextLine();
                    } else {
                        System.out.println("Ocorreu um erro na verificação do saldo, por favor tente novamente em instantes");
                    }
                    break;

                case 2:
                    //Extrato
                    break;

                case 3:
                    //trasaçao
                    break;

                case 4:
                    //credito
                    int escolhaMenuInicCredit;
                    do {
                        ControllerMenuCreditoInicial controllerMenuCreditoInicial = new ControllerMenuCreditoInicial();
                        escolhaMenuInicCredit = controllerMenuCreditoInicial.escolherOpcao();

                        switch (escolhaMenuInicCredit) {
                            case 1:
                                ControllerVericCredito controllerVericCredito = new ControllerVericCredito();
                                double veriCreditoDisponivel = controllerVericCredito.VericCreditoAtual(idCliente);

                                System.out.println("Crédito Disponivel: " + veriCreditoDisponivel);
                                break;

                            case 2:

                                break;

                            case 0:
                                break;
                        }
                    } while (escolhaMenuInicCredit != 0);

                case 5:
                    //emprestimo
                    break;

                case 6:
                    //alterar informaçoes
                    break;

                case 0:

                    break;
            }
        } while (true);

    }
}
