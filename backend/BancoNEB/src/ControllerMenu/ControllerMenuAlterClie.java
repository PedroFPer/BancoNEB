package ControllerMenu;

public class ControllerMenuAlterClie extends ControllerModelMenu {

    @Override
    protected void exibirMenu() {
        System.out.println("Qual informação você deseja alterar?");
        System.out.println("1. Email");
        System.out.println("2.Telefone");
        System.out.println("3.Senha de Entrada");
        System.out.println("4.Senha de Autorização");
        System.out.println("0-Sair");
    }

    @Override
    protected int quantidEscolha() {

        return 4;
    }

}
