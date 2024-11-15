package ServiceSaldoClient;

import DAO.VericCredDAO;


public class ServiceVericCredito {

    public Double VericCreditoDisp(int idClienteService) {
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
