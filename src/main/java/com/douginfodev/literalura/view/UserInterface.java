package com.douginfodev.literalura.view;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    int menuNumber = 0;

    public UserInterface() {
        System.out.println("BEM VINDO AO LITERALURA");
    }

    public void printMenu() {

        while (menuNumber != 6) {
            System.out.println("===========================");
            System.out.println("    LITERALURA 1.0    ");
            System.out.println("===========================");
            System.out.println("         MENU              ");
            System.out.println("1 = BUSCAR LIVROS / TITULO");
            System.out.println("2 = LISTAR LIVROS REGISTRADO");
            System.out.println("3 = LISTAR AUTORES REGISTRADOS ");
            System.out.println("4 = LISTAR AUTORES / ANO");
            System.out.println("5 = LISTAR LIVROS / IDIOMA");
            System.out.println("6 = SAIR");
            System.out.println("SELECIONE UMA OPÇÃO");
            menuNumber = scanner.nextInt();
        }
    }
}
