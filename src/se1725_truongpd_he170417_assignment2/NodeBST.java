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
public class NodeBST {
    Bus info;
    NodeBST left,right;

    public NodeBST() {
    }

    public NodeBST(Bus info, NodeBST left, NodeBST right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public NodeBST(Bus info) {
        this(info,null,null);
    }
    
}
