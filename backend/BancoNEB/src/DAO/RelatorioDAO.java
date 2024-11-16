
package DAO;

import DOT.BeneficiarioDot;
import DOT.ConexaoDAO;
import DOT.ExtratoDot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class RelatorioDAO {
    public ArrayList listaExtratoDAO(int idClienteDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<ExtratoDot> listaExtrato = new ArrayList<>();

        String sql = "SELECT * FROM extrato_comum WHERE id_pagador = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idClienteDAO);
            rs = pstm.executeQuery();

            while (rs.next()) { 
                int idCliente = rs.getInt("id_pagador");
                String nomePagador = rs.getString("nome_pagador");
                double valorTrasancao = rs.getDouble("valor_transacao");
                String tipoPagamento = rs.getString("tipo_pagamento");
                int numParcelaAtual = rs.getInt("num_parcela_atual");
                int numParcelaTotal = rs.getInt("num_parcela_total");
                String nomeBeneficiario = rs.getString("nome_beneficiario");
                LocalDate data_transacao = rs.getObject("data_transacao", LocalDate.class);
                LocalTime hora_transacao = rs.getObject("hora_transacao", LocalTime.class);

                ExtratoDot extratoDot = new ExtratoDot(idCliente,
                        nomePagador,
                        valorTrasancao,
                        tipoPagamento,
                        numParcelaAtual,
                        numParcelaTotal,
                        nomeBeneficiario,
                        data_transacao,
                        hora_transacao);

                listaExtrato.add(extratoDot);
            }

            if (listaExtrato.isEmpty()) { 
                System.out.println("Nenhum dado encontrado para o id_pagador: " + idClienteDAO);
            }

            return listaExtrato;

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
    
    public BeneficiarioDot buscarBenef(String cpfBeneficiario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "SELECT id_cliente_pf, nome_cliente_pf FROM cliente_pf WHERE cpf  = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpfBeneficiario);
            rs = pstm.executeQuery();

            if(rs.next()) { 
                int idBeneficiario = rs.getInt("id_cliente_pf");
                String nomeBeneficiario = rs.getString("nome_cliente_pf");
                
                BeneficiarioDot beneficiarioDot = new BeneficiarioDot(idBeneficiario, nomeBeneficiario);
                
                return beneficiarioDot;

            }else{
                System.out.println("Usuario não encontrado");
                return null;
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
}
