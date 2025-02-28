package notationpackage;

import java.util.ArrayList;

public class MyStack<T>  implements StackInterface <T>{
    private T[] stack;
    private int top;
    private int capacity;
    
    
    public MyStack(int size) {
        capacity = size;
        stack = (T[]) new Object[size];
        top = -1;
    }
    
    public MyStack() {
        capacity = 10; //default size 
        stack = (T[]) new Object[10];
        top = -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    public T pop() {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return stack[top--];
    }
    
    public boolean push(T element) {
        if (isFull()) {
            throw new StackOverflowException();
        }
        stack[++top] = element;
        return true;
    }
    
    public T top() {
        if (isEmpty()) {
            throw new StackUnderflowException();
        }
        return stack[top];
    }
    
    public int size() {
        return top + 1;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }
    
    public String toString(String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
            if (i < top) {
                sb.append(delimiter);
            }
        }
        return sb.toString();
    }
    
    public void fill(ArrayList<T> list) {
        top = -1;
        for (T item : list) {
            try {
                push(item);
            } catch (RuntimeException e) {
                break;
            }
        }
    }
}
