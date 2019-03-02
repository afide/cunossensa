import java.util.NoSuchElementException;

class MyQueue<T> {
    private static class Node<T> {
        private Node<T> next;
        private T data;
        Node(T data) {
            this.data = data;
        }
    }
    private Node<T> first;
    private Node<T> last;
    boolean isEmpty() {
        return first == null;
    }
    T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            return first.data;
        }
    }
    T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            T data = first.data;
            first = first.next;
            if (first == null) {
                last = null;
            }
            return data;
        }
    }
    void add(T data) {
        Node<T> node = new Node<>(data);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }
}