package WordLadder;

import java.util.*;

public class WordLadderv2 {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Verify if endWord is in the list
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // Use a set for fast access
        Set<String> wordSet = new HashSet<>(wordList);

        // Queue for BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        // Level of BFS
        int level = 1;

        // Do BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();

                // Make sure we have reached the endWord
                if (currentWord.equals(endWord)) {
                    return level;
                }

                // Generate all possible transformations
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String newWord = new String(wordArray);

                        // If the new word is in the set, we add it to the queue
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord); // Avoid reusing
                        }
                    }
                }
            }
            level++; // Increment the level
        }

        return 0; // No secuence found
    }
}
