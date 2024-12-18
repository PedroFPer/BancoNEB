package DTO;

import java.time.LocalDate;

public class GeralDTO {

    protected String nome;
    protected String cpf;
    protected String telefone;
    protected String logradoro;
    protected String bairro;
    protected String cidade;
    protected String estado;
    protected String pais;
    protected String email;
    protected String senhaEntrada;
    private String referencia;
    protected LocalDate datanascimento;

    public GeralDTO(String nome, String cpf, String telefone, String logradoro, String bairro, String cidade, String estado, String pais, String email, String senhaEntrada, String referencia, LocalDate datanascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.logradoro = logradoro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.email = email;
        this.senhaEntrada = senhaEntrada;
        this.referencia = referencia;
        this.datanascimento = datanascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradoro() {
        return logradoro;
    }

    public void setLogradoro(String logradoro) {
        this.logradoro = logradoro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaEntrada() {
        return senhaEntrada;
    }

    public void setSenhaEntrada(String senhaEntrada) {
        this.senhaEntrada = senhaEntrada;
    }

    public LocalDate getDatanascimento() {
        return datanascimento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
