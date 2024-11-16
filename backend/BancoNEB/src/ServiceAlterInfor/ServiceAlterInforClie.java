package ServiceAlterInfor;

import DAO.AlterInforClieDAO;
import DOT.EnderecoDot;

public class ServiceAlterInforClie {

    AlterInforClieDAO alterInforClieDAO = new AlterInforClieDAO();

    public boolean serviceAlterNomeClie(int idClienteService, String novoNome) {
        boolean vericAlterNome = alterInforClieDAO.altNomeClieDAO(idClienteService, novoNome);

        return vericAlterNome;
    }

    public boolean serviceAlterEmailClie(int idClienteService, String novoEmail) {
        boolean vericAlterNome = alterInforClieDAO.altEmailClieDAO(idClienteService, novoEmail);

        return vericAlterNome;
    }

    public boolean serviceAlterTelefoneClie(int idClienteService, String novoTelefone) {
        boolean vericAlterTelefone = alterInforClieDAO.altTelefoneClieDAO(idClienteService, novoTelefone);

        return vericAlterTelefone;
    }

    public boolean serviceAlterSenhaEntradaClie(int idClienteService, String novaSenhaEntrada) {
        boolean vericAlterSenhaEntrada = alterInforClieDAO.altSenhaEntradaClieDAO(idClienteService, novaSenhaEntrada);

        return vericAlterSenhaEntrada;
    }

    public boolean serviceAlterSenhaAutorizacaoClie(int idClienteService, String novaSenhaAutorizacao) {
        boolean vericAlterSenhaAutorizacao = alterInforClieDAO.altSenhaAutorizacaoClieDAO(idClienteService, novaSenhaAutorizacao);

        return vericAlterSenhaAutorizacao;
    }

    public boolean serviceAlterEnderClie(int idClienteService, EnderecoDot enderecoDot) {
        boolean vericAlterEnder = alterInforClieDAO.altEnderAutorizacaoClieDAO(idClienteService, enderecoDot);

        return vericAlterEnder;
    }

}
