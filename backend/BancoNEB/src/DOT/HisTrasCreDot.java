
package DOT;

public class HisTrasCreDot {
    private int idCliente;
    private double valorParcela;
    private int mesParcela;
    private int anoParcela;
    private String tipoPagamento;
    private int parcelaAtual;
    private String nomeBeneficiario;

    public HisTrasCreDot(int idCliente, double valorParcela, int mesParcela, int anoParcela, String tipoPagamento, int parcelaAtual, String nomeBeneficiario) {
        this.idCliente = idCliente;
        this.valorParcela = valorParcela;
        this.mesParcela = mesParcela;
        this.anoParcela = anoParcela;
        this.tipoPagamento = tipoPagamento;
        this.parcelaAtual = parcelaAtual;
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public int getMesParcela() {
        return mesParcela;
    }

    public void setMesParcela(int mesParcela) {
        this.mesParcela = mesParcela;
    }

    public int getAnoParcela() {
        return anoParcela;
    }

    public void setAnoParcela(int anoParcela) {
        this.anoParcela = anoParcela;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getParcelaAtual() {
        return parcelaAtual;
    }

    public void setParcelaAtual(int parcelaAtual) {
        this.parcelaAtual = parcelaAtual;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }
    
    
    
}
