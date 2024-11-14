package ControllerMenu;

import java.util.Scanner;

public abstract class ControllerModelMenu {

    Scanner scanner = new Scanner(System.in);

    protected abstract void exibirMenu();

    public int escolherOpcao() {
        int escolha;

        do {
            exibirMenu();
            try {
                escolha = scanner.nextInt();
                
                scanner.nextLine();

                for (int i = 0; i <= quantidEscolha(); i++) {
                    if (escolha == i) {
                        return escolha;
                    } 
                }
                System.out.println("Opção invalida, tente novamente!");
            } catch (Exception e) {
                System.out.println("Entrada invalida, tente novamente!");
                scanner.nextLine();
            }

        } while (true);

    }
    
    protected abstract int quantidEscolha();
}
