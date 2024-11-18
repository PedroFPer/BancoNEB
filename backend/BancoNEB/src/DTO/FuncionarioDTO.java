package DTO;

import java.time.LocalDate;

public class FuncionarioDTO extends GeralDTO{  
    private String cargo;
    private String usuario;
    private LocalDate dataContratacao;
    private double salario;

    public FuncionarioDTO(String cargo, String usuario, LocalDate dataContratacao, double salario, String nome, String cpf, String telefone, String logradoro, String bairro, String cidade, String estado, String pais, String email, String senhaEntrada, String referencia, LocalDate datanascimento) {
        super(nome, cpf, telefone, logradoro, bairro, cidade, estado, pais, email, senhaEntrada, referencia, datanascimento);
        this.cargo = cargo;
        this.usuario = usuario;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }

    

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    
}
