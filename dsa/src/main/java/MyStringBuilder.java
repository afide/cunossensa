class MyStringBuilder {
    static String joinWords(String[] words) {
        StringBuilder sentence = new StringBuilder();
        for (String word : words) {
            sentence.append(word);
            sentence.append(' ');
        }
        return sentence.toString().trim();
    }
}