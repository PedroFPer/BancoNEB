package ServiceMovFinacClient;

import DAO.VericCredDAO;
import DAO.VericSaldoDAO;

public class ServiceMovFinacClient {

    public Double serviceVericSaldoAtual(int idClienteService) {
        Double saldoAtualService;

        VericSaldoDAO vericSaldoDAO = new VericSaldoDAO();
        saldoAtualService = vericSaldoDAO.vericSaldoAtualDAO(idClienteService);

        if (saldoAtualService != null) {
            return saldoAtualService;
        } else {
            return null;
        }
    }

    public Double serviceVericCreditDisp(int idClienteService) {
        Double creditoAtualService;

        VericCredDAO vericCredDAO = new VericCredDAO();
        creditoAtualService = vericCredDAO.vericCredDispDAO(idClienteService);

        if (creditoAtualService != null) {
            return creditoAtualService;
        } else {
            return null;
        }
    }
}
