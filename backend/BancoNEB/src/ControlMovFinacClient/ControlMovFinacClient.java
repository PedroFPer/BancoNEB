package ControlMovFinacClient;

import DOT.BeneficiarioDot;
import ServiceMovFinacClient.ServiceMovFinacClient;
import ServiceRelatorio.ServiceRelatClien;
import UtilVerif.UtilMovFinacClie;
import UtilVerif.UtilVericSenhaAutoriz;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControlMovFinacClient {

    UtilVericSenhaAutoriz utilVericSenhaAutoriz = new UtilVericSenhaAutoriz();
    ServiceMovFinacClient serviceMovFinacClient = new ServiceMovFinacClient();
    Scanner scanner = new Scanner(System.in);

    public Double controllerVericSaldoAtual(int idClienteController) {
        Double saldoAtualController;

        saldoAtualController = serviceMovFinacClient.serviceVericSaldoAtual(idClienteController);

        if (saldoAtualController != null) {
            return saldoAtualController;
        } else {
            return null;
        }

    }

    public Double vericCreditoAtual(int idClienteController) {
        Double creditoAtualController;

        creditoAtualController = serviceMovFinacClient.serviceVericCreditDisp(idClienteController);

        if (creditoAtualController != null) {
            return creditoAtualController;
        } else {
            return null;
        }

    }

    public void transCliente(int idClienteControll) {
        int escolhaTipoPagamento;
        int numParcela;
        int idBeneficiario;

        do {
            System.out.println("A transação vai ser no crédito ou no debito?");
            System.out.println("1.Crédito:");
            System.out.println("2.Débito:");
            escolhaTipoPagamento = scanner.nextInt();

            scanner.nextLine();

            switch (escolhaTipoPagamento) {
                case 1:
                    System.out.println("Qual valor você deseja transferi usando o crédito?");
                    double valorTransCredito = scanner.nextInt();

                    scanner.nextLine();

                    double valorCreditoAtual = vericCreditoAtual(idClienteControll);

                    if (valorCreditoAtual > valorTransCredito) {
                        UtilMovFinacClie utilMovFinacClie = new UtilMovFinacClie();
                        do {
                            try {
                                System.out.println("Em quantas vezes você gostaria de parcelar?");

                                for (int i = 1; i <= 6; i++) {
                                    System.out.println("Iteração do for: " + i);
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

                        System.out.println("Digite o cpf do benefeciario da transação");
                        String cpfBeneficiario = scanner.nextLine();

                        ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
                        BeneficiarioDot beneficiarioDot = serviceRelatClien.buscarBenef(cpfBeneficiario);

                        idBeneficiario = beneficiarioDot.getIdBeneficiario();

                        System.out.println("Esse é o usuario correto?");
                        System.out.println("Nome: " + beneficiarioDot.getNomeBeneficiario());
                        System.out.println("1.Sim");
                        System.out.println("2.Não");

                        int confirmBenen = scanner.nextInt();

                        scanner.nextLine();

                        if (confirmBenen == 1) {

                            System.out.println("Resumo da transação:");
                            System.out.println("Befeficiario: " + beneficiarioDot.getNomeBeneficiario());
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

                        } else {
                            System.out.println("Para");
                        }

                    } else {
                        System.out.println("Saldo insuficiente!");
                    }
                    break;

                case 2:
                    System.out.println("Qual valor você deseja transferi usando o debito:");
                    double valorTransDebito = scanner.nextInt();

                    scanner.nextLine();

                    double valorSaldoAtual = controllerVericSaldoAtual(idClienteControll);

                    if (valorSaldoAtual > valorTransDebito) {
                        UtilMovFinacClie utilMovFinacClie = new UtilMovFinacClie();

                        System.out.println("Digite o cpf do benefeciario da transação");
                        String cpfBeneficiario = scanner.nextLine();

                        ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
                        BeneficiarioDot beneficiarioDot = serviceRelatClien.buscarBenef(cpfBeneficiario);

                        idBeneficiario = beneficiarioDot.getIdBeneficiario();

                        System.out.println("Esse é o usuario correto?");
                        System.out.println("Nome: " + beneficiarioDot.getNomeBeneficiario());
                        System.out.println("1.Sim");
                        System.out.println("2.Não");

                        int confirmBenen = scanner.nextInt();

                        scanner.nextLine();

                        if (confirmBenen == 1) {

                            System.out.println("Resumo da transação:");
                            System.out.println("Befeficiario: " + beneficiarioDot.getNomeBeneficiario());
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
                        System.out.println("Saldo insuficiente!");
                    }

                    break;

                case 0:

                    break;
                default:

                    break;
            }
            break;
        } while (escolhaTipoPagamento != 0);
    }
}
