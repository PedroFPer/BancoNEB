
package ControllerMenu;

public class ControllerMenTipUsua extends ControllerModelMenu {
    
    @Override
    public void exibirMenu(){
            System.out.println("Você é cliente ou funcionario?");
            System.out.println("1. Cliente");
            System.out.println("2.Funcionario");
            System.out.println("0-Sair");
    }
    
    @Override
    protected int quantidEscolha(){
        return 2;
    }
}
