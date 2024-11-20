package ControllerRelatorio;

import DTO.ConsuParcPendEmprDTO;
import DTO.ConsultaPagamenPendDTO;
import DTO.ConsultaParcPendAtualDTO;
import DTO.EmprestimoAbertDTO;
import DTO.ExtratoDTO;
import DTO.HisTrasCreDTO;
import DTO.HistEmprDTO;
import DTO.ValorDispoEmpresDTO;
import ServiceRelatorio.ServiceRelatClien;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerRelatClien {

    ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
    Scanner scanner = new Scanner(System.in);

    public ArrayList controlExtratoClien(int idClienteController) {

        ArrayList<ExtratoDTO> listaDeExtrato = serviceRelatClien.serviceExtratoClien(idClienteController);

        return listaDeExtrato;

    }

    public ArrayList controlHistCred(int idClienteController) {
        System.out.println("Digite o ano que você deseja visualiza:");
        int anoParcControl = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite o mes que você deseja visualiza:");
        int mesParcControl = scanner.nextInt();

        scanner.nextLine();

        ConsultaPagamenPendDTO consultaPagamenPendDTO = new ConsultaPagamenPendDTO(idClienteController, "Crédito", mesParcControl, anoParcControl);

        ArrayList<HisTrasCreDTO> listaHistCred = serviceRelatClien.serviceHisCreCli(consultaPagamenPendDTO);

        return listaHistCred;

    }

    public ConsultaParcPendAtualDTO controlConsulParcCred(int idCliente, int mes, int ano) {
        String tipoPagamentoControll = "Crédito";

        ConsultaPagamenPendDTO consultaPagamenPend = new ConsultaPagamenPendDTO(idCliente, tipoPagamentoControll, mes, ano);

        ConsultaParcPendAtualDTO consultaParcPendAtualDTO = serviceRelatClien.serviceConsultParc(consultaPagamenPend);

        return consultaParcPendAtualDTO;
    }

    public ConsultaParcPendAtualDTO controlConsulParcEmpr(int idCliente, int mes, int ano) {
        String tipoPagamentoControll = "Empréstimo";

        ConsultaPagamenPendDTO consultaPagamenPend = new ConsultaPagamenPendDTO(idCliente, tipoPagamentoControll, mes, ano);

        ConsultaParcPendAtualDTO consultaParcPendAtualDTO = serviceRelatClien.serviceConsultParc(consultaPagamenPend);

        return consultaParcPendAtualDTO;
    }

    public EmprestimoAbertDTO controlVericEmprAber(int idClienteControl) {
        EmprestimoAbertDTO emprestimoAbertDTO = serviceRelatClien.serviceVericEmprAber(idClienteControl);

        return emprestimoAbertDTO;
    }

    public ArrayList controlHistorEmpre(int idClienteController) {

        ArrayList<HistEmprDTO> listaHistEmpr = serviceRelatClien.serviceHistorEmpre(idClienteController);

        return listaHistEmpr;

    }

    public ArrayList controlParcPendEmpre(int idClienteController) {

        ArrayList<ConsuParcPendEmprDTO> listaParcPendEmpr = serviceRelatClien.serviceParcPendEmpre(idClienteController);

        return listaParcPendEmpr;

    }

    public ValorDispoEmpresDTO controllValorDispEmprDAO(int idCliente) {
        ValorDispoEmpresDTO valorDispoEmpresDTO = serviceRelatClien.serviceValorDispEmprDAO(idCliente);

        return valorDispoEmpresDTO;
    }

    public Double controllerVericSaldoAtual(int idClienteController) {
        Double saldoAtualController;

        saldoAtualController = serviceRelatClien.serviceVericSaldoAtual(idClienteController);

        if (saldoAtualController != null) {
            return saldoAtualController;
        } else {
            return null;
        }

    }

    public Double controlVericCreditoAtual(int idClienteController) {
        Double creditoAtualController;

        creditoAtualController = serviceRelatClien.serviceVericCreditDisp(idClienteController);

        if (creditoAtualController != null) {
            return creditoAtualController;
        } else {
            return null;
        }

    }
}
