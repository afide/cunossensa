class MyTree {
    static class Node {
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