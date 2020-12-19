package arraysAndStrings;

import java.util.*;

public class MostcommonWord {

    //najpopularniejsze ale takie co nie jest bannned

    public static void main(String[] args) {

        String t = "fsd%^$454fsd45t,./.dfgeGDFGDf";
        String s = mostCommonWord(t, new String[]{"fsd"});

        System.out.println(s);

    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        // 1). replace the punctuations with spaces,
        // and put all letters in lower case
        String normalizedStr = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();

        // 2). split the string into words
        String[] words = normalizedStr.split("\\s+");

        Set<String> bannedWords = new HashSet<>();
        //  Collections.addAll(bannedWords, banned);
        for (String word : banned)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap<>();
        // 3). count the appearance of each word, excluding the banned words
        //  Arrays.stream(words).filter(word -> !bannedWords.contains(word)).forEach(word -> wordCount.put(word, wordCount.getOrDefault(word, 0) + 1));
        for (String word : words) {
            if (!bannedWords.contains(word))

                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 4). return the word with the highest frequency
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
