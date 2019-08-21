/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tax;

/**
 * huypqhe130022 
 */

public class Node {
    TaxPayer info;
    Node next;

    public Node() {
        next = null;
        info = null;
    }

    public Node(TaxPayer info, Node next) {
        this.info = info;
        this.next = next;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(TaxPayer info) {
        this.info = info;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    
    
}
