
package ControllerMenu;

public class ControllerMenInicClient extends ControllerModelMenu {
    @Override
    public void exibirMenu(){
        System.out.println("Que bom te ver por aqui!");
        System.out.println("1.Acessar minha conta");
        System.out.println("2.Quero ser cliente");
        System.out.println("0-Sair");        
    }
    
    @Override
    public int quantidEscolha(){
        return 2;
    }
    
    
}
