package com.jc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an amount in euros  : ");

            try {
                int montant = scanner.nextInt();

                if (montant == 0) {
                    System.out.println("Exit !");
                    break;
                }

                CashDispenser.giveChange(montant);
                System.out.println();

            } catch (Exception e) {
                System.out.println("Error : Please enter a number greater than 0");
                scanner.next();
            }
        }

        scanner.close();
    }

//        System.out.println(); CashDispenser.giveChange(50);
//      CashDispenser.giveChange(25);
//      CashDispenser.giveChange(32);
//      CashDispenser.giveChange(21);
//      CashDispenser.giveChange(23);
//      CashDispenser.giveChange(28);
//      CashDispenser.giveChange(31);
//      CashDispenser.giveChange(33);
//      CashDispenser.giveChange(38);




}