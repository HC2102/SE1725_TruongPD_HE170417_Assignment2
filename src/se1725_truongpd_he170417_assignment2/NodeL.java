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
public class NodeL <T>{
    T info;
    NodeL<T> next;

    public NodeL() {
    }
    public NodeL(T info, NodeL<T> next) {
        this.info = info;
        this.next = next;
    }
    public NodeL(T info) {
        this.info = info;
        this.next = null;
    }
}
