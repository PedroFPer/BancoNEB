
package DTO;


public class PagamentPendDOT {
    private int idClienteDAO;
    private double valorPago;
    private int idPagamento;
    private String tipoPagamento;

    public PagamentPendDOT(int idClienteDAO, double valorPago, int idPagamento, String tipoPagamento) {
        this.idClienteDAO = idClienteDAO;
        this.valorPago = valorPago;
        this.idPagamento = idPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    public int getIdClienteDAO() {
        return idClienteDAO;
    }

    public double getValorPago() {
        return valorPago;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
    
}
