class MyLinkedList<T> {
    private class Node {
        private Node next;
        T data;
        Node(T data) {
            this.data = data;
            size++; // Accessing parent class here; therefore this class cannot be static
        }
    }
    private Node head;
    int size;
    MyLinkedList(T data) {
        head = new Node(data);
    }
    void addAtHead(T data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }
    void addAtTail(T data) {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(data);
    }
    void addAtIndex(int index, T data) {
        Node tmp = head;
        for(int i=0; i < index-1 && tmp.next != null; i++) {
            tmp = tmp.next;
        }
        Node node = new Node(data);
        node.next = tmp.next;
        tmp.next = node;
    }
    T getAtIndex(int index) {
        Node node = head;
        for(int i=0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }
}