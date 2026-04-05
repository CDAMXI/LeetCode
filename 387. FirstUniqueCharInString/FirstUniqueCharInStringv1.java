public class FirstUniqueCharInStringv1{
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("abcbc")); // 0
        System.out.println(firstUniqueChar("aabbcc")); // -1
    }

    public static int firstUniqueChar(String s){
        if (s.length() == 0){return -1;}
        if (s.length() == 1){return 0;}
        int result = 0;
        while(result < s.length()){
            char first = s.charAt(0);
            s = s.substring(result);
            if(!s.contains(String.valueOf(first))){break;}
            result++;
        }
        return result;
    }
}
