class Link {
    class Node {
        int data;
        int key;
        Node next;

        Node(int key, int data) {
            this.key = key;
            this.data = data;
            next = null;
        }
    }

    Node head = null;

    void printList() {
        Node ptr = head;
        System.out.println();

        while (ptr != null) {
            System.out.print("(" + ptr.key + "," + ptr.data + ") ");
            ptr = ptr.next;
        }
    }

    void insertFirst(int key, int data) {
        Node link = new Node(key, data);
        link.next = head;
        head = link;
    }

    Node deleteFirst() {
        Node tempLink = head;
        head = head.next;
        return tempLink;
    }

    boolean isEmpty() {
        return head == null;
    }

    int length() {
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    Node searching(int key) {
        Node current = head;

        if (head == null) {
            return null;
        }

        while (current.key != key) {
            if (current.next == null) {
                return null;
            } else {
                current = current.next;
            }
        }

        return current;
    }

    Node delete(int key) {
        Node current = head;
        Node previous = null;

        if (head == null) {
            return null;
        }

        while (current.key != key) {
            if (current.next == null) {
                return null;
            } else {
                previous = current;
                current = current.next;
            }
        }

        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }

        return current;
    }

    void sort() {
        int i, j, k, tempKey, tempData;
        Node current;
        Node next;

        int size = length();
        k = size;

        for (i = 0; i < size - 1; i++, k--) {
            current = head;
            next = head.next;

            for (j = 1; j < k; j++) {
                if (current.data > next.data) {
                    tempData = current.data;
                    current.data = next.data;
                    next.data = tempData;

                    tempKey = current.key;
                    current.key = next.key;
                    next.key = tempKey;
                }

                current = current.next;
                next = next.next;
            }
        }
    }

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public static void main(String[] args) {
        Link list = new Link();

        list.insertFirst(1, 10);
        list.insertFirst(2, 11);
        list.insertFirst(3, 12);
        list.insertFirst(4, 13);
        list.insertFirst(5, 14);
        list.insertFirst(6, 15);

        System.out.print("Original List: ");
        list.printList();

        while (!list.isEmpty()) {
            Node temp = list.deleteFirst();
            System.out.print("\nDeleted value:");
            System.out.print("(" + temp.key + "," + temp.data + ") ");
        }

        System.out.print("\nList after deleting all items: ");
        list.printList();

        list.insertFirst(1, 10);
        list.insertFirst(2, 11);
        list.insertFirst(3, 12);
        list.insertFirst(4, 13);
        list.insertFirst(5, 14);
        list.insertFirst(6, 15);

        System.out.print("\nRestored List: ");
        list.printList();
        System.out.println();

        Node foundLink = list.searching(2);

        if (foundLink != null) {
            System.out.print("Element found: ");
            System.out.print(+foundLink.key + foundLink.data);
            System.out.println();
        } else {
            System.out.print("Element not found.");
        }

        list.delete(2);
        System.out.println("List after deleting an item: ");
        list.printList();

        foundLink = list.searching(2);

        if (foundLink != null) {
            System.out.print("Element found: ");
            System.out.print(+foundLink.key + foundLink.data);
            System.out.println();
        } else {
            System.out.println("Element not found.");
        }
        System.out.println();
        list.sort();

        System.out.print("List after sorting the data: ");
        list.printList();

        // reverse(head);
        System.out.print("\nList after reversing the data: ");
        list.printList();

    }
}
