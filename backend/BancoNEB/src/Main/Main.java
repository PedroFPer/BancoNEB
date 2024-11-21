package Main;

import ControlMovFinacClient.ControlMovFinacClient;
import ControllerAlterInfor.ControllerAlterInfor;
import ControllerCadastro.ControllerCadastro;
import ControllerLogin.ControllerLogin;
import ControllerMenu.ControllerMenInicClient;
import ControllerMenu.ControllerMenTelClien;
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
import DTO.NegocEmpresDTO;
import DTO.PagamentPendDOT;
import DTO.ValorDispoEmpresDTO;
import UtilVerif.UtilRela;
import UtilVerif.UtilVericSenhaAutoriz;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        UtilRela utilMovFinacClie = new UtilRela();

        boolean vericSenhaAutor;

        do {

            ControllerMenTelClien controllerMenTelClien = new ControllerMenTelClien();

            int escolhaMenuInicClie = controllerMenTelClien.escolherOpcao();

            switch (escolhaMenuInicClie) {
                case 1:

                    Double saldoAtual = controllerRelatClien.controllerVericSaldoAtual(idCliente);

                    if (saldoAtual != null) {
                        System.out.println("Saldo: " + saldoAtual);

                        scanner.nextLine();
                    } else {
                        System.out.println("Ocorreu um erro na verificação do saldo, por favor tente novamente em instantes");
                    }
                    break;

                case 2:

                    ArrayList<ExtratoDTO> listaDeExtrato = controllerRelatClien.controlExtratoClien(idCliente);

                    if (listaDeExtrato.isEmpty()) {
                        System.out.println("Nenhum dado encontrado");
                    } else {
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
                    }
                    scanner.nextLine();
                    break;

                case 3:
                    controlMovFinacClient.transCliente(idCliente);
                    break;

                case 4:
                    menuCredClien(idCliente);

                    break;

                case 5:
                    menuEmprClien(idCliente);

                    break;
                case 6:
                    ControllerAlterInfor controllerAlterInfor = new ControllerAlterInfor();
                    ControllerMenuAlterClie controllerMenuAlterClie = new ControllerMenuAlterClie();

                    int escolhaAlterClie = controllerMenuAlterClie.escolherOpcao();

                    if (escolhaAlterClie != 0) {
                        controllerAlterInfor.ControllerAlterInfor(idCliente, escolhaAlterClie);
                    }
                    break;

                case 0:
                    System.out.println("Até mais!");
                    System.exit(0);
                    break;

            }
        } while (true);
    }

    public static void menuCredClien(int idCliente) {
        ControlMovFinacClient controlMovFinacClient = new ControlMovFinacClient();
        ControllerRelatClien controllerRelatClien = new ControllerRelatClien();
        UtilVericSenhaAutoriz utilVericSenhaAutoriz = new UtilVericSenhaAutoriz();

        Scanner scanner = new Scanner(System.in);

        int escolhaMenuInicCredit;
        boolean vericSenhaAutor;

        int escolhaPagaCred = -1;
        do {
            ControllerMenuCreditoInicial controllerMenuCreditoInicial = new ControllerMenuCreditoInicial();
            escolhaMenuInicCredit = controllerMenuCreditoInicial.escolherOpcao();
            LocalDate dataAtual = LocalDate.now();

            switch (escolhaMenuInicCredit) {
                case 1:
                    double veriCreditoDisponivel = controllerRelatClien.controlVericCreditoAtual(idCliente);
                    System.out.println("Crédito Disponível: " + veriCreditoDisponivel);
                    break;

                case 2:

                    ArrayList<HisTrasCreDTO> listaHistCred = controllerRelatClien.controlHistCred(idCliente);

                    if (listaHistCred.isEmpty()) {
                        System.out.println("Nenhum dado encontrado");
                    } else {
                        for (HisTrasCreDTO ht : listaHistCred) {

                            System.out.println("Valor da parcela: " + ht.getValorParcela());
                            System.out.println("Mês da Parcela: " + ht.getMesParcela());
                            System.out.println("Ano da Parcela: " + ht.getAnoParcela());
                            System.out.println("Parcela Atual: " + ht.getParcelaAtual());
                            System.out.println("Nome do Beneficiario: " + ht.getNomeBeneficiario());
                            System.out.println("-----------------------------------");
                        }
                    }

                    break;

                case 3:
                    LocalDate dataAtu = LocalDate.now();
                    int ano = dataAtual.getYear();
                    int mes = dataAtual.getMonthValue();

                    ConsultaParcPendAtualDTO consultaParcelaPendCred = controllerRelatClien.controlConsulParcCred(idCliente, mes, ano);
                    String sitFaturCred = consultaParcelaPendCred.getStatus();
                    double valorParcelaMen = consultaParcelaPendCred.getValorTotal();

                    if (consultaParcelaPendCred == null) {
                        System.out.println("Nenhum dado encontrado");
                    } else {

                        if (sitFaturCred.equals("Pago")) {
                            System.out.println("Fatura Paga:");
                            System.out.println("Valor Total: " + consultaParcelaPendCred.getValorTotal());
                            System.out.println("Status Pagamento: " + consultaParcelaPendCred.getStatus());
                            System.out.println("Tipo de Pagamento: " + consultaParcelaPendCred.getTipoFinanc());
                            System.out.println("Mês da Parcela: " + consultaParcelaPendCred.getMes());
                            System.out.println("Ano da Parcela: " + consultaParcelaPendCred.getAno());
                            System.out.println("-----------------------------");
                        } else {

                            do {
                                System.out.println("Fatura Atual:");
                                System.out.println("Valor Total: " + consultaParcelaPendCred.getValorTotal());
                                System.out.println("Status Pagamento: " + consultaParcelaPendCred.getStatus());
                                System.out.println("Tipo de Pagamento: " + consultaParcelaPendCred.getTipoFinanc());
                                System.out.println("Mês da Parcela: " + consultaParcelaPendCred.getMes());
                                System.out.println("Ano da Parcela: " + consultaParcelaPendCred.getAno());
                                System.out.println("-----------------------------");

                                if (consultaParcelaPendCred.getValorTotal() != 0) {
                                    System.out.println("1. Pagar fatura");
                                    System.out.println("0. Sair");

                                    escolhaPagaCred = scanner.nextInt();
                                    scanner.nextLine();

                                    if (escolhaPagaCred == 1) {
                                        double saldoAtualPag = controllerRelatClien.controllerVericSaldoAtual(idCliente);
                                        System.out.println("Saldo atual: " + saldoAtualPag);

                                        System.out.println("Quanto da fatura você deseja pagar?");
                                        double pagaPend = scanner.nextDouble();
                                        scanner.nextLine();

                                        if (pagaPend <= saldoAtualPag && pagaPend <= valorParcelaMen) {
                                            do {
                                                System.out.println("Digite a sua senha de autorização:");
                                                String senhaAutor = scanner.nextLine();
                                                vericSenhaAutor = utilVericSenhaAutoriz.vericCred(idCliente, senhaAutor);

                                                if (vericSenhaAutor) {
                                                    PagamentPendDOT pagamentPendDOT
                                                            = new PagamentPendDOT(idCliente, pagaPend,
                                                                    consultaParcelaPendCred.getIdPagamento(), "Crédito");
                                                    controlMovFinacClient.controlPag(pagamentPendDOT);
                                                    System.out.println("Pagamento efetuado com sucesso!");
                                                    break;
                                                } else {
                                                    System.out.println("Senha incorreta, tente novamente.");
                                                }
                                            } while (!vericSenhaAutor);
                                        } else {
                                            System.out.println("Valor invalido!");
                                        }
                                    }
                                }
                                break;
                            } while (escolhaPagaCred != 0);
                        }
                    }

                    break;

                case 4:
                    System.out.println("Digite o mês da sua fatura:");
                    int mesFatura = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o ano da sua fatura:");
                    int anoFatura = scanner.nextInt();
                    scanner.nextLine();

                    ConsultaParcPendAtualDTO consultaParcPendAtualDTO = controllerRelatClien.controlConsulParcCred(idCliente, mesFatura, anoFatura);

                    if (consultaParcPendAtualDTO == null) {
                        System.out.println("Nenhum dado encontrado");
                    } else {
                        System.out.println("Fatura do mês " + mesFatura + " do ano " + anoFatura + ":");
                        System.out.println("Valor Total: " + consultaParcPendAtualDTO.getValorTotal());
                        System.out.println("Status Pagamento: " + consultaParcPendAtualDTO.getStatus());
                        System.out.println("Tipo de Pagamento: " + consultaParcPendAtualDTO.getTipoFinanc());
                        System.out.println("Mês da Parcela: " + consultaParcPendAtualDTO.getMes());
                        System.out.println("Ano da Parcela: " + consultaParcPendAtualDTO.getAno());
                        System.out.println("-----------------------------");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do menu...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (escolhaMenuInicCredit
                != 0);

    }

    public static void menuEmprClien(int idCliente) {
        ControllerMenuEmprAber controllerMenuEmprAber = new ControllerMenuEmprAber();
        ControllerRelatClien controllerRelatClien = new ControllerRelatClien();
        ControlMovFinacClient controlMovFinacClient = new ControlMovFinacClient();
        UtilVericSenhaAutoriz utilVericSenhaAutoriz = new UtilVericSenhaAutoriz();
        UtilRela utilMovFinacClie = new UtilRela();

        boolean vericSenhaAutor;

        Scanner scanner = new Scanner(System.in);

        EmprestimoAbertDTO emprestimoAbertDTO = controllerRelatClien.controlVericEmprAber(idCliente);

        int escolhaPagaEmpre = -1;

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
                    double valorParcelEmpr = consultaParcelaPendEmpr.getValorTotal();
                    String statuFatEmpr = consultaParcelaPendEmpr.getStatus();

                    do {
                        if (statuFatEmpr.equals("Pago")) {

                            System.out.println("Fatura Atual:");
                            System.out.println("Valor Total: " + consultaParcelaPendEmpr.getValorTotal());
                            System.out.println("Status Pagamento: " + consultaParcelaPendEmpr.getStatus());
                            System.out.println("Tipo de Pagamento: " + consultaParcelaPendEmpr.getTipoFinanc());
                            System.out.println("Mês da Parcela: " + consultaParcelaPendEmpr.getMes());
                            System.out.println("Ano da Parcela: " + consultaParcelaPendEmpr.getAno());
                            System.out.println("-----------------------------");
                            
                            break;
                        } else {
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
                                escolhaPagaEmpre = scanner.nextInt();

                                scanner.nextLine();

                                if (escolhaPagaEmpre == 1) {
                                    Double saldoAtualPag = controllerRelatClien.controllerVericSaldoAtual(idCliente);

                                    System.out.println("Saldo atual = " + saldoAtualPag);
                                    System.out.println("Quanto da fatura você deseja pagar?");
                                    double pagaPend = scanner.nextDouble();

                                    scanner.nextLine();

                                    if (pagaPend < saldoAtualPag && pagaPend > 2 && pagaPend <= valorParcelEmpr) {
                                        do {
                                            System.out.println("Digite a sua senha de autoriazação");
                                            String senhaAutor = scanner.nextLine();

                                            System.out.println("Teste " + consultaParcelaPendEmpr.getIdPagamento());

                                            vericSenhaAutor = utilVericSenhaAutoriz.vericCred(idCliente, senhaAutor);

                                            if (vericSenhaAutor) {
                                                PagamentPendDOT pagamentPendDOT = new PagamentPendDOT(idCliente, pagaPend, consultaParcelaPendEmpr.getIdPagamento(), "Empréstimo");
                                                controlMovFinacClient.controlPag(pagamentPendDOT);

                                            } else {
                                                System.out.println("Senha incorreta, por favor tente novamente");
                                            }
                                        } while (!vericSenhaAutor);

                                    } else {
                                        System.out.println("Valor invalido!");
                                    }

                                }
                                break;
                            } else {
                                break;
                            }
                        }
                    } while (escolhaPagaEmpre != 0);

                    break;

                case 2:
                    ArrayList<ConsuParcPendEmprDTO> listaParcPendEmpr = controllerRelatClien.controlParcPendEmpre(idCliente);

                    if (listaParcPendEmpr.isEmpty()) {
                        System.out.println("Nenhum parcela encontrada");
                    } else {

                        for (ConsuParcPendEmprDTO cppe : listaParcPendEmpr) {
                            System.out.println("Valor Total do Empréstimo: " + cppe.getValorTotalEmpr());
                            System.out.println("Valor da Parcela Mensal: " + cppe.getValorParcMens());
                            System.out.println("Mês da Parcela: " + cppe.getMesParcela());
                            System.out.println("Ano da Parcela: " + cppe.getAnoParcela());
                            System.out.println("Status do Pagamento: " + cppe.getStatusPagam());
                            System.out.println("-----------------------------\n\n");
                        }

                    }
                    break;

                case 3:

                    ArrayList<HistEmprDTO> listaHistEmpr = controllerRelatClien.controlHistorEmpre(idCliente);
                    if (listaHistEmpr.isEmpty()) {
                        System.out.println("Nenhuma parcela encontrada");
                    } else {
                        for (HistEmprDTO he : listaHistEmpr) {

                            System.out.println("Valor total do empréstimo:  " + he.getValTotEmpr());
                            System.out.println("Numero total das parcelas: " + he.getNumParc());
                            System.out.println("Data da negociação: " + he.getDataEmpr());
                            System.out.println("-----------------------------------");
                        }
                    }
                    break;

                case 0:

                    break;

                default:

            }
        } else {
            ValorDispoEmpresDTO valorDispoEmpresDTO = controllerRelatClien.controllValorDispEmprDAO(idCliente);
            double valorDispoEmpr = valorDispoEmpresDTO.getValotDispEmpr();
            int idEmprestimo = valorDispoEmpresDTO.getIdEmprest();
            double valorEmpres;
            int escolhaNegocEmpres;
            int numParcelaEmpre;

            do {
                System.out.println("Valor disponível de empréstimo:");
                System.out.println("Valor Total: " + valorDispoEmpr);
                System.out.println("-----------------------------\n\n");

                System.out.println("Você deseja fazer um empréstimo?");
                System.out.println("1. Sim");
                System.out.println("0. Não");

                escolhaNegocEmpres = scanner.nextInt();
                scanner.nextLine();

                switch (escolhaNegocEmpres) {
                    case 1:
                        do {
                            try {
                                System.out.println("Qual valor você deseja?");
                                valorEmpres = scanner.nextDouble();
                                scanner.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                System.out.println("Entrada inválida. Por favor, insira um valor válido.");
                                scanner.nextLine();
                            }
                        } while (true);

                        if (valorDispoEmpr >= valorEmpres && valorEmpres > 2) {
                            do {
                                try {
                                    System.out.println("Em quantas vezes você gostaria de parcelar?");
                                    for (int i = 1; i <= 6; i++) {
                                        System.out.println(i + " parcela(s) de R$: "
                                                + utilMovFinacClie.utilVericParcel(valorEmpres, i, "Empréstimo"));
                                    }

                                    numParcelaEmpre = scanner.nextInt();
                                    scanner.nextLine();

                                    if (numParcelaEmpre > 0 && numParcelaEmpre <= 6) {
                                        break;
                                    } else {
                                        System.out.println("Número de parcelas inválido. Escolha entre 1 e 6.");
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Formato errado, por favor tente novamente.");
                                    scanner.nextLine();
                                }
                            } while (true);

                            System.out.println("Resumo da negociação do empréstimo:");
                            System.out.println("Valor transação: " + valorEmpres);
                            System.out.println("Número de parcelas: " + numParcelaEmpre + "\n");

                            System.out.println("Deseja finalizar a transação?");
                            System.out.println("1. Sim");
                            System.out.println("2. Não");

                            int escolhaFinaliTran = scanner.nextInt();
                            scanner.nextLine();

                            if (escolhaFinaliTran == 1) {
                                do {
                                    System.out.println("Digite sua senha de autorização:");
                                    String senhaAutoriza = scanner.nextLine();

                                    if (utilVericSenhaAutoriz.vericCred(idCliente, senhaAutoriza)) {
                                        NegocEmpresDTO negocEmpresDTO = new NegocEmpresDTO(idEmprestimo, idCliente, valorEmpres, numParcelaEmpre);
                                        if (controlMovFinacClient.controlNegoEmpr(negocEmpresDTO)) {
                                            System.out.println("Negociação concluída com sucesso.");
                                        } else {
                                            System.out.println("Erro na negociação, tente novamente.");
                                        }
                                        break;
                                    } else {
                                        System.out.println("Senha incorreta.");
                                    }
                                } while (true);
                            } else {
                                System.out.println("Transação cancelada.");
                            }
                        } else {
                            System.out.println("Valor invalido.");
                        }

                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                break;
            } while (escolhaNegocEmpres != 0);

        }

    }
}
