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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BusMain bm = new BusMain();
        CustomerMain cm = new CustomerMain();
        BookingMain bookm = new BookingMain(bm.returnBF(),cm.returnCF());
        Scanner sc = new Scanner(System.in);
        int option;
        while(true){
            printmenu(0);
            option = Integer.parseInt(sc.nextLine());
            switch(option){
                case 1:
                    bm.BusMain();
                    break;
                case 2:
                    cm.CustomerMain();
                    break;
                case 3:
                    bookm.BookingMain();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("invalid");
                    break;
            }
        }
    }
    public static void printmenu(int number){
        System.out.println("=======Bus booking system======="
                + "\n 1. Bus info"
                + "\n 2. Customer info"
                + "\n 3. Booking info"
                + "\n 0. Exit"
                + "\n Please choose your option: ");
          
    }
}
