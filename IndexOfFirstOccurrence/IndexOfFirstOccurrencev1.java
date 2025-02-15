package IndexOfFirstOccurrence;

public class IndexOfFirstOccurrencev1 {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad","sad"));
        System.out.println(strStr("leetcode","leeto"));
        System.out.println(strStr("hello","ll"));
    }

    public static int strStr(String haystack, String needle){
        if (haystack.length() < 1 || needle.length() < 1) {return -1;}
        if(!haystack.contains(needle)){return -1;}
        if(haystack.equals(needle)){return 0;}
        int cont = 0;
        while (haystack.length() >= needle.length()) {
            if (haystack.startsWith(needle)) {return cont;}
            else{
                cont++;
                haystack = haystack.substring(1);
            }
        }
        return (cont > 0) ? cont:-1;
    }
}
