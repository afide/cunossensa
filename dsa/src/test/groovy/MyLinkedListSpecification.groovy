import spock.lang.Specification

/**
 * System under specification: {@link MyLinkedList}.
 */
class MyLinkedListSpecification extends Specification {
    def 'test string linked list'() {
        given: 'an instance of a linked list'
        MyLinkedList<String> list = new MyLinkedList<>('bar')

        expect: 'the list size to be 0'
        list.size == 1
        list.getAtIndex(0) == 'bar'

        when: 'we add an item at the tail'
        list.addAtTail('qux')

        then: 'the size and values change accordingly'
        list.size == 2
        list.getAtIndex(0) == 'bar'
        list.getAtIndex(1) == 'qux'

        when: 'we add an item at the head'
        list.addAtHead('foo')

        then: 'the size and values change accordingly'
        list.size == 3
        list.getAtIndex(0) == 'foo'
        list.getAtIndex(1) == 'bar'
        list.getAtIndex(2) == 'qux'

        when: 'we add an item at an index'
        list.addAtIndex(2,'baz')

        then: 'the size and values change accordingly'
        list.size == 4
        list.getAtIndex(0) == 'foo'
        list.getAtIndex(1) == 'bar'
        list.getAtIndex(2) == 'baz'
        list.getAtIndex(3) == 'qux'
    }
}