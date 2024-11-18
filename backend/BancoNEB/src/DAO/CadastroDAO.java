package DAO;

import DOT.ClienteDot;
import DOT.ConexaoDAO;
import DOT.FuncionarioDot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class CadastroDAO {

    public boolean cadastroClienteDAO(ClienteDot clienteDot) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "CALL inserir_cliente_e_dados(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, clienteDot.getNome());
            pstm.setDate(2, java.sql.Date.valueOf(clienteDot.getDatanascimento()));
            pstm.setString(3, clienteDot.getCpf());
            pstm.setString(4, clienteDot.getTelefone());
            pstm.setString(5, clienteDot.getEmail());
            pstm.setString(6, clienteDot.getSenhaEntrada());
            pstm.setString(7, clienteDot.getSenhaAutorizacao());
            pstm.setString(8, clienteDot.getLogradoro());
            pstm.setString(9, clienteDot.getBairro());
            pstm.setString(10, clienteDot.getCidade());
            pstm.setString(11, clienteDot.getEstado());
            pstm.setString(12, clienteDot.getPais());
            pstm.setString(13, clienteDot.getReferencia());

            int rowAffected = pstm.executeUpdate();

            if (rowAffected != 0) {
                System.out.println("Cadastro efetuado com sucesso");
                return true;
            } else {
                System.out.println("Ocorreu um erro no cadastro, por favor tente novamente");
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

    public boolean cadastroFuncionarioDAO(FuncionarioDot funcionarioDot) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "CALL inserir_funcionario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionarioDot.getNome());
            pstm.setObject(2, funcionarioDot.getDatanascimento());
            pstm.setString(3, funcionarioDot.getCpf());
            pstm.setString(4, funcionarioDot.getTelefone());
            pstm.setString(5, funcionarioDot.getEmail());
            pstm.setString(6, funcionarioDot.getUsuario());
            pstm.setString(7, funcionarioDot.getSenhaEntrada());
            pstm.setString(8, funcionarioDot.getCargo());
            pstm.setDouble(9, funcionarioDot.getSalario());
            pstm.setString(10, funcionarioDot.getLogradoro());
            pstm.setString(11, funcionarioDot.getBairro());
            pstm.setString(12, funcionarioDot.getCidade());
            pstm.setString(13, funcionarioDot.getEstado());
            pstm.setString(14, funcionarioDot.getPais());
            pstm.setString(15, funcionarioDot.getReferencia());

            int rowAffected = pstm.executeUpdate();

            if (rowAffected != 0) {
                System.out.println("Cadastro efetuado com sucesso");
                return true;
            } else {
                System.out.println("Ocorreu um erro no cadastro, por tente novamente");
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
