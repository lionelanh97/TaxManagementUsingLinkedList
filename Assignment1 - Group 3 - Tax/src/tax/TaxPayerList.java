/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tax;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *      quangnmhe130059
 *      huypqhe130022
 *      quangnmhe130088
 *      huypqhe130069
 */
public class TaxPayerList extends MyLinkedList {

    public void saveToFile(String fname) {
        //if empty list
        if (this.size() == 0) {
            System.out.println("Empty list");
            return;
        }
        try {
            File f = new File(fname);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            //write all the list to file
            for (int i = 1; i <= this.size(); i++) {
                TaxPayer x = this.get(i);
                pw.println(x.getCode() + "," + x.getName() + "," + x.getIncome() + "," +x.getDeduct());
            }
            pw.close();
            fw.close();
            System.out.println("Save successfully.");
        } catch (Exception e) {
            System.out.println("Save Error.");
        }
    }

    public void loadFromFile(String fname) {
        try {
            //if list currently not empty
            if(!isEmpty()) {
                clear();
            }
            File f = new File(fname);
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            //read each line of the file
            while ((details = bf.readLine()) != null) {
                //Split into String[]
                String[] info = details.split(",");
                String code = info[0];
                String name = info[1];
                double income = Double.parseDouble(info[2]);
                double deduct = Double.parseDouble(info[3]);
                TaxPayer t = new TaxPayer(code, name, income, deduct);
                this.addToTail(t);
            }
            System.out.println("Load successfully.");
        } catch (Exception e) {
            System.out.println("Load Error.");
        }
    }

    public void searchCode() {
        //if list is currently empty
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        String findCode;
        //validate find code
        do {
            System.out.print("Enter code/part of code to search: ");
            findCode = sc.nextLine();
        } while (!ValidateData.checkBlank(findCode));
        //list to contain found code
        TaxPayerList findList = new TaxPayerList();
        //add found code to list
        for (int i = 1; i <= this.size(); i++) {
            if (this.get(i).getCode().toLowerCase().contains(findCode.toLowerCase())) {
                findList.addToTail(this.get(i));
            }
        }
        //if not found any code
        if (findList.isEmpty()) {
            System.out.println("Not found.");
            return;
        }
        display(findList);
    }

    public void addToEnd() {
        this.addToTail(createTaxPayer());
        System.out.println("Add successfully!");
    }

    public void addToBegin() {
        this.addToHead(createTaxPayer());
        System.out.println("Add successfully!");
    }
    
    int getPosition() {
        String positionStr;
        int position;
        //validate position
        while (true) {
            System.out.print("Enter position to add after: ");
            positionStr = sc.nextLine();
            //if not positive
            if (!ValidateData.checkPosInt(positionStr)) {
                continue;
            }
            position = Integer.parseInt(positionStr);
            //if position out of bound
            if (position > this.size()) {
                System.out.println("Position out of list number. Please enter again.");
                continue;
            }
            break;
        }
        return position;
    }
    
    public void addAfterPos() {
        //if list is currently empty
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        int position = getPosition();
        //adding
        this.addAfter(createTaxPayer(), position);
        System.out.println("Add successfully!");
    }

    public void display(TaxPayerList list) {
        //if list is currently empty
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        System.out.println("------------------------------List-----------------------------");
        System.out.println("No.\tCode\tName\tIncome\t\tDeduction\tTax");
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(i + "\t" + list.get(i).toString());
        }
    }

    public void deletePos() {
        //if list is currently empty
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        int position = getPosition();
        this.remove(position);
        System.out.println("Delete successfully.");
    }

    public void deleteCode() {
        //if list is currently empty
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        String codeDel;
        int index;
        //validate code to delete
        do {
            System.out.print("Enter code to delete: ");
            codeDel = sc.nextLine();
        } while (!ValidateData.checkBlank(codeDel));
        index = this.find(codeDel);
        //if code not found in list
        if (index == -1) {
            System.out.println("Code not found.");
            return;
        }
        this.remove(index);
        System.out.println("Delete successfully.");
    }

    public void sortCode() {
        //if list is currently empty
        if (isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        int size = this.size();
        //bubble sort the list by code
        for (int i = 1; i < size; i++) {
            for (int j = i + 1; j <= size; j++) {
                if (this.get(i).getCode().compareToIgnoreCase(this.get(j).getCode())
                        > 0) {
                    TaxPayer temp = this.get(i);
                    this.set(this.get(j), i);
                    this.set(temp, j);
                }
            }
        }
        System.out.println("Sort successfully.");
    }

    int find(String code) {
        //linearly search the list by code and return its position
        for (int i = 1; i <= this.size(); i++) {
            if (code.equalsIgnoreCase(this.get(i).getCode())) {
                return i;
            }
        }
        return -1;
    }

    TaxPayer createTaxPayer() {
        String code, name, incomeStr, deduct;
        double income;
        //validate code
        do {
            System.out.print("Enter taxpayer's code: ");
            code = sc.nextLine();
        } while (!checkCode(code));
        //validate name
        do {
            System.out.print("Enter taxpayer's name: ");
            name = sc.nextLine();
        } while (!ValidateData.checkBlank(name));
        //validate incomeStr
        do {
            System.out.print("Enter income: ");
            incomeStr = sc.nextLine();
        } while (!ValidateData.checkPosDouble(incomeStr));
        income = Double.parseDouble(incomeStr);
        //validate deduct
        do {
            System.out.print("Enter deduction: ");
            deduct = sc.nextLine();
        } while (!checkDeduct(deduct, income));
        return new TaxPayer(code, name, income, Double.parseDouble(deduct));
    }

    boolean checkCode(String code) {
        //not blank
        if (!ValidateData.checkBlank(code)) {
            return false;
        }
        //check existed
        if (this.find(code) != -1) {
            System.out.println("This code has existed in list. Please enter again.");
            return false;
        }
        return true;
    }

    boolean checkDeduct(String deductStr, double income) {
        //not blank
        if (!ValidateData.checkBlank(deductStr)) {
            return false;
        }
        //not double
        if (!ValidateData.isDouble(deductStr)) {
            System.out.println("This cannot contain non-digit character.");
            return false;
        }
        double deduct = Double.parseDouble(deductStr);
        //smaller than 0
        if (deduct < 0) {
            System.out.println("Deduction cannot be negative.");
            return false;
        }
        //greater than equal income
        if (deduct >= income) {
            System.out.println("Deduction must less than income.");
            return false;
        }
        return true;
    }

    static Scanner sc = new Scanner(System.in);

}
