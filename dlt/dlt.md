### [Bitcoin](https://medium.com/@ConsenSys/thoughts-on-utxo-by-vitalik-buterin-2bb782c67e53) *&larr; stateless UTXOs*
- **Inherent transaction rate limit** *&larr; All participants agree on the longest chain and discard forks and side branches*
- **Bitcon transaction model** - 1..n UTXOs &rarr; tx &rarr; 1..m UTXOs
- **UTXO** - Unspent transaction output
- A user’s balance is thus not stored as a number *&larr; rather, it can be computed as the total sum of the denominations of UTXOs that they own.*
- Allows transactions to be processed in **parallel** *&larr; requires wallet to split up change outputs so that the wallet always has multiple change outputs*
- UTXOs are unnecessarily **complicated**
- UTXOs are **stateless**, and so are not well-suited to applications more complex than asset transfers *&larr; e.g. multiple phases smart contracts*

### [Ethereum ](C:\home\sag\papers\coins\ethereum\afWDt.jpg) *&larr; accounts plus stateful scripting language*
- **Contract** - Account controlled by a piece of code
- **Block** &larr; `state root`, `transaction root`, `transaction receipt root`
    - **World state trie** (merkle-particia) &larr; `account` &larr; `storage root` &larr; **Storage trie** (merkle-patricia of RLP values)
    - **Transaction trie** (merkle-particia) &larr; `transaction`
    - **Transaction receipt trie** (index-keyed) &larr; `transaction receipt` &larr; `log entry`

### [Ethereum 2.0 Sharding](https://github.com/ethereum/EIPs/issues/53)
A block now contains a list of transaction groups, which MUST have disjoint activity ranges

### [RLP - Recursive Length Prefix](https://github.com/ethereum/wiki/wiki/RLP)
- Like a binary encoding of JSON, if JSON were restricted only to **strings** and **arrays**
- Encode arbitrarily nested arrays of binary data
- The only purpose is to **encode structure** *&larr; encoding specific data types is left up to higher-order protocols*
- The integer value **zero** is equivalent to the empty byte array
- **Positive integers** must be represented in big endian binary form with no leading zeroes
- A **space efficient** object serialization scheme
    - `[0x00, 0x7f]` *&larr; 7-bit encoding for 128 single characters :: US-ASCII*
    - `[0x80, 0xb7]` *&larr; Strings 0-55 bytes long*
    - `[0xb8, 0xbf]` *&larr; Strings more than 55 bytes long*
    - `[0xc0, 0xf7]` *&larr; Lists 0-55 bytes long*
    - `[0xf8, 0xff]` *&larr; Lists more than 55 bytes long*

### [Merkle Tree](https://en.wikipedia.org/wiki/Merkle_tree)
- **Binary tree** *&larr; Most hash tree implementations are binary*
    - **Root hash** *&larr; In p2p networks it must be acquired from a trusted source*
    - **Non-leaf node** - Labelled with the cryptographic hash of the labels of its child nodes
    - **Leaf node** - Labelled with the hash of a data block
- Integrity of each **branch** can be checked immediately *&larr;  Even though the whole tree is not available yet*
- **Usage** *&larr; Verify any kind of data stored, handled and transferred in and between computers.*
    - **File systems** - [IPFS](https://en.wikipedia.org/wiki/InterPlanetary_File_System), [Btrfs](https://en.wikipedia.org/wiki/Btrfs)
    - **Revision control systems** - [Git](https://en.wikipedia.org/wiki/Git)
    - **NoSQL datbases**

### [Patricia Tree](https://en.wikipedia.org/wiki/Radix_tree) *&larr; Practical Algorithm To Retrieve Information Coded In Alphanumeric*
A special variant of the radix 2 (binary) trie, in which rather than explicitly store every bit of every key, the nodes store only the position of the first bit which differentiates two sub-trees.

### [Modified Merkle Patricia Trie](https://github.com/ethereum/wiki/wiki/Patricia-Tree)
- **Fully deterministic** - A Patricia trie with the same (key,value) bindings is guaranteed to be exactly the same down to the last byte and therefore have the same root hash
- Provide the holy grail of **O(log(n))** efficiency for **inserts**, **lookups** and **deletes**
- And are much easier to understand and code than more complex comparison-based alternatives like red-black tries

### [Directed Acyclic Graph (DAG)](https://en.wikipedia.org/wiki/Directed_acyclic_graph)
- **Root node** *&larr; Some great ancestral node with no parents*
- **Nodes** *&larr; A place to store the data.*
- **Leaves** *&larr; Nodes with no children*
- **Directed edges** *&larr; Arrows that point in one direction*


### [Tangle](https://blog.iota.org/the-tangle-an-illustrated-introduction-4d5eae6fe8d4) of [IOTA](https://www.iota.org)
- **Scalability** - Uses a [DAG](https://en.wikipedia.org/wiki/Directed_acyclic_graph) instead of a [blockchain](https://en.wikipedia.org/wiki/Blockchain) to store its ledger
- **Faster throughput**
    - Allows different branches of the DAG to eventually merge
    - Transactions are directly linked rather than grouped and serialized on a single lane
- **Nodes** represent transactions, and **edges** represent approvals
- **Transaction 0** is the genesis transaction and in the case of IOTA, contained all the MIOTA that will ever be created
- Each **incoming transaction** needs to directly approve **two previous transactions** in order to become validated
- **Tip (unapproved transaction) selection algorithm** - Random walks starting at the genesis transaction linearly across the DAG towards the most recent tips
- **Random walk across the DAG** - [MCMC](https://en.wikipedia.org/wiki/Markov_chain_Monte_Carlo)
- **Acyclicity** *&larr; Allows that transactions can be executed locally or even off-line and processed, confirmed or finalized at later points*
- **Latency** *&larr; Not constrained by block-size, but bandwidth between communicating peers*
- **Feeless** *&larr; Pre-mined: Fixed supply, no mining involved*
- **Database pruning** *&larr; Allows for keeping database slim and different nodes can save only the history they are interested in*
