/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1725_truongpd_he170417_assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author HE170417
 */
public class CustomerFunction {
    Scanner sc4 = new Scanner(System.in);
    NodeL<Customer> head, tail;

    public CustomerFunction() {
    }
    //=======================miscellaneous=======================
    public boolean isEmpty(){
        return head == null;
    }
    public void clear(){
        head = tail = null;
    }
    //=======================IO=======================
    public void addToFile(){
        NodeL<Customer> p = head;
        try{
            BufferedWriter writer;
            writer = new BufferedWriter(new FileWriter("Customer_Data.txt"));
            
            while(p!=null){
                writer.write(p.info.loadToFile()+"\n");
                p=p.next;
            }
            writer.close();
            System.out.println("Success");
        } catch (IOException ex) {
            System.out.println("Error occur");
            System.out.println(ex);
        }
        
    }
    public void LoadData(){
        String temp[],ccode,cusName,phone;
        try{
            BufferedReader reader;
            reader = new BufferedReader(new FileReader("Customer_Data.txt"));
            String line;
            while((line = reader.readLine())!=null){
                temp = line.split("\\|");
                ccode = temp[0];
                cusName = temp[1];
                phone = temp[2];
                addLast(new Customer(ccode,cusName,phone));
            }
            System.out.println("Success");
        }catch(IOException ex){
            System.out.println("Error occur");
            System.out.println(ex);
        }
    }
    //=======================Input & insert=======================
    public void addLast(Customer newCustomer){
        NodeL<Customer> x = new NodeL<>(newCustomer);
        if(isEmpty()){
            head = tail = x;
            return;
        }
        tail.next = x;
        tail = x;
    }
    public Customer input(){
        String ccode,cusName,phone;
        while(true){
            System.out.println("Ccode: ");
            ccode = sc4.nextLine();
            if(!isCcodeDuplicate(ccode)) break;
            System.out.println("Invalid! duplicated Ccode");
        }
        while(true){
            System.out.println("cusName: ");
            cusName = sc4.nextLine();
            break;
        }
        while(true){
            System.out.println("phone: ");
            phone = sc4.nextLine();
            if(isPhoneValid(phone)) break;
            System.out.println("Invalid! phone can be number only");
        }
        return new Customer(ccode,cusName,phone);
    }
    //=======================Traverse=======================
    public void traverse(){
        NodeL<Customer> p = head;
        while(p!= null){
            System.out.println(p.info.toString());
            p=p.next;
        }
        System.out.println();
    }
    //=======================Search=======================
    public NodeL<Customer> search(String ccode){
        NodeL<Customer> p = head;
        while(p!= null){
            if(p.info.getCcode().compareToIgnoreCase(ccode)==0){
                return p;
            }
            p=p.next;
        }
        return null;
    }
    //=======================Delete=======================
    public void dele(NodeL<Customer>p){
        if(p==null)return;
        NodeL<Customer> f = head, q = null;
        while(f!=null && f!=p){
            q = f;
            f=f.next;
        }
        //remove
        if(q==null){
            head = head.next;
            if(head == null) tail = null;
        }else{
            q.next = p.next;
            if(p==tail) tail = q;
        }
        p.next = null;
    }
    //=======================Validator=======================
    public boolean isCcodeDuplicate(String ccode){
        NodeL<Customer>p = head;
        if(isEmpty()){
            return false;
        }
        while(p != null){
            if(p.info.getCcode().compareToIgnoreCase(ccode)==0){
                return true;
            }
            p=p.next;
        }
        return false;
    }
    public boolean isPhoneValid(String phone){
        return !phone.matches("[^0-9]");
    }
}
