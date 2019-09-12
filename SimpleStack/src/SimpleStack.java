

public class SimpleStack<E> {

    private E[] data;
    private int size;
    private int capacity;

    private SimpleStack(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
    }

    public void push(E newValue) {
        if(size == capacity) {
            throw new RuntimeException("Stack is full");
        }
        data[size]= newValue;
        size++;
    }

    public void pop() {
        if(size == 0) {
            throw new RuntimeException("Can't pop from empty stack");
        }
        size--;
    }

    public final E peek() {
        return this.data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for(int i=0;i<this.size;i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        SimpleStack<Integer> stack = new SimpleStack<>(10);
        for(int i=0;i<5;i++) {
            stack.push(i);
        }
        stack.pop();
        stack.push(1);
        stack.print();
        stack.push(5);
        stack.print();
    }
}
