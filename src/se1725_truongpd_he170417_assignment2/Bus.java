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
public class Bus {
    private String bcode, busName;
    private int seat, booked;
    private double departTime,arrivalTime;

    public Bus() {
    }

    public Bus(String bcode, String busName, int seat, int booked, double departTime, double arrivalTime) {
        this.bcode = bcode;
        this.busName = busName;
        this.seat = seat;
        this.booked = booked;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
    }
    //constructor
    @Override
    public String toString() {
        return "Bus{" + "bcode=" + bcode + ", busName=" + busName + ", seat=" + seat + ", booked=" + booked + ", departTime=" + departTime + ", arrivalTime=" + arrivalTime + '}';
    }
    public String saveToFile(){
        return bcode + "|" + busName + "|" + seat + "|" + booked + "|" + departTime + "|" + arrivalTime ;
    }
    //getter & setter
    public String getBcode() {
        return bcode;
    }

    

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepartTime() {
        return departTime;
    }

    public void setDepartTime(double departTime) {
        this.departTime = departTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
}
