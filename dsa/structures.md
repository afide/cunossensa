### [Hashmap](https://en.wikipedia.org/wiki/Hash_table)
`key`\
&rarr; `hash = hashfunc(key)`\
&rarr; `i = hash % buckets.length`\
&rarr; `entries[0..3] = buckets[i]`\
&rarr; `value = entries[1].value`

Dealing with **Hash collisions** *&larr; Practically unavoidable*
- **Chaining** with linked list *&larr; Worst-case runtime is O(n)*
- **Chaining** with balanced binary search tree *&larr; Worst-case runtime is O(log(n)); only when expecting an extremely nonuniform distribution*
- Open Addressing with Linear **Probing** *&larr; Move on to the next index in the array until we find an open spot*
- Quadratic **Probing** and Double Hashing *&larr; Non-linear distance between probes; use a second hash function to determine the probe distance*

### [ArrayList](https://en.wikipedia.org/wiki/Dynamic_array)
- Resizes itself as needed *&larr; Still provids O(1) access*
- Typically, when the array is full, the array doubles in size *&larr; Each doubling takes 0(n) time, but happens rarely*
- Amortized insertion time *&larr; still O(1)*

**StringBuilder** *&larr; Creates a resizable array of all the strings*
```
class MyStringBuilder {
    static String joinWords(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String word : words) {
            sentence.append(word);
            sentence.append(' ');
        }
        return sentence.toString().trim();
    }
}
```
### [Linked List](https://en.wikipedia.org/wiki/Linked_list)
```
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
```
### [Stack](https://en.wikipedia.org/wiki/Stack_(abstract_data_type))
```
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
```
### [Queue](https://en.wikipedia.org/wiki/Queue_(abstract_data_type))
```
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
```
### [Graph](https://en.wikipedia.org/wiki/Graph_(abstract_data_type)) *&larr;  A collection of nodes with edges between (some of) them*
- **Directed graph** *&larr; like a one-way street*
- **Undirected graph** *&larr; like a two-way street*
- **Connected graph** *&larr; There is a path (edge) between every pair of vertices (nodes)*
- **Acyclic graph**

#### [Adjacency List](https://en.wikipedia.org/wiki/Adjacency_list) *&larr; Every node stores a list of adjacent nodes. In an undirected graph, an edge like (a, b) would be stored twice: once in a's adjacent nodes and once in b's adjacent nodes.*
```
class MyGraph {
    private static class Node {
        private String name;
        private Node[] children;
    }
    private Node[] nodes;
}
```
#### [Adjacency Matrices](https://en.wikipedia.org/wiki/Adjacency_matrix) *&larr; An `NxN` boolean matrix (where `N` is the number of nodes), where a true value at `matrix[i][j]` indicates an edge from node `i` to node `j`.*

### [Trees, Tries, Heaps](https://en.wikipedia.org/wiki/Tree_(data_structure)) *&larr; A tree is a connected acyclic graph*
- **Binary tree** *&larr; Each node has **up to two children***
    - **Complete binary tree** - Binary heap (min-heap/max-heap) *&larr; Every level of the tree is fully filled, except perhaps the last level; to the extent that the last level is filled, it is filled **left to right***
    - **Full binary tree** *&larr; Every node has either **zero or two children***
    - **Perfect binary Tree** - Complete & full *&larr; 2k - 1 nodes, with k being the number of levels*
    - **Binary Search Tree [(BST)](https://en.wikipedia.org/wiki/Binary_search_tree)** *&larr; all left descendents <= n < all right descendents*
- **N-ary tree**
    - **Ternary tree** *&larr; Each node has **up to three children***
    - **10-ary tree** *&larr; For looking up telefon numbers*
    - **Trie (aka digital/[radix](https://en.wikipedia.org/wiki/Radix_tree)/prefix tree)** *&larr; Characters are stored at each node; each path down the tree may represent a word.*
- **Balanced tree** - [AVL tree](https://en.wikipedia.org/wiki/AVL_tree), [Red-black tree](https://en.wikipedia.org/wiki/Red–black_tree) *&larr; Rather means "not terribly imbalanced"*
- **Leaf node** *&larr; No children*


#### [Depth-First Search (DFS)](https://en.wikipedia.org/wiki/Tree_traversal) *&larr; Runtime: O(b^d^); Memory: O(bd)*
```
class MyTree {
    private static class Node {
        boolean visited;
        String name;
        Node[] children;
        Node(String name) {
            this.name = name;
        }
        void addChildren(Node[] children) {
            this.children = children;
        }
        Node left() {
            if (children != null && children.length > 0) {
                return children[0];
            }
            return null;
        }
        Node right() {
            if (children != null && children.length > 1) {
                return children[1];
            }
            return null;
        }
    }
    private Node root;
    MyTree(Node root) {
        this.root = root;
    }
    private void visit(Node node) {
        System.out.print(" " + node.name);
    }
    void depthFirstSearchLNR() {
        System.out.print("\nLNR ::");
        depthFirstSearchLNR(root);
    }
    private void depthFirstSearchLNR(Node node) {
        if (node != null) {
            depthFirstSearchLNR(node.left());
            visit(node);
            depthFirstSearchLNR(node.right());
        }
    }
    void depthFirstSearchNLR() {
        System.out.print("\nNLR ::");
        depthFirstSearchNLR(root);
    }
    private void depthFirstSearchNLR(Node node) {
        if (node != null) {
            visit(node);  // The root node is always the first visited
            depthFirstSearchNLR(node.left());
            depthFirstSearchNLR(node.right());
        }
    }
    void depthFirstSearchLRN() {
        System.out.print("\nLRN ::");
        depthFirstSearchLRN(root);
    }
    private void depthFirstSearchLRN(Node node) {
        if (node != null) {
            depthFirstSearchLRN(node.left());
            depthFirstSearchLRN(node.right());
            visit(node); // The root node is always the last visited
        }
    }
}
```

#### [Breadth-First Search (BFS)](https://en.wikipedia.org/wiki/Tree_traversal) *&larr; Runtime: O(b^d^); Memory: O(b^d^)*
```
class MyTree {
    private static class Node {
        boolean visited;
        String name;
        Node[] children;
        Node(String name) {
            this.name = name;
        }
        void addChildren(Node[] children) {
            this.children = children;
        }
        Node left() {
            if (children != null && children.length > 0) {
                return children[0];
            }
            return null;
        }
        Node right() {
            if (children != null && children.length > 1) {
                return children[1];
            }
            return null;
        }
    }
    private Node root;
    MyTree(Node root) {
        this.root = root;
    }
    private void visit(Node node) {
        System.out.print(" " + node.name);
    }
    void breadthFirstSearch() {
        System.out.print("\nBFS ::");
        breadthFirstSearch(root);
    }
    private void breadthFirstSearch(Node node) {
        if(node == null) {
            return;
        }
        node.visited = true;
        MyQueue<Node> queue = new MyQueue<>();
        queue.add(node); // Add to the end of queue
        while(!queue.isEmpty()) {
            Node n = queue.remove(); // Remove from the front of the queue
            visit(n);
            Node[] children = n.children;
            if (children == null) {
                continue;
            }
            for(Node a : children) {
                if(a != null && !a.visited) {
                    a.visited = true;
                    queue.add(a); // Add to the end of queue
                }
            }
        }
    }
}
```

#### Bidirectional Search *&larr; Essentially two simultaneous BFSs, one from each node; when their searches collide, we have found a path*

#### [Binary Heap (Min-Heap and Max-Heap)](https://en.wikipedia.org/wiki/Heap_(data_structure))
- **Insert**
    - at the bottom rightmost spot *&larr; to maintain the **complete** tree property.*
    - than swap with parent until reaching root
- **Extract Min/Max Element**
    - it's always at the top &rarr; remove top element
    - than swap with bottom rightmost spot *&larr; to maintain the **complete** tree property.*
    - than swap with child element of lesser/larger value
<style>em { color: gray }</style>