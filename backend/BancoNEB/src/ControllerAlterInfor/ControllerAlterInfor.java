package ControllerAlterInfor;

import ServiceAlterInfor.ServiceAlterInforClie;
import UtilVerifString.UtilVericSenhaAutoriz;
import java.util.Scanner;

public class ControllerAlterInfor {

    UtilVericSenhaAutoriz utilVericSenhaAutoriz = new UtilVericSenhaAutoriz();
    ServiceAlterInforClie serviceAlterInforClie = new ServiceAlterInforClie();
    Scanner scanner = new Scanner(System.in);

    public void ControllerAlterInfor(int idClienteController, int escolhaAlter) {
        System.out.println("Digite a sua senha de autorização da conta");
        String senhaAutor = scanner.nextLine();

        boolean vericCreden = utilVericSenhaAutoriz.vericCred(idClienteController, senhaAutor);

        if (vericCreden) {
            switch(escolhaAlter){
                case 1:
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();
                    
                    boolean vericAlterNomeClie = serviceAlterInforClie.serviceAlterNomeClie(idClienteController, novoNome);
                    
                    if(vericAlterNomeClie){
                        System.out.println("Atualizão feita com sucesso!");
                        
                        scanner.nextLine();
                    }else{
                        System.out.println("Ocorreu um problema na atualização do nome, tente novamente mais tarde");
                    }
                    
                    break;
                    
                case 2:
                    
                    break;
                    
                case 3:
                    
                    break;
                    
                case 4:
                    
                    break;
                    
                case 5:
                    
                    break;
            }
        }else{
            System.out.println("Senha incorreta, por favor tente novamente");
            
            scanner.nextLine();
        }
        
    }

}
