import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * System under specification: {@link MyStack}.
 */
class MyStackSpecification extends Specification {
    @Shared MyStack<String> stack

    def setupSpec() {
        given: 'an instance of a stack'
        stack = new MyStack<>()
    }

    def 'test string stack add and remove'() {
        expect: 'the stack to be initially empty'
        stack.isEmpty()

        when: 'an item is pushed on the stack'
        stack.push('foo')

        then: 'the peek contains the latest node'
        !stack.isEmpty()
        stack.peek() == 'foo'

        when: 'an item is popped from the stack'
        String data = stack.pop()

        then: 'the data received is as expected and the peak is now the next node, in this case the stack is empty again'
        data == 'foo'
        stack.isEmpty()
    }

    @Unroll def 'test string stack add #data'(String data) {
        when: 'an item is pushed on the stack'
        stack.push(data)

        then: 'the peek item is changed'
        stack.peek() == data

        where: 'this is the data handled by the stack'
        data << ['foo', 'bar', 'baz', 'qux']
    }

    @Unroll def 'test string stack remove #data'(String data) {
        when: 'an item is popped from the stack'
        String item = stack.pop()

        then: 'the item data is as expected and the peak is now the next node'
        item == data

        where: 'the items are ordered in LIFO order'
        data << ['qux', 'baz', 'bar', 'foo']
    }
}