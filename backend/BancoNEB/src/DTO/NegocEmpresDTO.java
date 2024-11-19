
package DTO;


public class NegocEmpresDTO {
    
    private int idEmpres;
    private int idClien;
    private double valorTotalEmpre;
    private int quantParc;

    public NegocEmpresDTO(int idEmpres, int idClien, double valorTotalEmpre, int quantParc) {
        this.idEmpres = idEmpres;
        this.idClien = idClien;
        this.valorTotalEmpre = valorTotalEmpre;
        this.quantParc = quantParc;
    }

    public int getIdEmpres() {
        return idEmpres;
    }

    public int getIdClien() {
        return idClien;
    }

    public double getValorTotalEmpre() {
        return valorTotalEmpre;
    }

    public int getQuantParc() {
        return quantParc;
    }
    
    
    
}
