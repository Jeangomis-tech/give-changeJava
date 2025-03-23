package com.jc;

public class CashDispenser {
    //Initialize the denominations of 10€, 5€ notes and 2€ coins

    private  static final int billetsDix = 10;
    private  static final int billetsCinq = 5;
    private  static final int piecesDeux = 2;

    //Remains to be returned
    public static int[]giveChange(int amount){
        //Check if the integer is positive

        if(amount < 0){
            throw new IllegalArgumentException("Amount must be a positive number");
        }

        int[] result = new int[3];
        int remainingAmount = amount;

        // CASE 10€
        result[0] = remainingAmount / billetsDix;
        remainingAmount %= billetsDix;

        // CASE 5€
        result[1] = remainingAmount / billetsCinq;
        remainingAmount %= billetsCinq;

        // CASE 2€
        result[2] = remainingAmount / piecesDeux;
        remainingAmount %= piecesDeux;


        //Checking that the exact amount can be returned
        if(remainingAmount != 0){
            throw new IllegalArgumentException("Impossible to render exactly" + amount + " € with available cuts" + remainingAmount + "€");
        }
        // THE RETURNED RESULT
        return result;
    }
    //Displays the change result in text form
    public static String formatedResult(int[] result){

        StringBuilder stringBuilder = new StringBuilder();
        //Display for ten-pack notes
        if(result[0] > 0){
            stringBuilder.append(result[0]).append("ticket");
            if(result[1] > 1)stringBuilder.append("s");
            stringBuilder.append(" from 10€");

            if(result[1] > 0 || result[2] > 0){
                if(result[1] > 0 && result[2] > 0){
                    stringBuilder.append(", ");
                }else{
                    stringBuilder.append(" et ");
                }
            }
        }
        //Display for five-pack notes
        if(result[1] > 0){
            stringBuilder.append(result[1]).append(" ticket");
            if(result[1] > 1)stringBuilder.append("s");
            stringBuilder.append(" from 5€");

            if(result[2] > 0)stringBuilder.append(" et ");
        }

        // Display for 2€ coins
        if(result[2] > 0){
            stringBuilder.append(result[2]).append("coin");
            if(result[2] > 1)stringBuilder.append("s");
            stringBuilder.append(" from 2€");
        }
        return stringBuilder.toString();
    }

}
