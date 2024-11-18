package DAO;


import DOT.BeneficiarioDTO;
import DOT.ConexaoDAO;
import DTO.ConsultaPagamenPendDTO;
import DTO.ConsultaParcPendAtualDTO;
import DTO.ExtratoDTO;
import DTO.HisTrasCreDTO;
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
        ArrayList<ExtratoDTO> listaExtrato = new ArrayList<>();

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

                ExtratoDTO extratoDot = new ExtratoDTO(idCliente,
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

    public BeneficiarioDTO buscarBenef(String cpfBeneficiario) {
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

            if (rs.next()) {
                int idBeneficiario = rs.getInt("id_cliente_pf");
                String nomeBeneficiario = rs.getString("nome_cliente_pf");

                BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO(idBeneficiario, nomeBeneficiario);

                return beneficiarioDTO;

            } else {
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

    public ArrayList histTrasCredDAO(ConsultaPagamenPendDTO consultaPagamenPendDTO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<HisTrasCreDTO> listaHistCred = new ArrayList<>();

        String sql = "SELECT *FROM lista_compra_crédito WHERE id_cliente_pf = ? AND mes_parcela =? AND ano_parcela = ? ;";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,consultaPagamenPendDTO.getIdClienteDao());
            pstm.setInt(2, consultaPagamenPendDTO.getMes());
            pstm.setInt(3, consultaPagamenPendDTO.getAno());
            rs = pstm.executeQuery();

            while (rs.next()) {

                int idClien = rs.getInt("id_cliente_pf");
                double valorParcela = rs.getDouble("valor_parcela_mes");
                int mesParc = rs.getInt("mes_parcela");
                int anoParc = rs.getInt("ano_parcela");
                String tipoPagamento = rs.getString("tipo_de_pagamento");
                int parcelaAtual = rs.getInt("parcela_atual");
                String nomeBeneficiario = rs.getString("nome_beneficiario");

                HisTrasCreDTO hisTrasCreDTO = new HisTrasCreDTO(idClien, valorParcela, mesParc, anoParc, tipoPagamento, parcelaAtual, nomeBeneficiario);

                listaHistCred.add(hisTrasCreDTO);
            }

            if (listaHistCred.isEmpty()) {
                System.out.println("Nenhum dado encontrado");
            }

            return listaHistCred;

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

    public ConsultaParcPendAtualDTO consultaParcDAO(ConsultaPagamenPendDTO consultaPagamenPendDTO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        LocalDate dataAtual = LocalDate.now();

        int mesAtual = dataAtual.getMonthValue();
        int anoAtual = dataAtual.getYear();
        

        String sql = "SELECT*FROM pagamento_pendente_pf WHERE id_cliente_pf_pagamento = ? AND mes_parcela = ? AND ano_parcela = ? AND tipo_de_pagamento =?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,consultaPagamenPendDTO.getIdClienteDao());
            pstm.setInt(2,consultaPagamenPendDTO.getMes() );
            pstm.setInt(3, consultaPagamenPendDTO.getAno());
            pstm.setString(4,consultaPagamenPendDTO.getTipo_de_pagamento() );
            rs = pstm.executeQuery();

            if (rs.next()) {
                double valorTotal = rs.getDouble("valor_total_mes");
                String status = rs.getString("status_pagamento");
                String tipoFinanc = rs.getString("tipo_de_pagamento");
                int mes = rs.getInt("mes_parcela");
                int ano = rs.getInt("ano_parcela");
                int idPagam = rs.getInt("id_pagamento_pendente_pf");
                
                ConsultaParcPendAtualDTO consultaParcPendAtualDTO = new ConsultaParcPendAtualDTO(valorTotal,status,tipoFinanc,mes,ano,idPagam);

                return consultaParcPendAtualDTO;

            } else {
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

