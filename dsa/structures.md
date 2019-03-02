### [Hash Map](https://en.wikipedia.org/wiki/Hash_table)
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

### [Array List](https://en.wikipedia.org/wiki/Dynamic_array)
- Resizes itself as needed *&larr; Still provids O(1) access*
- Typically, when the array is full, the array doubles in size *&larr; Each doubling takes 0(n) time, but happens rarely*
- Amortized insertion time *&larr; still O(1)*

**StringBuilder** *&larr; Creates a resizable array of all the strings*
###### Main
>[`MyStringBuilder`](./src/main/java/MyStringBuilder.java)

### [Linked List](https://en.wikipedia.org/wiki/Linked_list)
###### Main
>[`MyLinkedList<T>`](./src/main/java/MyLinkedList.java)
###### Test
>[`MyLinkedListSpecification`](./src/test/groovy/MyLinkedListSpecification.groovy)

### [Stack](https://en.wikipedia.org/wiki/Stack_\(abstract_data_type\))
###### Main
>[`MyStack<T>`](./src/main/java/MyStack.java)
###### Test
>[`MyStackSpecification`](./src/test/groovy/MyStackSpecification.groovy)

### [Queue](https://en.wikipedia.org/wiki/Queue_\(abstract_data_type\))
###### Main
>[`MyQueue<T>`](./src/main/java/MyQueue.java)
###### Test
>[`MyQueueSpecification`](./src/test/groovy/MyQueueSpecification.groovy)

### [Graph](https://en.wikipedia.org/wiki/Graph_\(abstract_data_type\))
A collection of nodes with edges between (some of) them.
- **Directed graph** *&larr; Like a one-way street*
- **Undirected graph** *&larr; Like a two-way street*
- **Connected graph** *&larr; There is a path (edge) between every pair of vertices (nodes)*
- **Acyclic graph**
###### Main
>[`MyGraph`](./src/main/java/MyGraph.java)

#### [Adjacency List](https://en.wikipedia.org/wiki/Adjacency_list)
Every node stores a list of adjacent nodes. In an undirected graph, an edge like (a, b) would be stored twice: once in a's adjacent nodes and once in b's adjacent nodes.

#### [Adjacency Matrices](https://en.wikipedia.org/wiki/Adjacency_matrix)
An `nxn` boolean matrix (where `n` is the number of nodes), where a true value at `matrix[i][j]` indicates an edge from node `i` to node `j`.

### [Trees, Tries, Heaps](https://en.wikipedia.org/wiki/Tree_\(data_structure\))
A tree is a connected acyclic graph.
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

#### [Binary Heap (Min-Heap and Max-Heap)](https://en.wikipedia.org/wiki/Heap_(data_structure))
- **Insert**
    - at the bottom rightmost spot *&larr; to maintain the **complete** tree property.*
    - than swap with parent until reaching root
- **Extract Min/Max Element**
    - it's always at the top &rarr; remove top element
    - than swap with bottom rightmost spot *&larr; to maintain the **complete** tree property.*
    - than swap with child element of lesser/larger value

### More Information
- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
