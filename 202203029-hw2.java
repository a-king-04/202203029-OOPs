import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    void insert(int data) {
        Node node1 = new Node(data);
        if (head == null) {
            head = node1;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node1;
        }
    }

    void delete() {
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.data > 25) {
                if (prev == null) {
                    head = current.next;
                    current = head;
                } else {
                    prev.next = current.next;
                    current = current.next;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
}

public class List2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.insert(data);
        }
        System.out.println("Original List:");
        list.display();
        list.delete();
        System.out.println("\nList after deleting nodes with values greater than 25:");
        list.display();
    }
}
