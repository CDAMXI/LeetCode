package WordLadder;

import java.util.*;

public class WordLadderv1 {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
    }

    public static int ladderLength(String beginWord, String endWord, List<String>wordList){
        if (!wordList.contains(beginWord) || !wordList.contains(endWord)){return 0;}
        int cont = 0;
        for (int i = 0; i < wordList.size(); i++){
            if (oneCharDiff(beginWord, endWord)){
                cont++;
            }
        }
        return cont;
    }

    public static boolean oneCharDiff(String s1, String s2){
        int cont = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                cont++;
            }
        }
        return cont == 1;
    }
}
