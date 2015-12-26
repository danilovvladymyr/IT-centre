package session2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TextHandler {
//    private Set<String> words;
    private Map<String, Integer> wordStatistic;

    public TextHandler() {
//        words = new HashSet<>();
        wordStatistic = new HashMap<>();
    }
    
    private void insert(String word) {
//        words.add(word);
        if ( wordStatistic.containsKey(word) ) {
            Integer frequancy = wordStatistic.get(word);
            frequancy++;
            wordStatistic.put(word, frequancy);
        }
        wordStatistic.put(word, 0);
    }

    public void setStringFromConsole() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String word = buffer.readLine().toLowerCase();
        for ( ; word != null; ) {
            insert(word);
        }
    }

    public void setStringFromFile(String fileName) throws IOException {
        BufferedReader buffer = new BufferedReader(new FileReader(fileName));

        try {
            String word = buffer.readLine().toLowerCase();
            for ( ; word != null; ) {
                insert(word);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

//    public void generateRandomText(int textLength) {
//
//    }

    public Set<String> getWordsByFrequancy(Integer frequancy) {
        Set<String> result = new HashSet<>();

        for ( Map.Entry<String, Integer> entry : wordStatistic.entrySet() ) {
            if ( entry.getValue() == frequancy ) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public Set<String> getWordsByFrequancyLessThen(Integer frequancy) {
        Set<String> result = new HashSet<>();

        for (Map.Entry<String, Integer> entry : wordStatistic.entrySet() ) {
            if ( entry.getValue() < frequancy ) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public Set<String> getWordsByFrequancyMoreThan(int frequancy) {
        Set<String> result = new HashSet<>();

        for (Map.Entry<String, Integer> entry : wordStatistic.entrySet() ) {
            if ( entry.getValue() > frequancy ) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

    public void printAsc() {
        StringBuffer buffer = new StringBuffer();

        final Map<String, Integer> ascSortedMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return wordStatistic.get(o1).compareTo(wordStatistic.get(o2));
            }
        });

        ascSortedMap.putAll(wordStatistic);
        for ( final Map.Entry<String, Integer> entry : ascSortedMap.entrySet() ) {
            buffer.append(entry.getKey() + " + " + entry.getValue());
        }
        System.out.println(buffer.toString());

    }

//    public void printDesc() {
//
//    }

    public static void main(String[] args) throws IOException {
        TextHandler textHandler = new TextHandler();
        textHandler.setStringFromFile("prof29/src/session2/text.txt");
//        textHandler.setStringFromConsole();
        textHandler.printAsc();
    }
}
