class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
}

public class Main {
    static boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    static boolean hasDigitThree(int num) {
        return String.valueOf(num).contains("3");
    }

    static int sumLinkedList(SinglyLinkedList list) {
        Node current = list.head;
        int total = 0;
        while (current != null) {
            total += current.data;
            current = current.next;
        }
        return total;
    }

    static int findSumOfPrimesWithThree(int n) {
        SinglyLinkedList primeList = new SinglyLinkedList();
        SinglyLinkedList primeWithThreeList = new SinglyLinkedList();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeList.insert(i);
                if (hasDigitThree(i)) {
                    primeWithThreeList.insert(i);
                }
            }
        }

        return sumLinkedList(primeWithThreeList);
    }

    public static void main(String[] args) {
        int n = 100;
        int result = findSumOfPrimesWithThree(n);
        System.out.println("Sum of prime numbers with the digit '3' between 0 and " + n + " is: " + result);
    }
}
