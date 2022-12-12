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
public class Booking {
    private String bcode,ccode;
    private int seat;

    public Booking() {
    }

    public Booking(String bcode, String ccode, int seat) {
        this.bcode = bcode;
        this.ccode = ccode;
        this.seat = seat;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Booking{" + "bcode=" + bcode + ", ccode=" + ccode + ", seat=" + seat + '}';
    }
    
}
