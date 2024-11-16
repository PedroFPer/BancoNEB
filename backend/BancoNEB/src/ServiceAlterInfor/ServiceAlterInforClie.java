
package ServiceAlterInfor;

import DAO.AlterInforClieDAO;


public class ServiceAlterInforClie {
    
    AlterInforClieDAO alterInforClieDAO = new AlterInforClieDAO();
    
    public boolean serviceAlterNomeClie(int idClienteService, String novoNome){
        boolean vericAlterNome = alterInforClieDAO.altNomeClieDAO(idClienteService, novoNome);
        
        return vericAlterNome;
    }
}
