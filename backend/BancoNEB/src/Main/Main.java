package Main;

import ControlMovFinacClient.ControlMovFinacClient;
import ControllerAlterInfor.ControllerAlterInfor;
import ControllerCadastro.ControllerCadastro;
import ControllerLogin.ControllerLogin;
import ControllerMenu.ControllerMenInicClient;
import ControllerMenu.ControllerMenTelClien;
import ControllerMenu.ControllerMenTipUsua;
import ControllerMenu.ControllerMenuAlterClie;
import ControllerMenu.ControllerMenuCreditoInicial;
import ControllerRelatorio.ControllerRelatClien;
import DTO.ConsultaParcPendAtualDTO;
import DTO.ExtratoDTO;
import DTO.HisTrasCreDTO;
import DTO.PagamentPendDOT;
import UtilVerif.UtilVericSenhaAutoriz;
import java.time.LocalDate;
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
        ControllerCadastro controllerCadastro = new ControllerCadastro();

        int opcaoTipClie;

        do {
            opcaoTipClie = menuIniClie.escolherOpcao();

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
                    controllerCadastro.controllerCadastroClie();

                    break;

                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
            }
        } while (opcaoTipClie == 2);
    }

    private static void menuInicClie(Integer idCliente) {
        Scanner scanner = new Scanner(System.in);
        ControlMovFinacClient controlMovFinacClient = new ControlMovFinacClient();
        ControllerRelatClien controllerRelatClien = new ControllerRelatClien();
        UtilVericSenhaAutoriz utilVericSenhaAutoriz = new UtilVericSenhaAutoriz();

        boolean vericSenhaAutor;

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

                    ArrayList<ExtratoDTO> listaDeExtrato = controllerRelatClien.controlExtratoClien(idCliente);

                    for (ExtratoDTO extrato : listaDeExtrato) {

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
                    int escolhaPagaCred = -1;
                    do {
                        ControllerMenuCreditoInicial controllerMenuCreditoInicial = new ControllerMenuCreditoInicial();
                        escolhaMenuInicCredit = controllerMenuCreditoInicial.escolherOpcao();
                        LocalDate dataAtual = LocalDate.now();

                        switch (escolhaMenuInicCredit) {
                            case 1:
                                double veriCreditoDisponivel = controlMovFinacClient.vericCreditoAtual(idCliente);

                                System.out.println("Crédito Disponivel: " + veriCreditoDisponivel);
                                break;

                            case 2:
                                ArrayList<HisTrasCreDTO> listaHistCred = controllerRelatClien.controlHistCred(idCliente);

                                for (HisTrasCreDTO ht : listaHistCred) {

                                    System.out.println("Valor da parcela:  " + ht.getValorParcela());
                                    System.out.println("Mês da Parcela: " + ht.getMesParcela());
                                    System.out.println("Ano da Parcela: " + ht.getAnoParcela());
                                    System.out.println("parcelaAtual;: " + ht.getParcelaAtual());
                                    System.out.println("-----------------------------------");
                                }
                                break;

                            case 3:
                                LocalDate dataAtu = LocalDate.now();

                                int ano = dataAtual.getYear();
                                int mes = dataAtual.getMonthValue();

                                ConsultaParcPendAtualDTO consultaParcelaPendenteDTO = controllerRelatClien.controlConsulParcCred(idCliente, mes, ano);

                                do {
                                    System.out.println("Fatura Atual:");
                                    System.out.println("Valor Total: " + consultaParcelaPendenteDTO.getValorTotal());
                                    System.out.println("Status Pagamento: " + consultaParcelaPendenteDTO.getStatus());
                                    System.out.println("Tipo de Pagamento: " + consultaParcelaPendenteDTO.getTipoFinanc());
                                    System.out.println("Mês da Parcela: " + consultaParcelaPendenteDTO.getMes());
                                    System.out.println("Ano da Parcela: " + consultaParcelaPendenteDTO.getAno());
                                    System.out.println("-----------------------------");

                                    if (consultaParcelaPendenteDTO.getValorTotal() != 0) {

                                        System.out.println("1.Pagar fatura:");
                                        System.out.println("0.Sair");
                                        escolhaPagaCred = scanner.nextInt();

                                        scanner.nextLine();

                                        if (escolhaPagaCred == 1) {
                                            Double saldoAtualPag = controlMovFinacClient.controllerVericSaldoAtual(idCliente);

                                            System.out.println("Saldo atual = " + saldoAtualPag);
                                            System.out.println("Quanto da fatura você deseja pagar?");
                                            double pagaPend = scanner.nextDouble();

                                            scanner.nextLine();

                                            if (pagaPend < saldoAtualPag) {
                                                do {
                                                    System.out.println("Digite a sua senha de autoriazação");
                                                    String senhaAutor = scanner.nextLine();

                                                    vericSenhaAutor = utilVericSenhaAutoriz.vericCred(idCliente, senhaAutor);

                                                    if (vericSenhaAutor) {
                                                        PagamentPendDOT pagamentPendDOT = new PagamentPendDOT(idCliente,pagaPend,consultaParcelaPendenteDTO.getIdPagamento(),"Crédito");
                                                        controlMovFinacClient.controllePag(pagamentPendDOT);

                                                    } else {
                                                        System.out.println("Senha incorreta, por favor tente novamente");
                                                    }
                                                } while (!vericSenhaAutor);

                                            } else {
                                                System.out.println("Saldo insuficiente!");
                                            }

                                        }
                                        break;
                                    } else {
                                        break;
                                    }
                                } while (escolhaPagaCred != 0);

                                break;

                            case 4:

                                System.out.println("Digite o mês da sua fatura");
                                int mesFatura = scanner.nextInt();

                                scanner.nextLine();

                                System.out.println("Digite o ano da sua fatura");
                                int anoFatura = scanner.nextInt();

                                scanner.nextLine();

                                ConsultaParcPendAtualDTO consultaParcPendAtualDTO = controllerRelatClien.controlConsulParcCred(idCliente, mesFatura, anoFatura);

                                System.out.println("Fatura Atual do mês " + mesFatura + " "
                                        + ""
                                        + ":");
                                System.out.println("Valor Total: " + consultaParcPendAtualDTO.getValorTotal());
                                System.out.println("Status Pagamento: " + consultaParcPendAtualDTO.getStatus());
                                System.out.println("Tipo de Pagamento: " + consultaParcPendAtualDTO.getTipoFinanc());
                                System.out.println("Mês da Parcela: " + consultaParcPendAtualDTO.getMes());
                                System.out.println("Ano da Parcela: " + consultaParcPendAtualDTO.getAno());
                                System.out.println("-----------------------------");

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
