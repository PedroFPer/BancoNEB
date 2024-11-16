package ControlMovFinacClient;

import DOT.BeneficiarioDot;
import ServiceMovFinacClient.ServiceMovFinacClient;
import ServiceRelatorio.ServiceRelatClien;
import java.util.Scanner;

public class ControlMovFinacClient {

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

        do {
            System.out.println("A transação vai ser no crédito ou no debito?");
            System.out.println("1.Crédito:");
            System.out.println("2.Débito:");
            escolhaTipoPagamento = scanner.nextInt();

            scanner.nextLine();

            switch (escolhaTipoPagamento) {
                case 1:
                    System.out.println("Qual valor você deseja transferi usando o crédito?");
                    int valorTransCredito = scanner.nextInt();

                    scanner.nextLine();

                    double valorCreditoAtual = vericCreditoAtual(idClienteControll);

                    if (valorCreditoAtual > valorTransCredito) {
                        System.out.println("Digite o cpf do benefeciario da transação");
                        String cpfBeneficiario = scanner.nextLine();
                        
                        ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
                        BeneficiarioDot beneficiarioDot = serviceRelatClien.buscarBenef(cpfBeneficiario);
                        
                        System.out.println("Esse é o usuario correto?");
                        System.out.println("Nome: " + beneficiarioDot.getNomeBeneficiario());
                        System.out.println("1.Sim");
                        System.out.println("2.Não");
                        
                        int confirmBenen = scanner.nextInt();
                        
                        scanner.nextLine();
                        
                        if(confirmBenen == 1 ){
                            System.out.println("Continua");
                        }else{
                            System.out.println("Para");
                        }

                        
                    } else {
                        System.out.println("Erro");
                    }
                    break;

                case 2:

                    break;

                case 0:

                    break;
                default:

                    break;
            }
        } while (escolhaTipoPagamento != 0);
    }
}
