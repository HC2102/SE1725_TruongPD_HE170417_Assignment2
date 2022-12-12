/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se1725_truongpd_he170417_assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HE170417
 */
public class BusFunction {
    NodeBST root;
    Scanner sc1 = new Scanner(System.in);
    ArrayList<NodeBST> a;


    public BusFunction() {
        this.root = null;
    }
    //=========================Input Output=========================
    public void inOrderDataToFile(NodeBST p, FileWriter fw) throws IOException{
        if(p==null)return;
        inOrderDataToFile(p.left,fw);
        visit(p,fw);
        inOrderDataToFile(p.right,fw);
    }
    public void inOrderDataToFile() throws IOException{
        try (FileWriter fw = new FileWriter("Bus_Data.txt")) {
            inOrderDataToFile(root,fw);
        }
        System.out.println("Success");
        
    }
    public void loadDataFromFile(){
        try{
            String tmpBcode, tmpBname;
            int tmpSeat, tmpBooked;
            double tmpDepartTime,tmpArrivalTime;
            BufferedReader reader;
            reader = new BufferedReader(new FileReader("Bus_Data.txt"));
            String line;
            String temp[];
            while((line = reader.readLine())!= null){
                temp = line.split("\\|");
                tmpBcode = temp[0];
                tmpBname = temp[1];
                tmpSeat = Integer.parseInt(temp[2]);
                tmpBooked = Integer.parseInt(temp[3]);
                tmpDepartTime = Double.parseDouble(temp[4]);
                tmpArrivalTime = Double.parseDouble(temp[5]);
                insert(new Bus(tmpBcode,tmpBname,tmpSeat,tmpBooked,tmpDepartTime,tmpArrivalTime));
            }
            reader.close();
            System.out.println("Success");
        }catch(IOException ex){
            System.out.println("Error occurs");
            System.out.println(ex);
        }
    }
    //=========================miscellaneous function=========================
    public boolean isEmpty(){
        return root == null;
    }
    public void clear(){
        root  = null;
    }
    public void visit(NodeBST p){
        if(p ==null){
            return;
        }else{
            System.out.println(p.info.toString());
        }
    }
    public void visit(NodeBST p, FileWriter fw) throws IOException{
        fw.write(p.info.saveToFile()+"\n");
    }
    //=========================insert & Input=========================
    public void insert(Bus newBus){
        NodeBST newNode = new NodeBST(newBus);
        NodeBST f = null; //father of p;
        NodeBST p = root;
        while(p!=null){
            if(p.info.getBcode().compareToIgnoreCase(newNode.info.getBcode())==0){
                System.out.println("Key cannot be duplicated...");
                return;
            }
            if(p.info.getBcode().compareToIgnoreCase(newNode.info.getBcode())<0){
                f= p;
                p = p.right;
            }
            else{
                f = p;
                p = p .left;
            }
        }
        if(f==null){root = newNode;}
        else if(f.info.getBcode().compareToIgnoreCase(newNode.info.getBcode())<0){
            f.right = newNode; 
        }else{
            f.left = newNode;
        }
    }
    public Bus inputNewBus(){
        String tmpBcode, tmpBname;
        int tmpSeat, tmpBooked;
        double tmpDepartTime,tmpArrivalTime;
        while(true){
            System.out.println("Input a new Bus info");
            System.out.println("Bcode");
            tmpBcode = sc1.nextLine();
            if (isBcodeValid(tmpBcode)) break;
            System.out.println("Invalid Bcode! duplicated");
        }
        
        System.out.println("bus name");
        tmpBname = sc1.nextLine();
        while(true){
            System.out.println("seat");
            tmpSeat = Integer.parseInt(sc1.nextLine());
            if(isSeatValid(tmpSeat)) break;
            System.out.println("Invalid seat! seat must be >0");
        }
        while(true){
            System.out.println("booked");
            tmpBooked = Integer.parseInt(sc1.nextLine());
            if(tmpBooked>=0 && tmpBooked <=tmpSeat) break;
            System.out.println("Invalid booked! booked >= 0 and booked ≤ seat");
        }
        while(true){
            System.out.println("Depart time");
            tmpDepartTime = Double.parseDouble(sc1.nextLine());
            if(tmpDepartTime >0)break;
            System.out.println("Invalid depart_time >= 0");
        }
        while(true){
            System.out.println("Arrival time");
            tmpArrivalTime = Double.parseDouble(sc1.nextLine());
            if(tmpArrivalTime > tmpDepartTime) break;
            System.out.println("Invalid ArrivalTime arrival_time > depart_time");
        }
        return new Bus(tmpBcode,tmpBname,tmpSeat,tmpBooked,tmpDepartTime,tmpArrivalTime);
    }
    //=========================Traverse=========================
    public void inOrder(NodeBST p){
        if(p==null){
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    public void BFT(NodeBST p){
        if(p==null){
            return;
        }
        MyQueue queue = new MyQueue();
        queue.enqueue(p);
        while(!queue.isEmpty()){
            NodeBST q = (NodeBST)queue.dequeue();
            visit(q);
            if(q.left!=null)queue.enqueue(q.left);
            if(q.right != null)queue.enqueue(q.right);
        }
    }
    //=========================Search=========================
    public NodeBST search(NodeBST p, String Bcode){
        if(p == null)return null;
        if(p.info.getBcode().compareToIgnoreCase(Bcode)==0){
            return p;
        }else if(p.info.getBcode().compareToIgnoreCase(Bcode)>0){
            return search(p.left,Bcode);
        }else{
            return search(p.right,Bcode);
        }
    }
    //=========================Delete=========================
    public void deleteByCopy(String x){
        NodeBST target = search(root,x);
        if(target == null){
            System.out.println("Key not exit, deletion failed");
            return;
        }
        NodeBST f = null, p = root;
        while(p!= target){
            f=p;
            if(p.info.getBcode().compareToIgnoreCase(target.info.getBcode())>0){
                p = p.left;
            }else{
                p = p.right;
            }
        }
        // 1. target is a leaf
        if(target.left == null && target.right == null){
            // if a BST has a Node only
            if(f == null){
                root =null;
            }
            else if(f.left == p){
                f.left = null;
            }else if(f.right == p){
                f.right = null;
            }
        }
        // 2. p has a right child only
        else if( p.right != null && p.left == null){
            if(f== null){
                root = p.right;
            }
            else if(f.right == p){
                f.right = p.right;
            }else if(f.left ==p){
                f.left = p.right;
            }
        }
        // 3. p has a left child only
        else if ( p.right == null && p.left != null){
            if(f==null){
                //remove root
                root = p.left;
            }else if(f.right == p){
                f.right = p.left;
            }
            else if(f.left == p){
                f.left = p.left;
            }
        }
        //both
        else if(p.left != null && p.right != null){
            f = null;
            NodeBST rp = p.left;
            while(rp.right != null){
                f = rp;
                rp = rp.right;
            }
            p.info = rp.info;
            if(f==null){
                p.left = rp.left;
            }else{
                f.right = rp.left;
            }
        }
    }
    //=========================Balancing=========================
    public void balance(ArrayList a, int first, int last){
        if(first > last) return;
        int m = (first + last)/2;
        Bus x = ((NodeBST)a.get(m)).info;
        insert(x);
        balance(a,first,m-1);
        balance(a, m+1,last);
    }
    public void balance(NodeBST p){
        ArrayList a = new ArrayList();
        buildArray(a,p);
        int first = 0;
        int last = a.size()-1;
        BusFunction newTree = new BusFunction(); //create new tree
        newTree.balance(a,first, last);
        root = newTree.root;
    }
    //copy all node to tree by inorder traversal
    public void buildArray(ArrayList a, NodeBST p){
        if(p == null) return;
        buildArray(a,p.left);
        a.add(p);
        buildArray(a,p.right);
    }
    //=========================Count=========================
    public int count(NodeBST p){
        if(p==null)return 0;
        int k,h,r;
        k = count(p.left);
        h = count(p.right);
        r = k+h+1;
        return r;
    }
    //=========================Validate=========================
    boolean isSeatValid(int seat){
        return seat>0;
    }
    boolean isBcodeValid(String Bcode){
        NodeBST f = null; //father of p;
        NodeBST p = root;
        while(p!=null){
            if(p.info.getBcode().compareToIgnoreCase(Bcode)==0){
                return false;
            }
            if(p.info.getBcode().compareToIgnoreCase(Bcode)<0){
                f= p;
                p = p.right;
            }
            else{
                f = p;
                p = p .left;
            }
        }
        return true;
    }
}
