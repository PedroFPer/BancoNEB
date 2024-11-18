package ControllerRelatorio;



import DTO.ConsultaPagamenPendDTO;
import DTO.ConsultaParcPendAtualDTO;
import DTO.ExtratoDTO;
import DTO.HisTrasCreDTO;
import ServiceRelatorio.ServiceRelatClien;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerRelatClien {

    ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
    Scanner scanner = new Scanner(System.in);

    public ArrayList controlExtratoClien(int idClienteController) {

        ArrayList<ExtratoDTO> listaDeExtrato = serviceRelatClien.serviceExtratoClien(idClienteController);

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
        
        ConsultaPagamenPendDTO consultaPagamenPendDTO = new ConsultaPagamenPendDTO(idClienteController,"Crédito", mesParcControl, anoParcControl);

        ArrayList<HisTrasCreDTO> listaHistCred = serviceRelatClien.serviceHisCreCli(consultaPagamenPendDTO);

        if (!listaHistCred.isEmpty()) {
            return listaHistCred;
        } else {
            return null;
        }

    }

    public ConsultaParcPendAtualDTO controlConsulParcCred(int idCliente, int mes, int ano) {
        String tipoPagamentoControll = "Crédito";
        
        ConsultaPagamenPendDTO consultaPagamenPend = new ConsultaPagamenPendDTO(idCliente,tipoPagamentoControll,mes,ano );
        
        ConsultaParcPendAtualDTO consultaParcPendAtualDTO = serviceRelatClien.serviceConsultParc(consultaPagamenPend);

        return consultaParcPendAtualDTO;
    }

}
