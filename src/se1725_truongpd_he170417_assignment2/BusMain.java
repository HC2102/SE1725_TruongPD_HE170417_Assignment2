/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1725_truongpd_he170417_assignment2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HE170417
 */
public class BusMain {
    BusFunction bf = new BusFunction();
    Scanner sc3 = new Scanner(System.in);
    public void BusMain(){
        int option;
        String target;
        while(true){
            System.out.println("=======Bus info======="
                                + "\n 1.Load data from file"
                                + "\n 2.Input & insert data"
                                + "\n 3.In-order traverse"
                                + "\n 4.Breadth-first traverse"
                                + "\n 5.In-order traverse to file"
                                + "\n 6.Search by bcode"
                                + "\n 7.Delete by bcode by copying"
                                + "\n 8.Simply balancing"
                                + "\n 9.Count number of buses"
                                + "\n 0. Exit"
                                + "\n Please choose your option");
            option = Integer.parseInt(sc3.nextLine());
            switch(option){
                case 1:
                    bf.loadDataFromFile();
                    break;
                case 2:
                    Bus newBus = bf.inputNewBus();
                    bf.insert(newBus);
                    break;
                case 3:
                    bf.inOrder(bf.root);
                    break;
                case 4:
                    bf.BFT(bf.root);
                    break;
                case 5:
            {
                try {
                    bf.inOrderDataToFile();
                } catch (IOException ex) {
                    Logger.getLogger(BusMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case 6:
                    System.out.println("Choose Bcode you want to find");
                    target = sc3.nextLine();
                    bf.visit(bf.search(bf.root, target));
                    break;
                case 7:
                    System.out.println("Choose Bcode you want to delete");
                    target = sc3.nextLine();
                    bf.deleteByCopy(target);
                    bf.inOrder(bf.root);
                    break;
                case 8:
                    bf.balance(bf.root);
                    break;
                case 9:
                    System.out.println("Count "+bf.count(bf.root));
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid");
                    break;

            }
        }
    }
    public BusFunction returnBF(){
        return bf;
    }
}
