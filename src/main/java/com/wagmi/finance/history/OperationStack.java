package main.java.com.wagmi.finance.history;

/*
 TODO[Student]: Array-based stack
 - Enforce underflow/overflow behaviors per tests.
 - Note dynamic growth is allowed only when initial capacity >= 10.
 - Validate null pushes (should throw).
 - Run `OperationStackTest` after changes.
 */
public class OperationStack {

    private final String[] data;
    private int top = -1;

    public OperationStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("There are elements in the stack");
        }
        this.data = new String[capacity];
    }

    public void push(String operation) {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
         if (top==-1){
            top=0;
            data[top]=operation;
        }
        else if(top==data.length-1)
        {throw new UnsupportedOperationException("Stack overflow");}
        else{top++;
        data[top]=operation;}
        

    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow — nothing to pop!");
        }
        else{
        String value = data[top];

         top--;

        return value;
        }

    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty —there is nothing to peek!");
        }
        return data[top];
    }
        
        
    

    public boolean isEmpty() {
        return top < 0;
    }

    public int size() {
        return top + 1;
    }
}
