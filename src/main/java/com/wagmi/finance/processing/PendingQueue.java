package main.java.com.wagmi.finance.processing;

/*
 TODO[Student]: Circular queue for pending transactions
 - Implement circular `enqueue` and `dequeue` with head/tail updates and size tracking.
 - Enforce overflow/underflow rules as per tests.
 - Validate null enqueues (should throw).
 - Run `PendingQueueTest` after changes.
 */
import main.java.com.wagmi.finance.model.Transaction;

public class PendingQueue {

    private final Transaction[] data;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public PendingQueue(int capacity) {
        this.data = new Transaction[capacity];
    }

    public void enqueue(Transaction tx) {
        if (tx == null) {
            throw new IllegalArgumentException("Transaction cannot be null.");
        }

        throw new UnsupportedOperationException("Not implemented");
    }

    if (isFull()) {
            throw new UnsupportedOperationException("Queue is full. Cannot enqueue new transaction.");
        }

        
        data[tail] = tx;
        tail = (tail + 1) % data.length;
        size++;
    }

    public Transaction dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Queue is empty. Cannot dequeue transaction.");
        }

        Transaction temp = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;

        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public int size() {
        return size;
    }
