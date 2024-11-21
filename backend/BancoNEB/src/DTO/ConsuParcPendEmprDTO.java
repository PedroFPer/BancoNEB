
package DTO;

public class ConsuParcPendEmprDTO {
    private double valorTotalEmpr;
    private double valorParcMens;
    private int mesParcela;
    private int anoParcela;
    private String statusPagam;

    public ConsuParcPendEmprDTO(double valorTotalEmpr, double valorParcMens, int mesParcela, int anoParcela, String statusPagam) {
        this.valorTotalEmpr = valorTotalEmpr;
        this.valorParcMens = valorParcMens;
        this.mesParcela = mesParcela;
        this.anoParcela = anoParcela;
        this.statusPagam = statusPagam;
    }

    public double getValorTotalEmpr() {
        return valorTotalEmpr;
    }

    public double getValorParcMens() {
        return valorParcMens;
    }

    public int getMesParcela() {
        return mesParcela;
    }

    public int getAnoParcela() {
        return anoParcela;
    }

    public String getStatusPagam() {
        return statusPagam;
    }


    
    

    
    
}
