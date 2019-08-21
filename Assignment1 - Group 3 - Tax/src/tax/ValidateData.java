/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tax;

/**
 * huypqhe130022
 */

public class ValidateData {
    static boolean checkBlank(String string) {
        if(string.trim().isEmpty()) {
            System.out.println("This cannot blank!");
            return false;
        }
        return true;
    }
    
    static boolean isInt(String string) {
        try {
            int temp = Integer.parseInt(string);
        }catch(Exception e) {
            return false;
        }
        return true;
    }
    
    static boolean isDouble(String string) {
        try {
            double temp = Double.parseDouble(string);
        }catch(Exception e) {
            return false;
        }
        return true;
    }
    
    static boolean checkOption(String choiceStr) {
        if(!checkBlank(choiceStr)) return false;
        //check exception if user enter non-integer
        if(!isInt(choiceStr)) {
            System.out.println("This cannot contain non-digit character");
            return false;
        }
        int option=Integer.parseInt(choiceStr);
        //if option is not in menu (out of range [1,5])
        if(option < 0 || option > 10) {
            System.out.println("Option "+option+" not in menu");
            return false;
        }
        return true;
    }
    
    static boolean checkPosInt(String posIntStr) {
        //check exception if user enter non-integer
        if(!isInt(posIntStr)) {
            System.out.println("This cannot contain non-digit character");
            return false;
        }
        int posInt=Integer.parseInt(posIntStr);
        if(posInt <= 0) {
            System.out.println("This must be greater than 0");
            return false;
        }
        return true;
    }
    
    static boolean checkPosDouble(String posDouble) {
        //check exception if user enter non-double
        if(!isDouble(posDouble)) {
            System.out.println("This cannot contain non-digit character");
            return false;
        }
        if(Double.parseDouble(posDouble) <= 0) {
            System.out.println("This must be greater than 0");
            return false;
        }
        return true;
    }
    
}
