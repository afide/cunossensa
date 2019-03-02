import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * System under specification: {@link MyQueue}.
 */
class MyQueueSpecification extends Specification {
    @Shared MyQueue<String> queue
    @Shared String[] items = ['foo', 'bar', 'baz', 'qux']

    def setupSpec() {
        given: 'an instance of a stack'
        queue = new MyQueue<>()
    }

    @Unroll def 'test string queue add and remove'() {
        expect: 'it to be empty'
        queue.isEmpty()

        when: 'an item is added to the queue'
        queue.add('foo')

        then: 'the peek contains the latest node'
        !queue.isEmpty()
        queue.peek() == 'foo'

        when: 'an item is removed from the queue'
        String data = queue.remove()

        then: 'the latest node is the previous value'
        data == 'foo'

        and: 'the queue is empty again'
        queue.isEmpty()
    }

    @Unroll def 'test string queue add #data'(String data) {
        when: 'an item is added to the queue'
        queue.add(data)

        then: 'the peek item is unchanged'
        queue.peek() == 'foo'

        where: 'this is the data handled by the queue'
        data << items
    }

    @Unroll def 'test string queue remove #data'(String data) {
        when: 'an item is removed from the queue'
        String item = queue.remove()

        then: 'the item data is as expected'
        item == data

        where: 'the items are ordered in FIFO order'
        data << items
    }
}