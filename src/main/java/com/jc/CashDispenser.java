package com.jc;

public class CashDispenser {

    public static void giveChange(int amount){
        //Check if the integer is positive
        if(amount <=0){
            throw new IllegalArgumentException("Amount must be a positive number");
        }
        // Case where the amount is 1 or 3 (impossible to return with the available notes)
        if(amount == 1 || amount == 3){
            System.out.println(amount + "Impossible to return with 10, 5 tickets and 2 coins");
            return ;
        }

        int billetsDix = amount / 10;
        int remainingAmount = amount %10;

        int billetsCinq = 0;
        int piecesDeux = 0;
       // Management of the various cases for the rest

        switch(remainingAmount){
            case 1:
            if(billetsDix > 0){
                billetsDix --;
                billetsCinq = 1;
                piecesDeux = 3;
            }
            break;
            case 2:
                piecesDeux = 1;
                break;
            case 3:
                    if(billetsDix >0){
                        billetsDix --;
                        billetsCinq = 1;
                        piecesDeux = 4;
                    }
                    break;
            case 4:
                piecesDeux = 2;
                break;
            case 5:
                billetsCinq = 1;
                break;
           case 6:
               piecesDeux = 3;
               break;
           case 7:
               billetsCinq = 1;
               piecesDeux = 1;
               break;
           case 8:
               piecesDeux = 4;
               break;
           case 9:
               billetsCinq = 1;
               piecesDeux = 2;
               break;
        }

            StringBuilder result = new StringBuilder();
            //Display for ten-pack notes
            boolean first = true;

            if(billetsDix > 0){
                result.append(billetsDix ).append(" billets (s) de 10 €");
                first = false;
            }
            if(billetsCinq > 0){
                if(!first) result.append(" et ");
                result.append(billetsCinq ).append(" billets(s) de 5€");
                first = false;
            }
            if(piecesDeux > 0){
                if(!first) result.append(" and ");
                result.append(piecesDeux ).append(" piéces(s) 2€");


            }
            System.out.println(result);

    }




}
