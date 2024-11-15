
package ControllerMenu;


public class ControllerMenuCreditoInicial extends ControllerModelMenu {

    @Override
    protected void exibirMenu() {
            System.out.println("Crédito:");
            System.out.println("1.Visualizar Crédito Disponivel");
            System.out.println("2.Resumo Parcelas");
            System.out.println("0-Sair");
    }


    @Override
    protected int quantidEscolha() {
       return 2;
    }
    
}
