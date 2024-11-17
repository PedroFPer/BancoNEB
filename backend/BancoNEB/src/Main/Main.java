package Main;

import ControlMovFinacClient.ControlMovFinacClient;
import ControllerAlterInfor.ControllerAlterInfor;
import ControllerLogin.ControllerLogin;
import ControllerMenu.ControllerMenInicClient;
import ControllerMenu.ControllerMenTelClien;
import ControllerMenu.ControllerMenTipUsua;
import ControllerMenu.ControllerMenuAlterClie;
import ControllerMenu.ControllerMenuCreditoInicial;
import ControllerRelatorio.ControllerRelatClien;
import DOT.ExtratoDot;
import DOT.FuncionarioDot;
import DOT.HisTrasCreDot;
import java.util.ArrayList;

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
                ControllerLogin controllerLoginCliente = new ControllerLogin();
                Integer idCliente;
                do {
                    idCliente = controllerLoginCliente.loginEntrada();

                    if (idCliente != null) {
                        menuInicClie(idCliente);
                    } else {
                        System.out.println("Credenciais incorretas, por favor tente novamente.");
                    }
                } while (idCliente == null);
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
        ControlMovFinacClient controlMovFinacClient = new ControlMovFinacClient();
        ControllerRelatClien controllerRelatClien = new ControllerRelatClien();

        do {

            ControllerMenTelClien controllerMenTelClien = new ControllerMenTelClien();

            int escolhaMenuInicClie = controllerMenTelClien.escolherOpcao();

            switch (escolhaMenuInicClie) {
                case 1:

                    Double saldoAtual = controlMovFinacClient.controllerVericSaldoAtual(idCliente);

                    if (saldoAtual != null) {
                        System.out.println("Saldo: " + saldoAtual);

                        scanner.nextLine();
                    } else {
                        System.out.println("Ocorreu um erro na verificação do saldo, por favor tente novamente em instantes");
                    }
                    break;

                case 2:

                    ArrayList<ExtratoDot> listaDeExtrato = controllerRelatClien.controlExtratoClien(idCliente);

                    for (ExtratoDot extrato : listaDeExtrato) {

                        System.out.println("Nome do Pagador: " + extrato.getNomePagador());
                        System.out.println("Valor da Transação: " + extrato.getValorTrasancao());
                        System.out.println("Tipo de Pagamento: " + extrato.getTipoPagamento());
                        System.out.println("Número da Parcela Atual: " + extrato.getNumParcelaAtual());
                        System.out.println("Número Total de Parcelas: " + extrato.getNumParcelaTotal());
                        System.out.println("Nome do Beneficiário: " + extrato.getNomeBeneficiario());
                        System.out.println("Data da Transação: " + extrato.getData_transacao());
                        System.out.println("Hora da Transação: " + extrato.getHora_transacao());
                        System.out.println("-----------------------------------");
                    }

                    scanner.nextLine();
                    break;

                case 3:
                    controlMovFinacClient.transCliente(idCliente);
                    break;

                case 4:
                    //credito
                    int escolhaMenuInicCredit;
                    do {
                        ControllerMenuCreditoInicial controllerMenuCreditoInicial = new ControllerMenuCreditoInicial();
                        escolhaMenuInicCredit = controllerMenuCreditoInicial.escolherOpcao();

                        switch (escolhaMenuInicCredit) {
                            case 1:
                                double veriCreditoDisponivel = controlMovFinacClient.vericCreditoAtual(idCliente);

                                System.out.println("Crédito Disponivel: " + veriCreditoDisponivel);
                                break;

                            case 2:
                                ArrayList<HisTrasCreDot> listaHistCred = controllerRelatClien.controlHistCred(idCliente);

                                for (HisTrasCreDot ht : listaHistCred) {

                                    System.out.println("Valor da parcela:  " + ht.getValorParcela());
                                    System.out.println("Mês da Parcela: " + ht.getMesParcela());
                                    System.out.println("Ano da Parcela: " + ht.getAnoParcela());
                                    System.out.println("parcelaAtual;: " + ht.getParcelaAtual());
                                    System.out.println("-----------------------------------");
                                }
                                break;

                            case 3:

                                break;

                            case 0:
                                break;
                        }
                    } while (escolhaMenuInicCredit != 0);

                case 5:
                    //emprestimo
                    break;

                case 6:
                    ControllerAlterInfor controllerAlterInfor = new ControllerAlterInfor();
                    ControllerMenuAlterClie controllerMenuAlterClie = new ControllerMenuAlterClie();

                    int escolhaAlterClie = controllerMenuAlterClie.escolherOpcao();

                    if (escolhaAlterClie != 0) {
                        controllerAlterInfor.ControllerAlterInfor(idCliente, escolhaAlterClie);
                    } else {

                    }
                    break;

                case 0:
                    System.out.println("Até mais!");
                    System.exit(0);
                    break;
            }
        } while (true);

    }
}
