package DOT;

public class ClienteDot extends GeralDot {
    private double saldo = 0;

    public ClienteDot(String nome, String cpf, String telefone, String logradoro, String num, String bairro, String cidade, String estado, String pais, String email, String senhaEntrada, int datanascimento) {
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
                senhaEntrada,
                datanascimento);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
}

    


