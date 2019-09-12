import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> {

    private E[] data;
    private int size;
    private int first;
    private int last;

    private Queue() {
        this.size = 0;
        this.first = 0;
        this.last = 0;
        data = (E[]) new Object[16];
    }


    public void add(E newValue) {
        if(size == data.length) {
            resize(size*2 +1);
        }
        data[last++] = newValue;
        if(last == data.length) last = 0;
        size++;
    }

    private void resize(int newCapacity) {
        assert newCapacity >= size;
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
        {
            newData[i] = data[(first + i) % data.length];
        }
        data = newData;
        first = 0;
        last = size;
    }

    public final E remove() {
        if(isEmpty()) {
            throw new RuntimeException("Can't pop from empty stack");
        }
        E front = data[first];
        data[first] = null;
        E[] newData = (E[]) new Object[size-1];
        for (int i = 0; i < size-1; i++)
        {
            newData[i] = data[i+1];
        }
        data = newData;
        size--;
        if(first == data.length) first = 0;
        if(size>0 && size == data.length/4) resize(data.length/2);
        return front;
    }

    public final E peek() {
        if(isEmpty()) {
            throw new RuntimeException("No elements");
        }
        return this.data[first];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void print() {
        for(int i=0;i<this.size;i++) {
            System.out.print(data[i] + " ");
        }
    }

    public int size() {
        return this.size;
    }

    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<E> {
        private int i =0;
        public boolean hasNext() {
            return i < size;
        }
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = data[(i + first) % data.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<>();
        for(int i=0;i<45;i++) {
            queue.add(i);
        }

        queue.peek();
        System.out.println("The peek is " + queue.peek());
        int head =queue.remove();
        System.out.println(head+ " is removed from the Queue");
        System.out.println("The peek is " + queue.peek());
        queue.add(1);
        queue.add(66);
        queue.add(88);
        queue.remove();
        queue.print();
    }
}