package ControllerMenu;

public class ControllerMenuEmprAber extends ControllerModelMenu {

    @Override
    protected void exibirMenu() {
        System.out.println("Empréstimo:");
        System.out.println("1.Pagar fatura mensal:");
        System.out.println("2.Visualizar parcelas da fatura atual");
        System.out.println("3.Visualizar todos os empréstimos");
        System.out.println("0.Sair");
    }

    @Override
    protected int quantidEscolha() {
        return 3;
    }

}
