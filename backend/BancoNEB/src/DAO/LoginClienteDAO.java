package DAO;

import DOT.ConexaoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class LoginClienteDAO {

    public boolean reqLoginClieDAO(String cpf, String senhaEntrada) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "SELECT*FROM cliente_pf WHERE cpf = ? AND senha_de_entrada=?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);
            pstm.setString(2, senhaEntrada);
            rs = pstm.executeQuery();

            if (rs != null && rs.next()) {
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
