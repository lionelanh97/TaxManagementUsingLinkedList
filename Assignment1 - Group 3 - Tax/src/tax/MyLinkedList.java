/*
    Class linked list to be extended
 */
package tax;

/**
 * huypqhe130022 
 */

public class MyLinkedList {
    Node head;
    Node tail;
    
    public MyLinkedList() {
        head = tail = null;        
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void clear() {
        head = null;
        tail = null;
    }
    
    public void addToHead(TaxPayer add) {
        //if list is empty
        if(isEmpty()) {
            head = new Node(add, null);
            tail = head;
        }else {
            Node temp = new Node(add,head);
            head = temp;
        }
    }
    
    public void addToTail(TaxPayer adder) {
        if(isEmpty()) {
            head = new Node(adder, null);
            tail = head;
        }else {
            Node temp = new Node(adder,null);
            tail.next = temp;
            tail = temp;
        }
    }
    
    public int size() {
        int count = 0;
        for (Node i = head; i != null; i=i.next) {
            count++;
        }
        return count;
    }
    
    //get node at position k
    private Node get(int position, boolean isNode) {
        if(position > size()) {
            System.out.println("Position not found!");
            return null;
        }
        for (Node i = head; i!=null; i=i.next) {
            position--;
            if(position==0) {
                return i;
            }
        }
        return null;
    }
    
    //get taxpayer at position k
    public TaxPayer get(int position) {
        if(position > size()) {
            System.out.println("Index not found!");
            return null;
        }
        for (Node i = head; i != null; i=i.next) {
            position--;
            if(position == 0) return i.info;
        }
        return null;
    }
    
    //add after position k
    public void addAfter(TaxPayer add, int position) {
        Node current = get(position,true);
        if(current.equals(tail)) addToTail(add);
        else {
            Node after = current.next;
            Node temp = new Node(add,after);
            current.next = temp;
        }
    }
    
    //set a taxpayer at position k
    public void set(TaxPayer set,int position) {
        get(position,true).info = set;
    }
    
    //remove a node at position k
    public void remove(int position) {
        //size of list == 1 => clear th list
        if(this.size() == 1) {
            this.clear();
            return;
        }
        //get the node at position k
        Node current = get(position,true);
        Node after = current.next;
        //delete head
        if(current.equals(head)) {
            head = head.next;
            return;
        }
        //find the node before delete node
        Node before = head;
        while(before.next!=current) {
            before = before.next;
        }
        //delete tail
        if(after == null) {
            before.next = null;
            tail = before;
        //delete current node
        }else {
            before.next = after;
        }
    }
    
}