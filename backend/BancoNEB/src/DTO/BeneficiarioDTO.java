
package DOT;

public class BeneficiarioDTO {
    private int idBeneficiario;
    private String nomeBeneficiario;

    public BeneficiarioDTO(int idBeneficiario, String nomeBeneficiario) {
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
