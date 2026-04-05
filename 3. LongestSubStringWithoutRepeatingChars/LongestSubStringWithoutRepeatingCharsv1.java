public class LongestSubStringWithoutRepeatingCharsv1{
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));  // Expected Output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        String result = "";
        while(s.length() > 0) {
            if(result.length() == 0){
                result+=String.valueOf(s.charAt(0));
                continue;
            }
            else{
                result = result.substring(result.indexOf(s.charAt(0))+1);
                result+=String.valueOf(s.charAt(0));
            }
        }
        return result.length();
    }
}
