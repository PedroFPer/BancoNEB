package ControllerRelatorio;

import DOT.ExtratoDot;
import DOT.HisTrasCreDot;
import ServiceRelatorio.ServiceRelatClien;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerRelatClien {

    ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
    Scanner scanner = new Scanner(System.in);

    public ArrayList controlExtratoClien(int idClienteController) {

        ArrayList<ExtratoDot> listaDeExtrato = serviceRelatClien.serviceExtratoClien(idClienteController);

        if (!listaDeExtrato.isEmpty()) {
            return listaDeExtrato;
        } else {
            return null;
        }

    }

    public ArrayList controlHistCred(int idClienteController) {
        System.out.println("Digite o ano que você deseja visualiza:");
        int anoParcControl = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite o mes que você deseja visualiza:");
        int mesParcControl = scanner.nextInt();

        scanner.nextLine();

        ArrayList<HisTrasCreDot> listaHistCred = serviceRelatClien.serviceHisCreCli(idClienteController, mesParcControl, anoParcControl);

        if (!listaHistCred.isEmpty()) {
            return listaHistCred;
        } else {
            return null;
        }
  
    }

}
