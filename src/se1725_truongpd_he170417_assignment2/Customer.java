/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1725_truongpd_he170417_assignment2;

/**
 *
 * @author HE170417
 */
public class Customer {
    private String ccode,cusName,phone;

    public Customer() {
    }

    public Customer(String ccode, String cusName, String phone) {
        this.ccode = ccode;
        this.cusName = cusName;
        this.phone = phone;
    }

    public String getCcode() {
        return ccode;
    }
    //getter setter
    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    //to string
    @Override
    public String toString() {
        return "Customer{" + "ccode=" + ccode + ", cusName=" + cusName + ", phone=" + phone + '}';
    }
    public String loadToFile(){
        return ccode + "|" + cusName + "|" + phone;
    }
}
