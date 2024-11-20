package DAO;

import DOT.ConexaoDAO;
import DTO.NegocEmpresDTO;
import DTO.PagamentPendDOT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class MovFinacClienDAO {

    public boolean transClienDAO(int idPagadorDAO, int idBeneficiarioDAO, double valorTransaDAO, String tipoTransaDAO, int numParcelaDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "CALL registro_transacao(?,?,?,?,?) ";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idPagadorDAO);
            pstm.setInt(2, idBeneficiarioDAO);
            pstm.setDouble(3, valorTransaDAO);
            pstm.setString(4, tipoTransaDAO);
            pstm.setInt(5, numParcelaDAO);
            int rowAffected = pstm.executeUpdate();

            if (rowAffected != 0) {

                return true;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro);
            }
        }
        return false;
    }

    public boolean pagamPendeDAO(PagamentPendDOT pagamentPendDOT) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "CALL pagamento_parcela_pendente(?,?,?,?)";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pagamentPendDOT.getIdClienteDAO());
            pstm.setDouble(2, pagamentPendDOT.getValorPago());
            pstm.setInt(3, pagamentPendDOT.getIdPagamento());
            pstm.setString(4, pagamentPendDOT.getTipoPagamento());

            int rowAffected = pstm.executeUpdate();

            if (rowAffected != 0) {
                System.out.println("Transação feita com sucesso");
                return true;
            } else {
                System.out.println("Ocorreu um erro na transação , por favor tente novamente");
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro);
            }
        }
        return false;
    }

    public boolean negocEmpresDAO(NegocEmpresDTO negocEmpresDTO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "CALL negociacao_emprestimo(?,?,?,?) ";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, negocEmpresDTO.getIdEmpres());
            pstm.setInt(2, negocEmpresDTO.getIdClien());
            pstm.setDouble(3, negocEmpresDTO.getValorTotalEmpre());
            pstm.setInt(4, negocEmpresDTO.getQuantParc());

            int rowAffected = pstm.executeUpdate();

            if (rowAffected != 0) {

                return true;
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro);
            }
        }
        return false;
    }

}
