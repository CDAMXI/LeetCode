package LetterCombination;

import java.util.*;

public class LetterCombinationv1 {
    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {return result;}
        if (digits.length() == 1) {return Arrays.asList(getLetters(digits.charAt(0)));}
        findCombinations(digits, 0, new StringBuilder(), result);
        return result;
    }

    public static void findCombinations(String digits, int index, StringBuilder combination, List<String> result){
        if (index == digits.length()){
            result.add(combination.toString());
            return;
        }
        String letters = getLetters(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++){
            combination.append(letters.charAt(i));
            findCombinations(digits, index + 1, combination, result);
            combination.deleteCharAt(combination.length() - 1);
        }
    }
    public static String getLetters(char letter){
        switch (letter) {
            case '2': return "abc";
            case '3': return "def";
            case '4': return "ghi";
            case '5': return "jkl";
            case '6': return "mno";
            case '7': return "pqrs";
            case '8': return "tuv";
            case '9': return "wxyz";
            default: return "";
        }
    }
}
