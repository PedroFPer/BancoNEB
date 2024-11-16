package ServiceMovFinacClient;

import DAO.MovFinacClienDAO;

public class ServiceMovFinacClient {

    MovFinacClienDAO MovFinacClienDAO = new MovFinacClienDAO();
    
    public Double serviceVericSaldoAtual(int idClienteService) {
        Double saldoAtualService;


        saldoAtualService = MovFinacClienDAO.vericSaldoAtualDAO(idClienteService);
        
        return saldoAtualService;

    }

    public Double serviceVericCreditDisp(int idClienteService) {
        Double creditoAtualService;

 
        creditoAtualService = MovFinacClienDAO.vericCredDispDAO(idClienteService);

        return creditoAtualService;

    }
}
