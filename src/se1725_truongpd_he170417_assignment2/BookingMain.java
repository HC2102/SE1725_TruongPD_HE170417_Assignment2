/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1725_truongpd_he170417_assignment2;

import java.util.Scanner;

/**
 *
 * @author HE170417
 */
public class BookingMain {
    BusFunction bf;
    CustomerFunction cf;
    BookingFunction bookf;
    Scanner sc7 = new Scanner(System.in);
    int option;
    public BookingMain(BusFunction bf, CustomerFunction cf) {
        this.bf = bf;
        this.cf = cf;
        bookf = new BookingFunction(cf,bf);
    }
    public void BookingMain(){
        bf.loadDataFromFile();
        cf.LoadData();
        while(true){
            System.out.println("=======Booking info======="
                        + "\n 1.Input data"
                        + "\n 2.Display booking data"
                        + "\n 3.Sort by bcode + ccode"
                        + "\n 0.Exit"
                        + "\n Please choose your option");
            option = Integer.parseInt(sc7.nextLine());
            switch(option){
                case 1:
                    bookf.addLast(bookf.input());
                    break;
                case 2:
                    bookf.traverse();
                    break;
                case 3:
                    bookf.sort();
                    bookf.traverse();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("invalid");
                    break;
            }
        }
    }
}