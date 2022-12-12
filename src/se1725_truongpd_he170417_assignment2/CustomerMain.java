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
public class CustomerMain {
    Scanner sc5 = new Scanner(System.in);
    CustomerFunction cf = new CustomerFunction();
    public void CustomerMain(){
        int option;
        String target;
        while(true){
            System.out.println("=======Customer info======="
                        + "\n 1.Load data from file"
                        + "\n 2.Input & add to the end"
                        + "\n 3.Display data"
                        + "\n 4.Save customer list to file"
                        + "\n 5.Search by ccode"
                        + "\n 6.Delete by ccode"
                        + "\n 0. Exit"
                        + "\n Please choose your option:");
            option = Integer.parseInt(sc5.nextLine());
            switch(option){
                case 1:
                    cf.LoadData();
                    break;
                case 2:
                    cf.addLast(cf.input());
                    break;
                case 3:
                    cf.traverse();
                    break;
                case 4:
                    cf.addToFile();
                    break;
                case 5:
                    System.out.println("Choose ccode you want to find");
                    target = sc5.nextLine();
                    System.out.println(cf.search(target).info.toString());
                    break;
                case 6:
                    System.out.println("Choose ccode you want to find");
                    target = sc5.nextLine();
                    cf.dele(cf.search(target));
                    cf.traverse();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid");
                    break;
            }
        }
    }
    public CustomerFunction returnCF(){
        return cf;
    }
}
