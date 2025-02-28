package notationpackage;

import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
    private ArrayList<T> queue;
    private int capacity;

    public MyQueue(int size) {
        this.capacity = size;
        this.queue = new ArrayList<>(size);
    }

    public MyQueue() {
        this.capacity = 20; // default size
        this.queue = new ArrayList<>(20);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return queue.size() >= capacity;
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }
        return queue.remove(0);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean enqueue(T e)  {
        if (isFull()) {
            
            throw new QueueOverflowException();
        }
        return queue.add(e);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : queue) {
            sb.append(item);
        }
        return sb.toString();
    }

    public String toString(String delimeter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < queue.size(); i++) {
            if (i > 0) sb.append(delimeter); //adds separator between the  elements
            sb.append(queue.get(i));
        }
        return sb.toString();
    }


    @Override
    public void fill(ArrayList<T> list) {
        queue.clear();
        for (T item : list) {
      
            if (isFull()) {
                break;
            }{
            queue.add(item);
        }
    }
    }
   }

