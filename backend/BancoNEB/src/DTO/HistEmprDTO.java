
package DTO;

import java.time.LocalDate;

public class HistEmprDTO {
    private double valTotEmpr;
    private int numParc;
    private LocalDate dataEmpr;

    public HistEmprDTO(double valTotEmpr, int numParc, LocalDate dataEmpr) {
        this.valTotEmpr = valTotEmpr;
        this.numParc = numParc;
        this.dataEmpr = dataEmpr;
    }

    public double getValTotEmpr() {
        return valTotEmpr;
    }

    public int getNumParc() {
        return numParc;
    }

    public LocalDate getDataEmpr() {
        return dataEmpr;
    }
    
    
}
