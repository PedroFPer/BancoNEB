package ControlMovFinacClient;

import ControllerRelatorio.ControllerRelatClien;
import DOT.BeneficiarioDTO;
import DTO.NegocEmpresDTO;
import DTO.PagamentPendDOT;
import ServiceMovFinacClient.ServiceMovFinacClient;
import ServiceRelatorio.ServiceRelatClien;
import UtilVerif.UtilRela;
import UtilVerif.UtilVericSenhaAutoriz;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlMovFinacClient {

    UtilVericSenhaAutoriz utilVericSenhaAutoriz = new UtilVericSenhaAutoriz();
    ServiceMovFinacClient serviceMovFinacClient = new ServiceMovFinacClient();
    ServiceRelatClien serviceRelatClien = new ServiceRelatClien();

    Scanner scanner = new Scanner(System.in);

    public void transCliente(int idClienteControll) {
        ControllerRelatClien controllerRelatClien = new ControllerRelatClien();

        int escolhaTipoPagamento;
        int numParcela;
        int idBeneficiario = 0;
        boolean vericBeneficiario;

        do {
            System.out.println("A transação vai ser no crédito ou no debito?");
            System.out.println("1.Crédito:");
            System.out.println("2.Débito:");
            System.out.println("0.Voltar o Menu");
            escolhaTipoPagamento = scanner.nextInt();

            scanner.nextLine();

            switch (escolhaTipoPagamento) {
                case 1:
                    String cpfBeneficCred;

                    System.out.println("Qual valor você deseja transferi usando o crédito?");
                    double valorTransCredito = scanner.nextInt();

                    scanner.nextLine();

                    double valorCreditoAtual = controllerRelatClien.controlVericCreditoAtual(idClienteControll);

                    if (valorCreditoAtual >= valorTransCredito && valorTransCredito > 2) {
                        UtilRela utilMovFinacClie = new UtilRela();
                        do {
                            try {
                                System.out.println("Em quantas vezes você gostaria de parcelar?");

                                for (int i = 1; i <= 6; i++) {

                                    System.out.println(i + " parcela(s) de R$: "
                                            + utilMovFinacClie.utilVericParcel(valorTransCredito, i, "Crédito"));
                                }

                                numParcela = scanner.nextInt();
                                scanner.nextLine();

                                if (numParcela > 0 && numParcela <= 6) {
                                    break;
                                } else {
                                    System.out.println("Número de parcelas inválido. Escolha entre 1 e 6.");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Formato errado, por favor tente novamente.");
                                scanner.nextLine();
                            }

                        } while (true);

                        do {

                            System.out.println("Digite o cpf do benefeciario da transação");
                            cpfBeneficCred = scanner.nextLine();

                            vericBeneficiario = serviceRelatClien.serviceVericCpfExis(cpfBeneficCred);

                            if (!vericBeneficiario) {
                                System.out.println("Usuario não encontrado, por favor tente novamente");
                            } else {
                                break;
                            }

                        } while (true);

                        ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
                        BeneficiarioDTO beneficiarioDTO = serviceRelatClien.buscarBenef(cpfBeneficCred);

                        idBeneficiario = beneficiarioDTO.getIdBeneficiario();

                        System.out.println("Esse é o usuario correto?");
                        System.out.println("Nome: " + beneficiarioDTO.getNomeBeneficiario());
                        System.out.println("1.Sim");
                        System.out.println("2.Não");

                        int confirmBenen = scanner.nextInt();

                        scanner.nextLine();

                        if (confirmBenen == 1) {

                            System.out.println("Resumo da transação:");
                            System.out.println("Befeficiario: " + beneficiarioDTO.getNomeBeneficiario());
                            System.out.println("Valor transação: " + valorTransCredito);
                            System.out.println("Tipo de pagamento: Crédito");
                            System.out.println("Número de parcelas:" + numParcela + "\n\n");

                            System.out.println("Deseja finalizar a transação?");
                            System.out.println("1.Sim");
                            System.out.println("2.Não");
                            int escolhaFinaliTran = scanner.nextInt();

                            scanner.nextLine();

                            switch (escolhaFinaliTran) {
                                case 1:

                                    do {
                                        System.out.println("Por favor digite a sua senha de autorização");
                                        String senhaAutoriza = scanner.nextLine();

                                        boolean vericSenhaAutor = utilVericSenhaAutoriz.vericCred(idClienteControll, senhaAutoriza);

                                        if (vericSenhaAutor) {
                                            boolean vericTrans = serviceMovFinacClient.serviceTrasf(idClienteControll, idBeneficiario, valorTransCredito, "Crédito", numParcela);

                                            if (vericTrans) {
                                                System.out.println("Transação feita com sucesso");

                                            } else {
                                                System.out.println("Ocorreu uma erro na transação, por favor tente novamente em instantes");
                                            }
                                            break;
                                        }

                                    } while (true);

                                case 2:
                                    break;

                                default:
                                    System.out.println("Entrada incorreta, por favor tente novamente");

                            }

                        }

                    } else {
                        System.out.println("Valor invalido!");
                    }
                    break;

                case 2:
                    System.out.println("Qual valor você deseja transferi usando o debito:");
                    double valorTransDebito = scanner.nextInt();
                    String cpfBenefiDebit;

                    scanner.nextLine();

                    double valorSaldoAtual = controllerRelatClien.controllerVericSaldoAtual(idClienteControll);

                    if (valorSaldoAtual >= valorTransDebito && valorTransDebito > 2) {
                        UtilRela utilMovFinacClie = new UtilRela();

                        do {

                            System.out.println("Digite o cpf do benefeciario da transação");
                            cpfBenefiDebit = scanner.nextLine();

                            vericBeneficiario = serviceRelatClien.serviceVericCpfExis(cpfBenefiDebit);

                            if (!vericBeneficiario) {
                                System.out.println("Usuario não encontrado, por favor tente novamente");
                            } else {
                                break;
                            }

                        } while (true);

                        ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
                        BeneficiarioDTO beneficiarioDTO = serviceRelatClien.buscarBenef(cpfBenefiDebit);

                        idBeneficiario = beneficiarioDTO.getIdBeneficiario();

                        System.out.println("Esse é o usuario correto?");
                        System.out.println("Nome: " + beneficiarioDTO.getNomeBeneficiario());
                        System.out.println("1.Sim");
                        System.out.println("2.Não");

                        int confirmBenen = scanner.nextInt();

                        scanner.nextLine();

                        if (confirmBenen == 1) {

                            System.out.println("Resumo da transação:");
                            System.out.println("Befeficiario: " + beneficiarioDTO.getNomeBeneficiario());
                            System.out.println("Valor transação: " + valorTransDebito);
                            System.out.println("Tipo de pagamento: Débito");

                            System.out.println("Deseja finalizar a transação?");
                            System.out.println("1.Sim");
                            System.out.println("2.Não");
                            int escolhaFinaliTran = scanner.nextInt();

                            scanner.nextLine();

                            switch (escolhaFinaliTran) {
                                case 1:

                                    do {
                                        System.out.println("Por favor digite a sua senha de autorização");
                                        String senhaAutoriza = scanner.nextLine();

                                        boolean vericSenhaAutor = utilVericSenhaAutoriz.vericCred(idClienteControll, senhaAutoriza);

                                        if (vericSenhaAutor) {
                                            boolean vericTrans = serviceMovFinacClient.serviceTrasf(idClienteControll, idBeneficiario, valorTransDebito, "Débito", 0);

                                            if (vericTrans) {
                                                System.out.println("Transação feita com sucesso");

                                            } else {
                                                System.out.println("Ocorreu uma erro na transação, por favor tente novamente em instantes");
                                            }
                                            break;
                                        }

                                    } while (true);

                                case 2:
                                    break;

                                default:
                                    System.out.println("Entrada incorreta, por favor tente novamente");

                            }

                        } else {
                            System.out.println("Para");
                        }

                    } else {
                        System.out.println("Valor invalido!");
                    }

                    break;

                case 0:

                    break;
                default:
                    System.out.println("Escolha incorreta!");
                    break;
            }
            break;
        } while (escolhaTipoPagamento != 0);
    }

    public boolean controlPag(PagamentPendDOT pagamentPendDOT) {
        boolean vericPagaCred = serviceMovFinacClient.servicePagamParc(pagamentPendDOT);

        return vericPagaCred;

    }

    public boolean controlNegoEmpr(NegocEmpresDTO negocEmpresDTO) {
        boolean veriNegocEmpr = serviceMovFinacClient.serviceNegoEmpr(negocEmpresDTO);
        return veriNegocEmpr;
    }
}
