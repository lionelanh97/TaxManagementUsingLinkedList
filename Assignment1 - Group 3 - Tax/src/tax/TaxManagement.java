/*
 This class contain main method
 */
package tax;

import java.util.Scanner;

/**
 *
 * @author MSI
 */
public class TaxManagement {
    //scanner to get input of user
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TaxManagement main = new TaxManagement();
        //list of taxpayer
        TaxPayerList list = new TaxPayerList();
        //file name
        String fileName = "taxes.txt";
        int choice;
        //repeat until user choose EXIT
        do {
            //display menu and get choice of user
            choice = main.getChoiceFromMenu();
            //execute choice of user
            switch(choice) {
                case 1:
                    list.loadFromFile(fileName);
                    break;
                case 2:
                    list.addToEnd();
                    break;
                case 3:
                    list.display(list);
                    break;
                case 4:
                    list.saveToFile(fileName);
                    break;
                case 5:
                    list.searchCode();
                    break;
                case 6:
                    list.deleteCode();
                    break;
                case 7:
                    list.sortCode();
                    break;
                case 8:
                    list.addToBegin();
                    break;
                case 9:
                    list.addAfterPos();
                    break;
                case 10:
                    list.deletePos();
                    break;
                default:
                    System.out.println("Thanks for using!");
            }
            System.out.println("");
        }while(choice >= 1 && choice <= 10);
    }
    
    int getChoiceFromMenu() {
        System.out.println("======================== Tax Management ========================");
        System.out.println("1.  Load data from file");
        System.out.println("2.  Input & add data to end");
        System.out.println("3.  Display data");
        System.out.println("4.  Save data to file");
        System.out.println("5.  Search by code");
        System.out.println("6.  Delete by code");
        System.out.println("7.  Sort by code");
        System.out.println("8.  Input & add data to beginning");
        System.out.println("9.  Add after position k");
        System.out.println("10. Delete position k");
        System.out.println("0.  Exit");
        System.out.print("Your selection(0 -> 10): ");
        String choiceStr;
        //repeat if user enter invalid choice
        do {
            choiceStr = sc.nextLine();
        }while(!ValidateData.checkOption(choiceStr));
        return Integer.parseInt(choiceStr);
    }
}
