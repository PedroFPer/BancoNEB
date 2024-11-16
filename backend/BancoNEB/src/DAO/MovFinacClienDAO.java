package DAO;

import DOT.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class MovFinacClienDAO {

    public Double vericCredDispDAO(int idClienteDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        double creditoAtualDAO;

        String sql = "SELECT valor_disponivel FROM credito_pf WHERE id_cliente_credito_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idClienteDAO);
            rs = pstm.executeQuery();

            if (rs != null && rs.next()) {
                creditoAtualDAO = (rs.getDouble("valor_disponivel"));
                return creditoAtualDAO;
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
        return null;
    }

    public Double vericSaldoAtualDAO(int idClienteDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        double saldoAtualDAO;

        String sql = "SELECT saldo FROM cliente_pf WHERE id_cliente_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idClienteDAO);
            rs = pstm.executeQuery();

            if (rs != null && rs.next()) {
                saldoAtualDAO = (rs.getDouble("saldo"));
                return saldoAtualDAO;
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
        return null;
    }

    

    public boolean trasancaoDAO(int idClienteDAO, double valorTransacao, String tipoPagamento, int idBeneficiario, int numParcela) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "CALL registro_transacao(idClienteDAO,idBeneficiario,valorTransacao, tipoPagamento, numParcela)";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
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
