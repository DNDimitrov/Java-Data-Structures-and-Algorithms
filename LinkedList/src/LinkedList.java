public class LinkedList {

    private static Node head;

    private static class Node {
        int value;
        Node next;
        Node(int data) {
            value = data;
            next = null;
        }
    }

    public static void insert(int value) {
        Node newNode = new Node(value);
        newNode.next = null;
        if(head == null) {
            head = newNode;
        }
        else {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public static void delete(int value) {
        Node prev = null;
        Node curr = head;
        if(head==null) {
            throw new RuntimeException("You cant delete from empty list!");
        }
        else {
            while (curr != null) {
                if (head.value == value) {
                    curr = head.next;
                    head.next = null;
                    head = curr;
                } else if (curr.value == value) {
                    prev.next = curr.next;
                    curr.next = null;
                    break;
                }
                prev = curr;
                curr = curr.next;
                if( curr == null) {
                    System.out.println(value + " not found!");
                }
            }
        }

    }

    public static void print() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        list.insert(6);
        list.insert(3);
        list.insert(2);
        list.insert(1);
        list.delete(11);
        list.print();



    }
}
