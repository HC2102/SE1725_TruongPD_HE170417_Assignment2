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
public class BookingFunction {
    NodeL<Booking> head, tail;
    CustomerFunction cf;
    BusFunction bf;
    Scanner sc6 = new Scanner(System.in);

    public BookingFunction(CustomerFunction cf, BusFunction bf) {
        this.cf = cf;
        this.bf = bf;
        head = tail = null;
    }
    //===========================Traverse===========================
    public void traverse(){
        NodeL<Booking> p = head;
        while(p!=null){
            System.out.println(p.info.toString());
            p=p.next;
        }
        System.out.println();
    }
    //===========================Miscellaneous===========================
    public boolean isEmpty(){
        return head == null;
    }
    public void clear(){
        head = tail = null;
    }
    //===========================Insert===========================
    public void addLast(Booking newBooking){
        if(newBooking==null){
            return;
        }
        NodeL<Booking> x = new NodeL<>(newBooking);
        if(isEmpty()){
            head = tail = x;
        }else{
            tail.next = x;
            tail = x;
        }
    }
    public Booking input(){
        String bcode,ccode;
        int seat;
        while(true){
            System.out.println("input Bcode");
            bcode = sc6.nextLine();
            if(!bcode.isEmpty())break;
            System.out.println("Bcode must not be empty");
        }
        while(true){
            System.out.println("input Ccode");
            ccode = sc6.nextLine();
            if(!ccode.isEmpty())break;
            System.out.println("Ccode must not be empty");
        }
        while(true){
            System.out.println("input seat");
            seat = Integer.parseInt(sc6.nextLine());
            if(seat>0)break;
            System.out.println("Seat must not be negative or 0");
        }
        //check record
        if(bf.search(bf.root, bcode)!= null&& cf.search(ccode)!= null){
            System.out.println("Data found in bus and customer database");
            int checkAvailable = bf.search(bf.root, bcode).info.getSeat()-bf.search(bf.root, bcode).info.getBooked();
            if(bf.search(bf.root, bcode).info.getSeat()>bf.search(bf.root, bcode).info.getBooked() &&checkAvailable>=seat){
                System.out.println("enough seat for you to book!");
                bf.search(bf.root, bcode).info.setBooked(bf.search(bf.root, bcode).info.getBooked()+seat);
            }
            else{
                System.out.println("Number of seat is not enough for you to book");
                return null;
            }
        }else{
            System.out.println("Record not found in database");
            return null;
        }
        //save bf and cf data
        try{
            bf.inOrderDataToFile();
        }catch(IOException ex){
            System.out.println(ex);
        }
        try {
            bf.inOrderDataToFile();
        } catch (IOException ex) {
            Logger.getLogger(BookingFunction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Booking(bcode,ccode,seat);
    }
    //===========================Sort===========================
    public void sort(){
        NodeL<Booking> i = head;
        NodeL<Booking> j;
        Booking temp;
        while(i!=null){
            j = i.next;
            while(j!=null){
                if(i.info.getBcode().compareToIgnoreCase(j.info.getBcode())>0){
                temp = i.info;
                i.info = j.info;
                j.info = temp;
                }
                if(i.info.getBcode().compareToIgnoreCase(j.info.getBcode())==0){
                    if(i.info.getCcode().compareToIgnoreCase(j.info.getCcode())>0){
                       temp = i.info;
                       i.info = j.info;
                       j.info = temp; 
                    }
                }
                j = j.next;
            }
            i = i.next;
        }
    }
}
