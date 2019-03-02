import java.util.EmptyStackException;

class MyStack<T> {
    private static class Node<T> {
        private Node<T> next;
        private T data;
        private Node(T data) {
            this.data = data;
        }
    }
    private Node<T> top;
    boolean isEmpty() {
        return this.top == null;
    }
    T peek() {
        if (top == null) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }
    T pop() {
        if (top == null) {
            throw new EmptyStackException();
        } else {
            T data = top.data;
            top = top.next;
            return data;
        }
    }
    void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = top;
        top = node;
    }
}