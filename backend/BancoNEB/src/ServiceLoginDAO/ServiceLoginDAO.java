package ServiceLoginDAO;

import DAO.LoginClienteDAO;



public class ServiceLoginDAO {

    public Integer serviceResqLoginCli(String cpf, String senhaEntrada) {
        LoginClienteDAO loginClienDao = new LoginClienteDAO();

        Integer idClienteServ = loginClienDao.reqLoginClieDAO(cpf,senhaEntrada);
        if (idClienteServ != null) {
            return idClienteServ;
        } else {
            return null;
        }

    }

}
