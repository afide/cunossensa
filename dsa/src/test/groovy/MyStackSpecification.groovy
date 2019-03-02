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

    @Unroll def 'test string stack add and remove'() {
        expect: 'it to be empty'
        stack.isEmpty()

        when: 'an item is pushed on the stack'
        stack.push('foo')

        then: 'the peek contains the latest node'
        !stack.isEmpty()
        stack.peek() == 'foo'

        when: 'an item is popped from the stack'
        String data = stack.pop()

        then: 'the data received is as expected'
        data == 'foo'

        and: 'the stack is empty again'
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

        then: 'the item data is as expected'
        item == data

        where: 'the items are ordered in LIFO order'
        data << ['qux', 'baz', 'bar', 'foo']
    }
}