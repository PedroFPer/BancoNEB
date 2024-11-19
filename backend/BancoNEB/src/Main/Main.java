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
import ControllerMenu.ControllerMenuEmprAber;
import ControllerRelatorio.ControllerRelatClien;
import DTO.ConsuParcPendEmprDTO;
import DTO.ConsultaParcPendAtualDTO;
import DTO.EmprestimoAbertDTO;
import DTO.ExtratoDTO;
import DTO.HisTrasCreDTO;
import DTO.HistEmprDTO;
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

                                ConsultaParcPendAtualDTO consultaParcelaPendCred = controllerRelatClien.controlConsulParcCred(idCliente, mes, ano);

                                do {
                                    System.out.println("Fatura Atual:");
                                    System.out.println("Valor Total: " + consultaParcelaPendCred.getValorTotal());
                                    System.out.println("Status Pagamento: " + consultaParcelaPendCred.getStatus());
                                    System.out.println("Tipo de Pagamento: " + consultaParcelaPendCred.getTipoFinanc());
                                    System.out.println("Mês da Parcela: " + consultaParcelaPendCred.getMes());
                                    System.out.println("Ano da Parcela: " + consultaParcelaPendCred.getAno());
                                    System.out.println("-----------------------------");

                                    if (consultaParcelaPendCred.getValorTotal() != 0) {

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
                                                        PagamentPendDOT pagamentPendDOT = new PagamentPendDOT(idCliente, pagaPend, consultaParcelaPendCred.getIdPagamento(), "Crédito");
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
                    ControllerMenuEmprAber controllerMenuEmprAber = new ControllerMenuEmprAber();
                    EmprestimoAbertDTO emprestimoAbertDTO = controllerRelatClien.controlVericEmprAber(idCliente);

                    if (emprestimoAbertDTO != null) {
                        System.out.println("Informações do Empréstimo:");
                        System.out.println("Valor Total do Empréstimo: R$ " + emprestimoAbertDTO.getValTotEmpr());
                        System.out.println("Valor Pendente: R$ " + emprestimoAbertDTO.getValPendEmpr());
                        System.out.println("Data do Empréstimo: " + emprestimoAbertDTO.getDataNegoc());
                        System.out.println("Valor da Parcela Mensal: R$ " + emprestimoAbertDTO.getValorParcMen());
                        System.out.println("Número de Parcelas Pagas: " + emprestimoAbertDTO.getNumParcPaga());
                        System.out.println("Número Total de Parcelas: " + emprestimoAbertDTO.getNumParcTotal());
                        System.out.println("Status do Pagamento: " + emprestimoAbertDTO.getStatuPagam() + "\n\n");

                        int escolhaMenEmprAber = controllerMenuEmprAber.escolherOpcao();

                        switch (escolhaMenEmprAber) {
                            case 1:
                                LocalDate dataA = LocalDate.now();

                                int ano = dataA.getYear();
                                int mes = dataA.getMonthValue();

                                ConsultaParcPendAtualDTO consultaParcelaPendEmpr = controllerRelatClien.controlConsulParcEmpr(idCliente, mes, ano);

                                do {
                                    System.out.println("Fatura Atual:");
                                    System.out.println("Valor Total: " + consultaParcelaPendEmpr.getValorTotal());
                                    System.out.println("Status Pagamento: " + consultaParcelaPendEmpr.getStatus());
                                    System.out.println("Tipo de Pagamento: " + consultaParcelaPendEmpr.getTipoFinanc());
                                    System.out.println("Mês da Parcela: " + consultaParcelaPendEmpr.getMes());
                                    System.out.println("Ano da Parcela: " + consultaParcelaPendEmpr.getAno());
                                    System.out.println("-----------------------------");
                                    
                                    
                                    
                                    
                                    if (consultaParcelaPendEmpr.getValorTotal() != 0) {

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
                                                    
                                                    System.out.println("Teste " + consultaParcelaPendEmpr.getIdPagamento());

                                                    vericSenhaAutor = utilVericSenhaAutoriz.vericCred(idCliente, senhaAutor);

                                                    if (vericSenhaAutor) {
                                                        PagamentPendDOT pagamentPendDOT = new PagamentPendDOT(idCliente, pagaPend, consultaParcelaPendEmpr.getIdPagamento(), "Empréstimo");
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

                            case 2:
                                ArrayList<ConsuParcPendEmprDTO> listaParcPendEmpr = controllerRelatClien.controlParcPendEmpre(idCliente);

                                if (!listaParcPendEmpr.isEmpty()) {
                                    for(ConsuParcPendEmprDTO cppe: listaParcPendEmpr){
                                    System.out.println("Valor Total do Empréstimo: " + cppe.getValorTotalEmpr() );
                                    System.out.println("Valor da Parcela Mensal: " + cppe.getValorParcMens() );
                                    System.out.println("Mês da Parcela: " + cppe.getMesParcela() );
                                    System.out.println("Ano da Parcela: " + cppe.getAnoParcela());
                                    System.out.println("Status do Pagamento: " + cppe.getStatusPagam());
                                    System.out.println("Número de Parcelas: " + cppe.getNumParce());
                                    System.out.println("-----------------------------\n\n");
                                    }
                                } else {
                                    System.out.println("Nenhum parcela encontrada");
                                }
                                break;

                            case 3:
                                ArrayList<HistEmprDTO> listaHistEmpr = controllerRelatClien.controlHistorEmpre(idCliente);

                                for (HistEmprDTO he : listaHistEmpr) {

                                    System.out.println("Valor total do empréstimo:  " + he.getValTotEmpr());
                                    System.out.println("Numero total das parcelas: " + he.getNumParc());
                                    System.out.println("Data da negociação: " + he.getDataEmpr());
                                    System.out.println("-----------------------------------");
                                }
                                break;

                            case 0:

                                break;

                            default:
                          
                        }
                    }else{
                        //Adiconar o valor disponivel para o emprestimo e fazer a negociação
                    }
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
