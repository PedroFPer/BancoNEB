package DTO;

import java.time.LocalDate;

public class EmprestimoAbertDTO {

    private double valTotEmpr;
    private double valPendEmpr;
    private LocalDate dataNegoc;
    private double valorParcMen;
    private int numParcPaga;
    private int numParcTotal;
    private String statuPagam;

    public EmprestimoAbertDTO(double valTotEmpr, double valPendEmpr, LocalDate dataNegoc, double valorParcMen, int numParcPaga, int numParcTotal, String statuPagam) {
        this.valTotEmpr = valTotEmpr;
        this.valPendEmpr = valPendEmpr;
        this.dataNegoc = dataNegoc;
        this.valorParcMen = valorParcMen;
        this.numParcPaga = numParcPaga;
        this.numParcTotal = numParcTotal;
        this.statuPagam = statuPagam;
    }

    public double getValTotEmpr() {
        return valTotEmpr;
    }

    public double getValPendEmpr() {
        return valPendEmpr;
    }

    public LocalDate getDataNegoc() {
        return dataNegoc;
    }

    public double getValorParcMen() {
        return valorParcMen;
    }

    public int getNumParcPaga() {
        return numParcPaga;
    }

    public int getNumParcTotal() {
        return numParcTotal;
    }

    public String getStatuPagam() {
        return statuPagam;
    }
    
    

}
