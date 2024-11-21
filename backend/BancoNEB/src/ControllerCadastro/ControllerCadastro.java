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

    public void controllerCadastroClie() {
        Scanner scanner = new Scanner(System.in);
        LocalDate dataNascimento;
        String cpf;
        String telefone;
        String senhaEntrada;
        String senhaAutorizacao;

        System.out.println("Informe o nome do cliente:");
        String nomeCliente = scanner.nextLine();

        do {
            try {
                System.out.println("Informe a data de nascimento (yyyy-MM-dd):");
                String dataNasc = scanner.nextLine();

                dataNascimento = LocalDate.parse(dataNasc, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                LocalDate hoje = LocalDate.now();

                Period periodo = Period.between(dataNascimento, hoje);

                if (periodo.getYears() > 16) {
                    break;
                } else {
                    System.out.println("É necessario ter pelo menos 16 anos para poder criar uma conta no banco");
                }

            } catch (DateTimeParseException e) {
                System.out.println("Formato errado, por favor tente novamente");
            }
        } while (true);

        do {
            System.out.println("Informe o CPF (11 dígitos):");
            cpf = scanner.nextLine();

            boolean vericCpf = utilVericCpf.vericQuant(cpf);

            if (vericCpf) {
                boolean controlVericCpfExis = serviceRelatClien.serviceVericCpfExis(cpf);

                if (controlVericCpfExis) {
                    System.out.println("CPF já existe no sistema!");

                } else {
                    break;
                }
               
            } else {
                System.out.println("Formato errado! O Cpf deve conter 11 caracteres");
            }

        } while (true);

        do {
            System.out.println("Informe o telefone (13 dígitos):");
            telefone = scanner.nextLine();

            boolean vericTelefone = utilVerifTelefone.vericQuant(telefone);

            if (vericTelefone) {
                break;
            } else {
                System.out.println("Formato errado! O telefone deve conter 13 caracteres, junto do DDD");
            }
        } while (true);

        System.out.println("Informe o email:");
        String email = scanner.nextLine();

        do {
            System.out.println("Informe a senha de entrada (8 caracteres):");
            senhaEntrada = scanner.nextLine();

            boolean vericSenhaEntr = utilVericSenha.vericQuant(senhaEntrada);

            if (vericSenhaEntr) {
                break;
            } else {
                System.out.println("Formato errado! A senha de entrada deve conter 8 caracteres");
            }

        } while (true);

        do {
            System.out.println("Informe a senha de autorização (8 caracteres):");
            senhaAutorizacao = scanner.nextLine();

            boolean vericSenhaEntr = utilVericSenha.vericQuant(senhaAutorizacao);

            if (vericSenhaEntr) {
                break;
            } else {
                System.out.println("Formato errado! A senha de entrada deve conter 8 caracteres");
            }

        } while (true);

        System.out.println("Informe o logradouro:");
        String logradouro = scanner.nextLine();

        System.out.println("Informe o bairro:");
        String bairro = scanner.nextLine();

        System.out.println("Informe a cidade:");
        String cidade = scanner.nextLine();

        System.out.println("Informe o estado:");
        String estado = scanner.nextLine();

        System.out.println("Informe o país:");
        String pais = scanner.nextLine();

        System.out.println("Informe a referência:");
        String referencia = scanner.nextLine();

        ClienteDTO clienteDTO = new ClienteDTO(nomeCliente, cpf, telefone, logradouro, bairro, cidade, estado, pais, email, senhaEntrada, referencia, dataNascimento, senhaAutorizacao);

        serviceCadastro.serviceCadastroCliente(clienteDTO);

    }

}
