package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class EntradaDao {

    protected Connection conn;
    protected PreparedStatement pstm;
    protected ResultSet rs;

    protected abstract String getSql();

    protected abstract void setParameters(PreparedStatement pstm) throws SQLException;

    protected ResultSet executarConsulta() {
        try {
            String sql = getSql();
            pstm = conn.prepareStatement(sql);
            setParameters(pstm);
            rs = pstm.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro a executar consulta" + e);
            return null;
        }
    }

    public void fecharRecursos() {
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e);
        }

    }

}
