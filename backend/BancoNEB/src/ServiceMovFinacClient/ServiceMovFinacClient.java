package ServiceMovFinacClient;

import DAO.MovFinacClienDAO;
import DTO.NegocEmpresDTO;
import DTO.PagamentPendDOT;

public class ServiceMovFinacClient {

    MovFinacClienDAO movFinacClienDAO = new MovFinacClienDAO();

    
    public boolean serviceTrasf(int idPagadorService, int idBeneficiarioService, double valorTransaService, String tipoTransaService, int numParcelaService){
        boolean vericTrasan = movFinacClienDAO.transClienDAO(idPagadorService, idBeneficiarioService, valorTransaService, tipoTransaService, numParcelaService);
        return vericTrasan;
    }
    
    public boolean servicePagamParc(PagamentPendDOT pagamentPendDOT){
        boolean veriPagamParc = movFinacClienDAO.pagamPendeDAO(pagamentPendDOT);
        return veriPagamParc;
    }
    
    public boolean serviceNegoEmpr(NegocEmpresDTO negocEmpresDTO){
        boolean veriNegocEmpr = movFinacClienDAO.negocEmpresDAO(negocEmpresDTO);
        return veriNegocEmpr;
    }
    
    

}
