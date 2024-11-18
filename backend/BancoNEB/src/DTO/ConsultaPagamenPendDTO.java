package DTO;


public class ConsultaPagamenPendDTO {

    private int idClienteDao;
    private String tipo_de_pagamento;
    private int mes;
    private int ano;

    public ConsultaPagamenPendDTO(int idClienteDao, String tipo_de_pagamento, int mes, int ano) {
        this.idClienteDao = idClienteDao;
        this.tipo_de_pagamento = tipo_de_pagamento;
        this.mes = mes;
        this.ano = ano;
    }

    public int getIdClienteDao() {
        return idClienteDao;
    }

    public String getTipo_de_pagamento() {
        return tipo_de_pagamento;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }
    
    

}
