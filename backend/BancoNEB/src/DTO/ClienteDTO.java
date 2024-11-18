package DTO;

import java.time.LocalDate;

public class ClienteDTO extends GeralDTO {
    private double saldo;
    private String senhaAutorizacao;

    public ClienteDTO(String nome, String cpf, String telefone, String logradoro, String bairro, String cidade, String estado, String pais, String email, String senhaEntrada, String referencia,LocalDate datanascimento,String senhaAutorizacao) {
        super(nome,
                cpf,
                telefone,
                logradoro,
                bairro,
                cidade,
                estado,
                pais,
                email,
                senhaEntrada,
                referencia,
                datanascimento);
        this.senhaAutorizacao = senhaAutorizacao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenhaAutorizacao() {
        return senhaAutorizacao;
    }

    public void setSenhaAutorizacao(String senhaAutorizacao) {
        this.senhaAutorizacao = senhaAutorizacao;
    }
    
}

    


