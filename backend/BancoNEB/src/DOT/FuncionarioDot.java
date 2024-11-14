package DOT;

public class FuncionarioDot extends GeralDot{  
    private String cargo;
    public FuncionarioDot(String nome, String cpf, String telefone, String logradoro, String num, String bairro, String cidade, String estado, String pais, String email, String cargo, String senha, int datanascimento) {
        super(nome,
                cpf,
                telefone,
                logradoro,
                num,
                bairro,
                cidade,
                estado,
                pais,
                email,
                senha,
                datanascimento);
        this.cargo=cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
}
