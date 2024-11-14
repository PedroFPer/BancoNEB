package ServiceLoginDAO;

import DAO.LoginClienteDAO;

public class ServiceLoginClienDAO {

    public boolean resqLoginCliDAO(String cpf, String senha) {
        LoginClienteDAO loginClienDao = new LoginClienteDAO(cpf, senha);

        boolean vericEntrada = loginClienDao.resulConsultaBanco();
        if (vericEntrada) {
            return true;
        } else {
            return false;
        }

    }

}
