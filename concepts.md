### [Bit Manipulation](https://codeburst.io/your-guide-to-bit-manipulation-48e7692f314a)

### Dynamic Programming
##### Top-Down Dynamic Programming (or Memoization)
```
int fibonacci(int n) {
    return fibonaci(n, new int[n+1]);
}
int fibonacci(int n, int[] mem) {
    if(n == 0 || n == 1) {
        return n;
    } else if(mem[n] == 0) {
        mem[n] = fibonacci(n-1, mem) + fibonacci(n-2, mem);
    }
    return mem[n];
}
```

##### Bottom-Up Dynamic Programming
```
int fibonacci(int n) {
    if(n == 0 || n == 1) {
        return n;
    }
    mem[0] = 0; // Can be changed to scalar a
    mem[1] = 1; // Can be changed to scalar b
    for (int i = 2; i < n; i++) {
        mem[i] = mem[i-1] + mem[i-2]; // Can be changed to scalar c while assigning to mem[i-1] to b and mem[i-2] to a
    }
    return mem[n-1] + mem[n-2]; // this would then return a + b
}
```

### [System Design and Scalability](https://en.wikipedia.org/wiki/Scalability)
- **Scaling**
    - **Vertical** *&larr; Increasing the resources of a specific node*
    - **Horizontal** *&larr; Increasing the number of nodes*
- **Load Balancer** *&larr; Requires network of cloned servers that all have essentially the same code and access to the same data*
- **Database Denormalization and NoSQL** *&larr; To avoid joins that can get very slow as the system grows bigger*
- **Sharding** *&larr; Database partitioning*
    - **Vertical** *&larr; By feature*
        - One of these feature tables might still get very large
    - **Key-Based (or Hash-Based)** *&larr; By some part of the data, e.g. ID mod(key, n) with n servers*
        - Adding additional servers means reallocating all the data - a very expensive task
    - **Directory-Based** *&larr; Maintain a lookup table*
        - Single point of failure
        - Constantly accessing this table impacts performance
- **Caching** *&larr; In-memory key-value pairing*
- **Asynchronous Processing & Queues** *&larr; Slow operations should ideally be done asynchronously*
- **Networking Metrics**
    - **Bandwidth** *&larr; Maximum amount of data that can be transferred in a unit of time*
    - **Throughput** *&larr; Actual amount of data that is transferred*
    - **Latency** *&larr; How long it takes data to go from one end to the other*
- **MapReduce** *&larr; Requires user-provided Map step and a Reduce step. The rest is handled by the system*
    1. The system splits up the data across different machines
    1. Each machine starts running the **Map** program
    1. The **Map** program takes some data and emits a key-value pair
    1. The Shuffle process reorganizes the data so that all key-value pairs associated with a given key go to the same machine
    1. The **Reduce** program takes a key and a set of associated values and "reduces" them in some way, emitting a new key and value
- **Further Considerations**
    - **Failures** *&larr; Essentially any part of a system can fail*
    - **Availability** *&larr; Percentage of time the system is operational*
    - **Reliability** *&larr; Probability that the system is operational for a certain unit of time*
    - **Read-heavy** *&larr; Might require caching*
    - **Write-heavy** *&larr; Consider queuing up the writes*
    - **Security** *&larr; Can be devastating for a system*
