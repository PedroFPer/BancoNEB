package UtilVerifString;

import ServiceVericCreden.ServiceVericCreden;

public class UtilVericSenhaAutoriz {
    public boolean vericCred(int idClienteUtil, String senhaAutorUtil){
        ServiceVericCreden serviceVericCreden = new ServiceVericCreden();
        boolean vericCredencial = serviceVericCreden.serviceVericSenhaAutor(idClienteUtil, senhaAutorUtil);
        
        if(vericCredencial){
            return true; 
        }else{
            return false;
        }
    }
}
