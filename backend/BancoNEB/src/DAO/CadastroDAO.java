package DAO;


import DOT.ConexaoDAO;
import DTO.ClienteDTO;
import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class CadastroDAO {

    public boolean cadastroClienteDAO(ClienteDTO clienteDTO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "CALL inserir_cliente_e_dados(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, clienteDTO.getNome());
            pstm.setDate(2, java.sql.Date.valueOf(clienteDTO.getDatanascimento()));
            pstm.setString(3, clienteDTO.getCpf());
            pstm.setString(4, clienteDTO.getTelefone());
            pstm.setString(5, clienteDTO.getEmail());
            pstm.setString(6, clienteDTO.getSenhaEntrada());
            pstm.setString(7, clienteDTO.getSenhaAutorizacao());
            pstm.setString(8, clienteDTO.getLogradoro());
            pstm.setString(9, clienteDTO.getBairro());
            pstm.setString(10, clienteDTO.getCidade());
            pstm.setString(11, clienteDTO.getEstado());
            pstm.setString(12, clienteDTO.getPais());
            pstm.setString(13, clienteDTO.getReferencia());

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

    public boolean cadastroFuncionarioDAO(FuncionarioDTO funcionarioDTO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "CALL inserir_funcionario(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionarioDTO.getNome());
            pstm.setObject(2, funcionarioDTO.getDatanascimento());
            pstm.setString(3, funcionarioDTO.getCpf());
            pstm.setString(4, funcionarioDTO.getTelefone());
            pstm.setString(5, funcionarioDTO.getEmail());
            pstm.setString(6, funcionarioDTO.getUsuario());
            pstm.setString(7, funcionarioDTO.getSenhaEntrada());
            pstm.setString(8, funcionarioDTO.getCargo());
            pstm.setDouble(9, funcionarioDTO.getSalario());
            pstm.setString(10, funcionarioDTO.getLogradoro());
            pstm.setString(11, funcionarioDTO.getBairro());
            pstm.setString(12, funcionarioDTO.getCidade());
            pstm.setString(13, funcionarioDTO.getEstado());
            pstm.setString(14, funcionarioDTO.getPais());
            pstm.setString(15, funcionarioDTO.getReferencia());

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
