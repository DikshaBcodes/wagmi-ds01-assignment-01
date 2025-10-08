package main.java.com.wagmi.finance.ds;

/*
 TODO[Student]: Doubly linked list of transactions
 - Implement tail-insert `add`, `deleteById`, `findById`, `reverse`, `toArray`.
 - Maintain `head`, `tail`, and `size` correctly across all operations.
 - After each edit, run `DoublyLinkedTransactionsTest` (or `./scripts/test-run.sh`).
*/

import main.java.com.wagmi.finance.model.Transaction;

public class DoublyLinkedTransactions {

    private static class Node {
        Transaction value;
        Node prev;
        Node next;

        Node(Transaction value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void add(Transaction tx) {
        if(tx==null){
            return;
        }

        Node temp=new Node(tx);
        if(head==null){
            head=temp;
            tail=temp;
        }
        else{
            tail.next=temp;
            temp.prev=tail;
            tail=temp;
            
        }
        size++;

       
    }

    public boolean deleteById(String id) {
        if (id == null || head == null) {
            return false;
        }

        Node current = head;
        while (current != null) {
        
            if (current.value != null && id.equals(current.value.getId())) {
                
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                
                current.prev = null;
                current.next = null;

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    
    }

    public Transaction findById(String id) {
        if(id==null || head==null){
            return null;
        }
        Node temp=head;
        while(temp!=null){
            if(temp.value !=null){
                String curid=temp.value.getId();
                if(curid!=null && id.equals(curid)){
                    return temp.value;
                }
            }
            temp=temp.next;
        }
        return null;

        
    }

    public void reverse() {
        if (head == null || head == tail) {
            return; 
        }

        Node current = head;
        Node temp = null;

        while (current != null) {
            temp = current.prev; 
            current.prev = current.next; 
            current.next = temp;         

            current = current.prev; 
        }
        
        temp = head;
        head = tail;
        tail = temp;
        
    }

    public int size() {
        return size;
    }

    public Transaction[] toArray() {
        Transaction[] arr=new Transaction[size];
        if(size==0){
            return arr;
        }
        Node temp=head;
        int i=0;
        while(temp!=null){
            arr[i]=temp.value;
            temp=temp.next;
            i++;
        }
        return arr;
        
    }
}