package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class LoginClienteDAO extends EntradaDao {

    private String cpf;
    private String senhaEntrada;

    public LoginClienteDAO(String cpf, String senhaEntrada) {
        this.cpf = cpf;
        this.senhaEntrada = senhaEntrada;
    }

    @Override
    public String getSql() {
        String sql = "SELECT cpf ,senha_de_entrada FROM cliente_pf WHERE cpf=? AND senha_de_entrada=?";
        return sql;
    }

    @Override
    public void setParameters(PreparedStatement pstm) throws SQLException {
        pstm.setString(1, cpf);
        pstm.setString(2, senhaEntrada);
    }

    public boolean resulConsultaBanco() {
        try {
            ResultSet rs = executarConsulta();
            
            if(rs !=null && rs.next()){
                return true;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
        }finally{
            fecharRecursos();
        }
        return false;
    }
}
