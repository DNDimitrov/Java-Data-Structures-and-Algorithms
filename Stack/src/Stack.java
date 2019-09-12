

public class Stack<E> {

    private E[] data;
    private int size;
    private int capacity;

    private Stack() {
        this.size = 0;
        capacity = 16;
        data = (E[]) new Object[16];
    }

    public void push(E newValue) {
        if(size == capacity) {
            resize(size*2 +1);
        }
        data[size]= newValue;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
        {
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
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
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<45;i++) {
            stack.push(i);
        }
        stack.pop();
        stack.push(1);
        stack.print();
    }
}
