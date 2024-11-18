package ServiceCadastro;

import DAO.CadastroDAO;
import DTO.ClienteDTO;
import DTO.FuncionarioDTO;


public class ServiceCadastro {

    CadastroDAO cadastroDAO = new CadastroDAO();

    public boolean serviceCadastroCliente(ClienteDTO clienteDTO) {
        boolean vericCadasClie = cadastroDAO.cadastroClienteDAO(clienteDTO);
        return vericCadasClie;
    }
    
        public boolean serviceCadastroFuncionario(FuncionarioDTO funcionarioDTO) {
        boolean vericCadasFunc = cadastroDAO.cadastroFuncionarioDAO(funcionarioDTO);
        return vericCadasFunc;
    }

}
