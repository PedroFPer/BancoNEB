package ServiceRelatorio;

import DAO.RelatorioDAO;
import DOT.BeneficiarioDTO;
import DTO.ConsuParcPendEmprDTO;
import DTO.ConsultaPagamenPendDTO;
import DTO.ConsultaParcPendAtualDTO;
import DTO.EmprestimoAbertDTO;
import DTO.ExtratoDTO;
import DTO.HisTrasCreDTO;
import DTO.HistEmprDTO;
import DTO.ValorDispoEmpresDTO;

import java.util.ArrayList;

public class ServiceRelatClien {

    RelatorioDAO relatorioDAO = new RelatorioDAO();

    public ArrayList serviceExtratoClien(int idClienteService) {

        ArrayList<ExtratoDTO> listaDeExtrato = relatorioDAO.listaExtratoDAO(idClienteService);

        return listaDeExtrato;

    }

    public BeneficiarioDTO buscarBenef(String cpfBeneficiarioService) {
        BeneficiarioDTO beneficiarioDTO = relatorioDAO.buscarBenefDAO(cpfBeneficiarioService);

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

    public EmprestimoAbertDTO serviceVericEmprAber(int idClienteService) {
        EmprestimoAbertDTO emprestimoAbertDTO = relatorioDAO.vericEmprestAberDAO(idClienteService);

        return emprestimoAbertDTO;
    }

    public ArrayList serviceHistorEmpre(int idClienteService) {

        ArrayList<HistEmprDTO> listaHistEmpr = relatorioDAO.historEmpreDAO(idClienteService);

        return listaHistEmpr;

    }

    public ArrayList serviceParcPendEmpre(int idClienteService) {

        ArrayList<ConsuParcPendEmprDTO> listaParcPendEmpr = relatorioDAO.parcPendEmpreDAO(idClienteService);

        return listaParcPendEmpr;

    }
    
    public ValorDispoEmpresDTO serviceValorDispEmprDAO(int idCliente){
        ValorDispoEmpresDTO valorDispoEmpresDTO = relatorioDAO.valorDispEmprDAO(idCliente);
        
        return valorDispoEmpresDTO;
    }
    
        
    public Double serviceVericSaldoAtual(int idClienteService) {

        Double saldoAtualService = relatorioDAO.vericSaldoAtualDAO(idClienteService);
        
        return saldoAtualService;

    }

    public Double serviceVericCreditDisp(int idClienteService) {
  
        Double creditoAtualService = relatorioDAO.vericCredDispDAO(idClienteService);

        return creditoAtualService;

    }
    
    public Double serviceParcValor(double valorCompraService, int numParcelaService, String tipoPagamentoService){
         double valorParcela = relatorioDAO.vericParcelaDAO(valorCompraService, numParcelaService, tipoPagamentoService);
         
         return valorParcela;
    }
    
    public boolean serviceVericCpfExis(String cpf){
        boolean serviceCpfExis = relatorioDAO.vericCpfExisDAO(cpf);
        
        return serviceCpfExis;
    }
}
