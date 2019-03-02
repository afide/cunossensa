import spock.lang.Specification

/**
 * System under specification: {@link MyStringBuilder}.
 */
class MyStringBuilderSpecification extends Specification{
    def 'test simple string builder'() {
        given: 'an list of words'
        String[] words = ['foo', 'bar', 'baz', 'qux']

        expect: 'the words getting concatenated to a sentence'
        MyStringBuilder.joinWords(words) == 'foo bar baz qux'
    }
}