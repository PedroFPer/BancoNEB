package ServiceRelatorio;

import DAO.RelatorioDAO;
import DOT.BeneficiarioDTO;
import DTO.ConsultaPagamenPendDTO;
import DTO.ConsultaParcPendAtualDTO;
import DTO.ExtratoDTO;
import DTO.HisTrasCreDTO;

import java.util.ArrayList;

public class ServiceRelatClien {

    RelatorioDAO relatorioDAO = new RelatorioDAO();

    public ArrayList serviceExtratoClien(int idClienteService) {

        ArrayList<ExtratoDTO> listaDeExtrato = relatorioDAO.listaExtratoDAO(idClienteService);

        return listaDeExtrato;

    }

    public BeneficiarioDTO buscarBenef(String cpfBeneficiarioService) {
        BeneficiarioDTO beneficiarioDTO = relatorioDAO.buscarBenef(cpfBeneficiarioService);

        return beneficiarioDTO;
    }

    public ArrayList serviceHisCreCli(ConsultaPagamenPendDTO consultaPagamenPendDTO) {

        ArrayList<HisTrasCreDTO> listaHistCred = relatorioDAO.histTrasCredDAO(consultaPagamenPendDTO);

        return listaHistCred;

    }

    public ConsultaParcPendAtualDTO serviceConsultParc(ConsultaPagamenPendDTO consultaPagamenPendDTO) {
        
        ConsultaParcPendAtualDTO consultaParcelaPendenteDot = relatorioDAO.consultaParcDAO(consultaPagamenPendDTO);

        return consultaParcelaPendenteDot;
    }
    

}
