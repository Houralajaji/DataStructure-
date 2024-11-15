import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;

    public LinkedList() {
        head = current = null;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current != null && current.next == null;
    }

    public int size() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }

        Node<T> current = head;
        int count = 0;

        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean contains(T element) {
        Node<T> current = head;
        while (current != null) {
            if (element == null && current.data == null) {
                return true;
            }
            if (element != null && element.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    @Override
public String toString() {
    StringBuilder result = new StringBuilder("[");
    Node<T> current = head;
    while (current != null) {
        result.append(current.data);
        if (current.next != null) {
            result.append(", ");
        }
        current = current.next;
    }
    result.append("]");
    return result.toString();
}


}
