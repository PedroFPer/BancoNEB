package ServiceLoginDAO;

import DAO.LoginClienteDAO;



public class ServiceLoginClienDAO {

    public boolean resqLoginCliDAO(String cpf, String senhaEntrada) {
        LoginClienteDAO loginClienDao = new LoginClienteDAO();

        boolean vericEntrada = loginClienDao.reqLoginClieDAO(cpf,senhaEntrada);
        if (vericEntrada) {
            return true;
        } else {
            return false;
        }

    }

}
