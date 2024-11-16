package ServiceRelatorio;


import DAO.RelatorioDAO;
import DOT.ExtratoDot;
import java.util.ArrayList;

public class ServiceRelatClien {
    
    RelatorioDAO relatorioDAO = new RelatorioDAO();
    
    public ArrayList serviceExtratoClien(int idClienteService) {

        ArrayList<ExtratoDot> listaDeExtrato = relatorioDAO.listaExtratoDAO(idClienteService);

        return listaDeExtrato;

    }
}
