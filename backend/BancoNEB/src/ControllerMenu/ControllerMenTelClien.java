
package ControllerMenu;


public class ControllerMenTelClien extends ControllerModelMenu {

    @Override
    protected void exibirMenu() {
            System.out.println("Bem vindo(a)! Como podemos ajuda-lo(a)?");
            System.out.println("1.Visualizar saldo atual");
            System.out.println("2.Extrato");
            System.out.println("3.Transação");
            System.out.println("4.Crédito");
            System.out.println("5.Empréstimo");
            System.out.println("6.Alterar informações pessoais");
            System.out.println("0-Sair");
    }

    @Override
    protected int quantidEscolha() {
        return 6;
    }
    
    
}
