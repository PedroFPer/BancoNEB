
package DTO;

public class ConsuParcPendEmprDTO {
    private double valorTotalEmpr;
    private double valorParcMens;
    private int mesParcela;
    private int anoParcela;
    private String statusPagam;
    private int numParce;

    public ConsuParcPendEmprDTO(double valorTotalEmpr, double valorParcMens, int mesParcela, int anoParcela, String statusPagam, int numParce) {
        this.valorTotalEmpr = valorTotalEmpr;
        this.valorParcMens = valorParcMens;
        this.mesParcela = mesParcela;
        this.anoParcela = anoParcela;
        this.statusPagam = statusPagam;
        this.numParce = numParce;
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

    public int getNumParce() {
        return numParce;
    }
    
    

    
    
}
