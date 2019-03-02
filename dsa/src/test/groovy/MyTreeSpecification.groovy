import spock.lang.Shared
import spock.lang.Specification

/**
 * System under specification: {@link MyTree}.
 */
class MyTreeSpecification extends Specification {
    @Shared MyTree tree
    def setupSpec() {
        // Create nodes
        MyTree.Node a = new MyTree.Node('A')
        MyTree.Node b = new MyTree.Node('B')
        MyTree.Node c = new MyTree.Node('C')
        MyTree.Node d = new MyTree.Node('D')
        MyTree.Node e = new MyTree.Node('E')
        MyTree.Node f = new MyTree.Node('F')
        MyTree.Node g = new MyTree.Node('G')
        MyTree.Node h = new MyTree.Node('H')
        MyTree.Node i = new MyTree.Node('I')
        // Make it a tree
        f.addChildren([b, g] as MyTree.Node[])
        b.addChildren([a, d] as MyTree.Node[])
        d.addChildren([c, e] as MyTree.Node[])
        g.addChildren([null, i] as MyTree.Node[])
        i.addChildren([h, null] as MyTree.Node[])
        tree = new MyTree(f)
    }

    def 'test depth first search LNR' () {
        expect: 'the letters being printed in DFS LNR order'
        tree.depthFirstSearchLNR()
    }

    def 'test depth first search NLR' () {
        expect: 'the letters being printed in DFS NLR order'
        tree.depthFirstSearchNLR()
    }

    def 'test depth first search LRN' () {
        expect: 'the letters being printed in DFS LRN order'
        tree.depthFirstSearchLRN()
    }

    def 'test breadth first search' () {
        expect: 'the letters being printed in BFS order'
        tree.breadthFirstSearch()
    }
}