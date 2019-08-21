/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tax;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * huypqhe130022 
 */
public class TaxPayer implements Serializable {

    private String code, name;
    private double income, deduct;

    public TaxPayer() {
    }

    public TaxPayer(String code, String name, double income, double deduct) {
        this.code = code;
        this.name = name;
        this.income = income;
        this.deduct = deduct;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getIncome() {
        return income;
    }

    public double getDeduct() {
        return deduct;
    }
    
    public double getTax() {
        double tax;
        double taxable = income - deduct;
        tax = taxable * (taxable <= 5000 ? 0.05 : (taxable <= 10000 ? 0.1 : 0.15));
        return tax;
    }

    @Override
    public String toString() {
        double tax = getTax();
        String taxStr = new DecimalFormat(".##").format(tax);
        return code + "\t" + name + "\t" + income + "\t\t" + deduct + "\t\t" + taxStr;
    }

}
