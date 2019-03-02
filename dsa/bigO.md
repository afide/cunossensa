### [Big O / Time complexity / Asymptotic runtime](http://bigocheatsheet.com)
O(1) < O(log(n)) < O(n) < O(n log(n)) < O(n^2) < O(2^n) < O(n!)
- For many - probably most - algorithms, the worst case and the expected case are the same.
- **Space complexity** is a parallel concept to **time complexity**
    - array of size **n** *&larr; require 0(n) space*
    - two-dimensional array of size **n x n** *&larr;  0(n^2) space*
- Expresses how the runtime **scales** *&larr; 0(n) is not always better than O(n^2)*
- Describes the **rate of increase** *&larr; It is very possible for O(n) code to run faster than 0(1) code for specific inputs*
- **Drop the constants in runtime**
    - O(2n) &rarr; O(n)
- **Drop the non-dominant terms**
    - O(n^2 + n) &rarr; O(n^2)
    - O(n + log(n)) &rarr; O(n)
    - O(5*2^n + 1000n^100) &rarr; O(2^n)
- O(b^2 + a) **cannot** be reduced (without some special knowledge of a and b)
- O(i+j) *&larr; do this, then, when you're all done, do that*
- O(i*j) *&larr; do this for each time you do that*
- Amortized Time with ArrayList
    - Vast majority of insertions - O(1) *&larr; amortized time*
    - Array full &rarr; create a new array of size 2n and copy n elements over - O(n)
    - Double the capacity when the size of the array is a power of 2 &rarr; 1,2,4,8,16,32,64,...,n &rarr; O(2n) *&larr; n insertions take O(2n) time*
- Number of elements in the problem space gets **halved** each time - O(log(n)) *&larr; Base of the log doesn't matter*
- **Recursive** function - often (but not always) O(branches^depth) *&larr; The base of an exponent does matter*
    - `int f(int n) { return f(n - 1) + f(n - 1); }` *&larr; O(2^n)*
- **Sorting a string** - O(s log(s)) with `s = string.length`
- **String comparing** - O(s)        with `s = string.length`
- **Sorting strings in an array, requires comparing** - O(s*a log(a)) with `a = array.length`

### [Java collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html)
#### List *&larr; sequence*
|                      |get     |add     |contains|next    |remove  |
|----------------------|--------|--------|--------|--------|--------|
|ArrayList             | O(1)   | O(1)   | O(n)   | O(1)   | O(n)   |
|LinkedList            | O(n)   | O(1)   | O(n)   | O(1)   | O(1)   |
|CopyOnWriteArrayList  | O(1)   | O(n)   | O(n)   | O(1)   | O(n)   |

#### Set *&larr; no duplicate elements (h is the capacity)*
|                     | add            | contains       | next            |
|---------------------|----------------|----------------|-----------------|
|HashSet              | O(1)           | O(1)           | O(h/n)          |
|LinkedHashSet        | O(1)           | O(1)           | O(1)            |
|CopyOnWriteArraySet  | O(n)           | O(n)           | O(1)            |
|EnumSet              | O(1)           | O(1)           | O(1)            |
|TreeSet              | O(log n)       | O(log n)       | O(log n)        |
|ConcurrentSkipListSet| O(log n)       | O(log n)       | O(1)            |

#### Map *&larr; key value pairs, no duplicate keys (h is the capacity)*
|                     | get            | containsKey    | next            |
|---------------------|----------------|----------------|-----------------|
|HashMap              | O(1)           | O(1)           | O(h/n)          |
|LinkedHashMap        | O(1)           | O(1)           | O(1)            |
|IdentityHashMap      | O(1)           | O(1)           | O(h/n)          |
|EnumMap              | O(1)           | O(1)           | O(1)            |
|TreeMap              | O(log n)       | O(log n)       | O(log n)        |
|ConcurrentHashMap    | O(1)           | O(1)           | O(h/n)          |
|ConcurrentSkipListMap| O(log n)       | O(log n)       | O(1)            |

#### Queue *&larr; typically FIFO* 
|                     | offer       | peek      | poll       | size       |
|---------------------|-------------|-----------|------------|------------|
|PriorityQueue        | O(log n)    | O(1)      | O(log n)   | O(1)       |
|ConcurrentLinkedQueue| O(1)        | O(1)      | O(1)       | O(n)       |
|ArrayBlockingQueue   | O(1)        | O(1)      | O(1)       | O(1)       |
|LinkedBlockingQueue  | O(1)        | O(1)      | O(1)       | O(1)       |
|PriorityBlockingQueue| O(log n)    | O(1)      | O(log n)   | O(1)       |
|DelayQueue           | O(log n)    | O(1)      | O(log n)   | O(1)       |
|LinkedList           | O(1)        | O(1)      | O(1)       | O(1)       |
|ArrayDeque           | O(1)        | O(1)      | O(1)       | O(1)       |
|LinkedBlockingDeque  | O(1)        | O(1)      | O(1)       | O(1)       |
