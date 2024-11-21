package DAO;

import DOT.BeneficiarioDTO;
import DOT.ConexaoDAO;
import DTO.ConsuParcPendEmprDTO;
import DTO.ConsultaPagamenPendDTO;
import DTO.ConsultaParcPendAtualDTO;
import DTO.EmprestimoAbertDTO;
import DTO.ExtratoDTO;
import DTO.HisTrasCreDTO;
import DTO.HistEmprDTO;
import DTO.ValorDispoEmpresDTO;
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

    public BeneficiarioDTO buscarBenefDAO(String cpfBeneficiario) {
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
            pstm.setInt(1, consultaPagamenPendDTO.getIdClienteDao());
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

<<<<<<< Updated upstream
        String sql = "SELECT*FROM pagamento_pendente_pf WHERE id_cliente_pf_pagamento = ? AND mes_parcela = ? AND ano_parcela = ? AND tipo_de_pagamento =?";
=======
        String sql = "SELECT*FROM pagamento_pendente_pf WHERE id_cliente_pf_pagamento = ? AND mes_parcela = ? AND ano_parcela = ? AND tipo_de_pagamento =? AND status_pagamento = 'Pendente'";
>>>>>>> Stashed changes

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, consultaPagamenPendDTO.getIdClienteDao());
            pstm.setInt(2, consultaPagamenPendDTO.getMes());
            pstm.setInt(3, consultaPagamenPendDTO.getAno());
            pstm.setString(4, consultaPagamenPendDTO.getTipo_de_pagamento());
            rs = pstm.executeQuery();

            if (rs.next()) {
                double valorTotal = rs.getDouble("valor_total_mes");
                String status = rs.getString("status_pagamento");
                String tipoFinanc = rs.getString("tipo_de_pagamento");
                int mes = rs.getInt("mes_parcela");
                int ano = rs.getInt("ano_parcela");
                int idPagam = rs.getInt("id_pagamento_pendente_pf");


                ConsultaParcPendAtualDTO consultaParcPendAtualDTO = new ConsultaParcPendAtualDTO(valorTotal, status, tipoFinanc, mes, ano, idPagam);

                return consultaParcPendAtualDTO;

            } else {
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

    public EmprestimoAbertDTO vericEmprestAberDAO(int idClienteDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "SELECT *FROM veric_empres_atual WHERE id_cliente_emprestimo_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idClienteDAO);
            rs = pstm.executeQuery();

            if (rs.next()) {
                double valTotEmpr = rs.getDouble("valor_total_emprestimo");
                double valPendEmpr = rs.getDouble("valor_pendente");
                LocalDate dataNegoc = rs.getObject("data_emprestimo", LocalDate.class);
                double valorParcMen = rs.getDouble("valor_total_mes");
                int numParcPaga = rs.getInt("num_parcelas_pagas");
                int numParcTotal = rs.getInt("num_parcela_total");
                String statuPagam = rs.getString("status_pagamento");

                EmprestimoAbertDTO emprestimoAbertDTO = new EmprestimoAbertDTO(valTotEmpr, valPendEmpr, dataNegoc, valorParcMen, numParcPaga, numParcTotal, statuPagam);
                return emprestimoAbertDTO;

            } else {
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

    public ArrayList historEmpreDAO(int idClienteDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<HistEmprDTO> listaHistEmpr = new ArrayList<>();

        String sql = "SELECT *FROM consul_empr_ger WHERE id_cliente_emprestimo_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idClienteDAO);

            rs = pstm.executeQuery();

            while (rs.next()) {

                double valTotEmpr = rs.getDouble("valor_total_emprestimo");
                int numParc = rs.getInt("num_parcela");
                LocalDate dataEmpr = rs.getObject("data_emprestimo", LocalDate.class);

                HistEmprDTO histEmprDTO = new HistEmprDTO(valTotEmpr, numParc, dataEmpr);

                listaHistEmpr.add(histEmprDTO);
            }

            if (listaHistEmpr.isEmpty()) {
                System.out.println("Nenhum dado encontrado");
            }

            return listaHistEmpr;

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

    public ArrayList parcPendEmpreDAO(int idClienteDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<ConsuParcPendEmprDTO> listaParcPendEmpr = new ArrayList<>();

        String sql = "SELECT *FROM veric_parc_pend_empr WHERE id_cliente_pf_pagamento = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idClienteDAO);

            rs = pstm.executeQuery();

            while (rs.next()) {

                double valorTotalEmpr = rs.getDouble("valor_total_emprestimo");
                double valorParcMens = rs.getDouble("valor_total_mes");
                int mesParcela = rs.getInt("mes_parcela");
                int anoParcela = rs.getInt("ano_parcela");
                String statusPagam = rs.getString("status_pagamento");

                ConsuParcPendEmprDTO consuParcPendEmprDTO = new ConsuParcPendEmprDTO(valorTotalEmpr, valorParcMens, mesParcela, anoParcela, statusPagam);

                listaParcPendEmpr.add(consuParcPendEmprDTO);
            }

            if (listaParcPendEmpr.isEmpty()) {
                System.out.println("Nenhum dado encontrado");
            }

            return listaParcPendEmpr;

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

    public ValorDispoEmpresDTO valorDispEmprDAO(int idClienteDAO) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "SELECT valor_total_disponivel, id_emprestimo_pf FROM emprestimo_pf WHERE id_cliente_emprestimo_pf = ?";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idClienteDAO);
            rs = pstm.executeQuery();

            if (rs != null && rs.next()) {
                int idEmpre = (rs.getInt("id_emprestimo_pf"));
                double valorDispoEmpr = (rs.getDouble("valor_total_disponivel"));

                ValorDispoEmpresDTO valorDispoEmpresDTO = new ValorDispoEmpresDTO(idEmpre, valorDispoEmpr);

                return valorDispoEmpresDTO;
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

    public boolean vericCpfExisDAO(String cpf) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean vericCpf;

        String sql = "SELECT veric_cpf_exis(?) AS resultVericCpf";

        ConexaoDAO conexaoDao = new ConexaoDAO();
        conn = conexaoDao.conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cpf);
            rs = pstm.executeQuery();

            if (rs != null && rs.next()) {
                vericCpf = rs.getBoolean("resultVericCpf");
                return vericCpf;
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
