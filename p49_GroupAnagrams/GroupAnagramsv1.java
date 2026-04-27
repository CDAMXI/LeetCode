package p49_GroupAnagrams;
import java.util.*;

public class GroupAnagramsv1{
    public static void main(String[] args){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String aux = new String(chars);
            if(!map.containsKey(aux)){
                map.put(aux, new ArrayList<>());
            }
            map.get(aux).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
