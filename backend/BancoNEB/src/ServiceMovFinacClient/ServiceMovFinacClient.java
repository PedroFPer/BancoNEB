package ServiceMovFinacClient;

import DAO.MovFinacClienDAO;

public class ServiceMovFinacClient {

    MovFinacClienDAO movFinacClienDAO = new MovFinacClienDAO();
    
    public Double serviceVericSaldoAtual(int idClienteService) {

        Double saldoAtualService = movFinacClienDAO.vericSaldoAtualDAO(idClienteService);
        
        return saldoAtualService;

    }

    public Double serviceVericCreditDisp(int idClienteService) {
  
        Double creditoAtualService = movFinacClienDAO.vericCredDispDAO(idClienteService);

        return creditoAtualService;

    }

}
