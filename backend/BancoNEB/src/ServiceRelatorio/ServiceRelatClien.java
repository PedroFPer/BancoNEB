package ServiceRelatorio;


import DAO.ExtratoDAO;
import DOT.ExtratoDot;
import java.util.ArrayList;

public class ServiceRelatClien {

    public ArrayList serviceExtratoClien(int idClienteService) {

        ExtratoDAO extratoDAO = new ExtratoDAO();
        ArrayList<ExtratoDot> listaDeExtrato = extratoDAO.listaExtratoDAO(idClienteService);

        if (!listaDeExtrato.isEmpty()) {
            return listaDeExtrato;
        } else {
            return null;
        }

    }
}
