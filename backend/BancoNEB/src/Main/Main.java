package Main;

import ControllerLogin.ControllerLoginCliente;
import ControllerMenu.ControllerMenInicClient;
import ControllerMenu.ControllerMenTipUsua;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {  
        ControllerMenTipUsua menuTipUsua = new ControllerMenTipUsua();

        System.out.println("Bem vindo(a)!");

        int opcaoTipoUsua = menuTipUsua.escolherOpcao();
        
        switch(opcaoTipoUsua){
            case 1:
                menuTipoCliente();
                break;
                
            case 2:
                System.out.println("Funcionario");
                break;
                
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
        }

    }
    
    private static void menuTipoCliente(){
        ControllerMenInicClient menuIniClie = new ControllerMenInicClient();
        
        int opcaoTipClie = menuIniClie.escolherOpcao();
        
            switch(opcaoTipClie){
            case 1:
                ControllerLoginCliente controllerLoginCliente = new ControllerLoginCliente();  
                
                boolean vericEntrada = controllerLoginCliente.loginEntrada();
                
                if(vericEntrada){
                    System.out.println("Funcionou");
                }
                
                break;
            case 2:
                System.out.println("Cadastro");
                break;
                
            case 0:
                System.out.println("Saindo...");
                System.exit(0);
                break;
        }
    }

}
