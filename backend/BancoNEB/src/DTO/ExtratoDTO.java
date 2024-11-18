
package DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExtratoDTO {
    private int idCliente;
    private String nomePagador;
    private double valorTrasancao;
    private String tipoPagamento;
    private int numParcelaAtual;
    private int numParcelaTotal;
    private String nomeBeneficiario;
    private LocalDate data_transacao;
    private LocalTime hora_transacao;

    public ExtratoDTO(int idCliente, String nomePagador, double valorTrasancao, String tipoPagamento, int numParcelaAtual, int numParcelaTotal, String nomeBeneficiario, LocalDate data_transacao, LocalTime hora_transacao) {
        this.idCliente = idCliente;
        this.nomePagador = nomePagador;
        this.valorTrasancao = valorTrasancao;
        this.tipoPagamento = tipoPagamento;
        this.numParcelaAtual = numParcelaAtual;
        this.numParcelaTotal = numParcelaTotal;
        this.nomeBeneficiario = nomeBeneficiario;
        this.data_transacao = data_transacao;
        this.hora_transacao = hora_transacao;
    }

    public String getNomePagador() {
        return nomePagador;
    }

    public double getValorTrasancao() {
        return valorTrasancao;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public int getNumParcelaAtual() {
        return numParcelaAtual;
    }

    public int getNumParcelaTotal() {
        return numParcelaTotal;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public LocalDate getData_transacao() {
        return data_transacao;
    }

    public LocalTime getHora_transacao() {
        return hora_transacao;
    }

    public int getIdCliente() {
        return idCliente;
    }
    
    
    
}
