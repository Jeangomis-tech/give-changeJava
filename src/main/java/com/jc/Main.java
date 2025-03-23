package com.jc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an amount: ");

        try{
            int amount = scanner.nextInt();
            int[] result = CashDispenser.giveChange(amount);
            System.out.println( amount + " €  = " + CashDispenser.formatedResult(result));

            // Show in details
            System.out.println("\n Change returned: ");
            System.out.println("10€ notes : " + result[0]);
            System.out.println("5€ notes : " + result[1]);
            System.out.println("2€ notes : " + result[2]);
        }catch(Exception e){
            System.out.println( "Error" + e.getMessage());
        }finally{
            scanner.close();
        }


    }
}