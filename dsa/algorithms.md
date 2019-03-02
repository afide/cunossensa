### [Bubble Sort](https://en.wikipedia.org/wiki/Bubble_sort)
Runtime: O(n2); Memory: O(1).

### [Selection Sort](https://en.wikipedia.org/wiki/Selection_sort)
Runtime: O(n2); Memory: O(1).

### [Radix Sort](https://en.wikipedia.org/wiki/Radix_sort)
Runtime: O(nk); Memory: O(n+k).

### [Binary Search](https://en.wikipedia.org/wiki/Binary_search_algorithm)
Runtime: O(log n); Memory: O(1).
###### Main
>[`MyArray#binarySearch(Integer[] arr, Integer x)`](./src/main/java/MyArray.java#L2-L24)
###### Test
>[`MyArraySpecification`](./src/test/groovy/MyArraySpecification.groovy)

### [QuickSort](https://en.wikipedia.org/wiki/Quicksort)
Runtime: O(n log(n)); Memory: O(log(n)). The partitioning element is not guaranteed to be the median &rarr; worst case runtime O(n^2)
###### Main
>[`MyArray#quickSort(Integer[] arr)`](./src/main/java/MyArray.java#L25-L60)
###### Test
>[`MyArraySpecification`](./src/test/groovy/MyArraySpecification.groovy)

### [Merge Sort](https://en.wikipedia.org/wiki/Merge_sort)
Runtime: O(n log(n)); Memory: O(n).
###### Main
>[`MyArray#mergeSort(Integer[] arr)`](./src/main/java/MyArray.java#L61-L96)
###### Test
>[`MyArraySpecification`](./src/test/groovy/MyArraySpecification.groovy)

#### [Depth-First Search (DFS)](https://en.wikipedia.org/wiki/Tree_traversal)
Runtime: O(b^d); Memory: O(bd).
###### Main
>[`MyTree#depthFirstSearchLNR()`](./src/main/java/MyTree.java#L32-L42)

>[`MyTree#depthFirstSearchNLR()`](./src/main/java/MyTree.java#L43-L53)

>[`MyTree#depthFirstSearchLRN()`](./src/main/java/MyTree.java#L54-L64)

###### Test
>[`MyTreeSpecification`](./src/test/groovy/MyTreeSpecification.groovy)

#### [Breadth-First Search (BFS)](https://en.wikipedia.org/wiki/Tree_traversal)
Runtime: O(b^d); Memory: O(b^d).
###### Main
>[`MyTree#breadthFirstSearch()`](./src/main/java/MyTree.java#L65-L90)
###### Test
>[`MyTreeSpecification`](./src/test/groovy/MyTreeSpecification.groovy)

#### Bidirectional Search
Essentially two simultaneous BFSs, one from each node; when their searches collide, we have found a path

### More Information
- [Algorithms, 4th Edition](https://algs4.cs.princeton.edu/home/)
