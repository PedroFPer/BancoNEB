
package DTO;

public class ConsultaParcPendAtualDTO {
    private int idPagamento;
    private double valorTotal;
    private String status;
    private String tipoFinanc;
    private int mes;
    private int ano;

    public ConsultaParcPendAtualDTO(double valorTotal, String status, String tipoFinanc, int mes, int ano, int idPagamento) {
        this.valorTotal = valorTotal;
        this.status = status;
        this.tipoFinanc = tipoFinanc;
        this.mes = mes;
        this.ano = ano;
        this.idPagamento = idPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public String getTipoFinanc() {
        return tipoFinanc;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getIdPagamento() {
        return idPagamento;
    }
    
    
    
}
