package ServiceSaldoClient;

import DAO.VericSaldoDAO;

public class ServiceVericSaldo {

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
}
