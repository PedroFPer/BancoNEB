package ServiceCadastro;

import DAO.CadastroDAO;
import DOT.ClienteDot;
import DOT.FuncionarioDot;

public class ServiceCadastro {

    CadastroDAO cadastroDAO = new CadastroDAO();

    public boolean serviceCadastroCliente(ClienteDot clienteDot) {
        boolean vericCadasClie = cadastroDAO.cadastroClienteDAO(clienteDot);
        return vericCadasClie;
    }
    
        public boolean serviceCadastroFuncionario(FuncionarioDot funcionarioDot) {
        boolean vericCadasFunc = cadastroDAO.cadastroFuncionarioDAO(funcionarioDot);
        return vericCadasFunc;
    }

}
