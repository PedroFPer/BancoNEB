
package DOT;

public class BeneficiarioDot {
    private int idBeneficiario;
    private String nomeBeneficiario;

    public BeneficiarioDot(int idBeneficiario, String nomeBeneficiario) {
        this.idBeneficiario = idBeneficiario;
        this.nomeBeneficiario = nomeBeneficiario;
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getNomeBeneficiario() {
        return nomeBeneficiario;
    }

    public void setNomeBeneficiario(String nomeBeneficiario) {
        this.nomeBeneficiario = nomeBeneficiario;
    }
    
}
