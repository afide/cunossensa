### [Source code translation vs type checking](https://hackernoon.com/i-finally-understand-static-vs-dynamic-typing-and-you-will-too-ad0c2bd0acc7)
Type checking has nothing to do with the language being compiled or interpreted!

When **source code is translated**
- **Compiled** - Code translated before run-time
- **Interpreted** - Code translated on the fly, during execution

When **types are checked**
- **Static** - Types checked before run-time
- **Dynamic** - Types checked on the fly, during execution

### [Strong and weak typing](https://en.wikipedia.org/wiki/Strong_and_weak_typing)
- **Strongly typed** - little implicit type **conversion**
- **Weakly typed** - implicit conversion aka **coercion**

### [Type inference](https://en.wikipedia.org/wiki/Type_inference)
- Automatic detection of the data type of an expression in a programming language
- It is a feature present in some **strongly statically typed** languages
- It is often characteristic of **functional programming** languages in general

### [Type Systems](https://medium.com/@thejameskyle/type-systems-structural-vs-nominal-typing-explained-56511dd969f4)
- **Nominal typing** - Checking against the name *&larr; C++, Java*
- **Structural typing** - Checking against the structure *&larr; OCaml, Haskell*

### [Subclasses vs self-types](https://docs.scala-lang.org/tour/self-types.html)
- **Subclasses** - `trait B extends A` *&larr; B is an A*
- **Self-types** - `trait B { this: A => }` *&larr; B requires an A*

### [Compound types](https://medium.com/@ondrejmirtes/union-types-vs-intersection-types-fd44a8eacbb)
- **Union Types** - `Foo|Bar` *&larr; The type of a variable is either Foo or Bar*
- **Intersection Types** - `Foo&Bar` *&larr; The type of a variable is Foo and Bar at the same time*

### [Lists vs tuples](https://stackoverflow.com/questions/24854139/lists-are-for-homogeneous-data-and-tuples-are-for-heterogeneous-data-why)
- **Lists** - mutable *&larr; **homogeneous** data by convention (semantics of the data, not just the types)*
- **Tuples** - immutable *&larr; **heterogeneous** data by convention (semantics of the data, not just the types)*

### [Power of 2](https://en.wikipedia.org/wiki/Power_of_two)
2^n^ bytes = 2^n+3^ bits
```
2^ 7 =  128 =  0x00000080
2^ 8 =  256 =  0x00000100
2^10 = 1024 =  0x00000400
2^16 = 64KB =  0x00010000
2^20 =  1MB =  0x00100000
2^30 =  1GB =  0x40000000
```
<style>em { color: gray }</style>
