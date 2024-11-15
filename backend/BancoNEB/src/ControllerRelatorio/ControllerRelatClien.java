
package ControllerRelatorio;


import DOT.ExtratoDot;
import ServiceRelatorio.ServiceRelatClien;
import java.util.ArrayList;


public class ControllerRelatClien {
       public ArrayList controlExtratoClien(int idClienteController) {

        ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
        ArrayList<ExtratoDot> listaDeExtrato = serviceRelatClien.serviceExtratoClien(idClienteController);

        if (!listaDeExtrato.isEmpty()) {
            return listaDeExtrato;
        } else {
            return null;
        }

    } 
}
