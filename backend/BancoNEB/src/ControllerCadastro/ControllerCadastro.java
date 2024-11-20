package ControllerCadastro;

import DTO.ClienteDTO;
import ServiceCadastro.ServiceCadastro;
import ServiceRelatorio.ServiceRelatClien;
import UtilVerif.UtilVericCpf;
import UtilVerif.UtilVericSenha;
import UtilVerif.UtilVerifTelefone;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ControllerCadastro {

    ServiceRelatClien serviceRelatClien = new ServiceRelatClien();
    ServiceCadastro serviceCadastro = new ServiceCadastro();
    UtilVerifTelefone utilVerifTelefone = new UtilVerifTelefone();
    UtilVericCpf utilVericCpf = new UtilVericCpf();
    UtilVericSenha utilVericSenha = new UtilVericSenha();

    public boolean controllerCadastroClie(ClienteDTO clienteDTO) {
       Scanner scanner = new Scanner(System.in);
       boolean vericCadas = serviceCadastro.serviceCadastroCliente(clienteDTO);
       return vericCadas;

    }

}
