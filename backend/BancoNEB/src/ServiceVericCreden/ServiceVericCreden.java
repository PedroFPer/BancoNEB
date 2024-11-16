package ServiceVericCreden;

import DAO.VericCredenDAO;



public class ServiceVericCreden {

    VericCredenDAO vericCredenDAO = new VericCredenDAO();
    
    public Integer serviceResqLoginCli(String cpf, String senhaEntrada) {

        Integer idClienteServ = vericCredenDAO.reqLoginClieDAO(cpf, senhaEntrada);
        return idClienteServ;

    }

    public boolean serviceVericSenhaAutor(int idClienteService, String senhaAutor) {
        
        boolean vericCreden = vericCredenDAO.vericSenhaDao(idClienteService, senhaAutor);

        return vericCreden;
    }
}
