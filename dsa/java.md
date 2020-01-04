### [Java](https://en.wikipedia.org/wiki/Java_syntax)
- **OOP Concepts**
    - **Abstraction** *&larr; Hiding unwanted details while showing most essential information*
    - **Encapsulation** *&larr; Hiding data and methods within an object*
    - **Inheritance** *&larr; Sub-class shares some of the attributes from super-class*
    - **Polymorphism** *&larr; Poly means **many** and morphos means **forms***
        - **Overloading** *&larr; Methods have the same name but differ in the type or number of arguments*
        - **Overriding** *&larr; Occurs when a method shares the same name and signature as another method in its super class*
        - **Parametric Polymorphism** - just another term for *[Generics](http://www.angelikalanger.com/GenericsFAQ/JavaGenericsFAQ.html)*
- **[Optional and variable arguments in method types](https://stackify.com/optional-parameters-java/)** *&larr; No intrinsic support*
    - Method overloading / Static factory methods / Builder pattern
    - Mutability with accessors (JavaBeans pattern) *&larr; Creation of the instance and setting of its state are decoupled and do not occur atomically, it’s possible that the instance could be used before it’s in a valid state*
    - Allowing nulls *&larr; Typically a bad idea, widely considered an anti-pattern*
    - Varargs *&larr; Added since Java 5*
        - exactly one variable argument parameter
        - must be the last in the method signature
- **Nested class**
    - **Static** *&larr; Can **not** access instance of the container class*
    - **Non-static** *&larr; Can access instance of the container class*

### [Memory (Stack vs. Heap)](https://www.baeldung.com/java-stack-heap)
- **Stack Memory** *&larr; Primitive values that are specific to a method and references to objects that are in a heap*
- **Heap Memory** *&larr; Used for dynamic memory allocation for Java objects and JRE classes at the runtime*

### [Threads](https://en.wikipedia.org/wiki/Java_concurrency)
Threads within a given process share the same memory space:
- **Positive** *&larr; Enables threads to share data, which can be valuable*
- **Negative** *&larr; Potential issues when two threads modify a resource at the same time*
###### Main
>[`MyThread`](./src/main/java/MyThread.java)

### [Deadlocks](https://en.wikipedia.org/wiki/Deadlock)
In order for a deadlock to occur, you must have all four of the following conditions met:
1. **Mutual Exclusion** *&larr; Only one process can access a resource at a given time*
1. **Resource Holding** *&larr; Processes already holding a resource can request additional resources, without relinquishing their current resources*
1. **No Preemption** *&larr; One process cannot forcibly remove another process' resource*
1. **Circular Wait** *&larr; Circular chain where each process is waiting on another resource in the chain*
