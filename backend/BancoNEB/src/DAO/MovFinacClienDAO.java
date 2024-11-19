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

    public Double vericParcelaDAO(double valorCompraDAO, int numParcelaDAO, String tipoPagamentoDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        double valorParcela;

        String sql = "SELECT calcular_parcelas(?,?,?)AS resultado";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, valorCompraDAO);
            pstm.setInt(2, numParcelaDAO);
            pstm.setString(3, tipoPagamentoDAO);
            rs = pstm.executeQuery();

            if (rs != null && rs.next()) {
                valorParcela = (rs.getDouble("resultado"));
                return valorParcela;
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
