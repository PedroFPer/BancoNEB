package ServiceRelatorio;


import DAO.RelatorioDAO;
import DOT.BeneficiarioDot;
import DOT.ExtratoDot;
import java.util.ArrayList;

public class ServiceRelatClien {
    
    RelatorioDAO relatorioDAO = new RelatorioDAO();
    
    public ArrayList serviceExtratoClien(int idClienteService) {

        ArrayList<ExtratoDot> listaDeExtrato = relatorioDAO.listaExtratoDAO(idClienteService);

        return listaDeExtrato;

    }
    
    public BeneficiarioDot buscarBenef(String cpfBeneficiarioService){
        BeneficiarioDot beneficiarioDot = relatorioDAO.buscarBenef(cpfBeneficiarioService);
        
        return beneficiarioDot;
    } 
}
