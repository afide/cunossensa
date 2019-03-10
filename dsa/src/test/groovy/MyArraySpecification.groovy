import spock.lang.Shared
import spock.lang.Specification

/**
 * System under specification: {@link MyArray}.
 */
class MyArraySpecification extends Specification {

    @Shared Integer[] unsorted = [13, 1, 19, 3, 8, 4, 37, 6, 7, 10, 14, 45, 21, 18, 24, 40, 71]
    @Shared Integer[] sorted = [1, 3, 4, 6, 7, 8, 10, 13, 14, 18, 19, 21, 24, 37, 40, 45, 71]

    def 'test binary search'() {
        given: 'a sorted list'

        when: 'we do a binary search for a number'
        MyArray.binarySearch(sorted, 7)

        then: 'the time complexity is O(log(n)) and space complexity is O(1)'
        print '8 > 3 > 5 > 4'
    }

    def 'test quick sort'() {
        given: 'an unsorted list'

        when: 'we quick sort the list'
        Integer[] result = MyArray.quickSort(unsorted)

        then: 'the time complexity is O(n log(n)) and space complexity is O(log(n))'
        result == sorted
    }

    def 'test merge sort'() {
        given: 'an unsorted list'

        when: 'we merge sort the list'
        Comparable[] result = MyArray.mergeSort(unsorted)

        then: 'the time complexity is O(n log(n)) and space complexity is O(n)'
        result == sorted
    }
}