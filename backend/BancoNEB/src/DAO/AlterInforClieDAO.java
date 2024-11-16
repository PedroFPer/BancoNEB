package DAO;

import DOT.ConexaoDAO;
import DOT.EnderecoDot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class AlterInforClieDAO {

    public boolean altNomeClieDAO(int idClienteDAO, String novoNome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "UPDATE cliente_pf SET nome_cliente_pf = ? WHERE id_cliente_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, novoNome);
            pstm.setInt(2, idClienteDAO);
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

    public boolean altEmailClieDAO(int idClienteDAO, String novoEmail) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "UPDATE cliente_pf SET email = ? WHERE id_cliente_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, novoEmail);
            pstm.setInt(2, idClienteDAO);
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

    public boolean altTelefoneClieDAO(int idClienteDAO, String novoTelefone) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "UPDATE cliente_pf SET telefone = ? WHERE id_cliente_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, novoTelefone);
            pstm.setInt(2, idClienteDAO);
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

    public boolean altSenhaEntradaClieDAO(int idClienteDAO, String novaSenhaEntrada) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "UPDATE cliente_pf SET senha_de_entrada = ? WHERE id_cliente_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, novaSenhaEntrada);
            pstm.setInt(2, idClienteDAO);
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

    public boolean altSenhaAutorizacaoClieDAO(int idClienteDAO, String novaSenhaAutorizacao) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "UPDATE cliente_pf SET senha_de_autorizacao= ? WHERE id_cliente_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, novaSenhaAutorizacao);
            pstm.setInt(2, idClienteDAO);
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
    
    public boolean altEnderAutorizacaoClieDAO(int idClienteDAO,EnderecoDot enderecoDot) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "UPDATE endereco_pf SET logradouro = ? , bairro =?, cidade = ?, estado = ?, pais = ?, referencia = ? WHERE id_cliente = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,enderecoDot.getLogradouro() );
            pstm.setString(2, enderecoDot.getBairro());
            pstm.setString(3, enderecoDot.getCidade());
            pstm.setString(4, enderecoDot.getEstado());
            pstm.setString(5, enderecoDot.getPais());
            pstm.setString(6, enderecoDot.getReferencia());
            pstm.setInt(7, idClienteDAO);
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
