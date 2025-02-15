public class plusOnev4 {
    public static void main(String[] args) {
        plusone(new int[] {1,2,3});
        plusone(new int[] {4,3,2,1});
        plusone(new int[] {9});
    }

    public static int[] plusone(int[] digits){
        int ans = 0;

        for (int i = 0; i < digits.length; i++) {
            ans = ans * 10 + digits[i];
        }

        ans++;

        System.out.println(ans);

        int[] answer = {1};
        if (String.valueOf(ans).length() == digits.length) {
            answer = new int[digits.length];
        } else{
            answer = new int[String.valueOf(ans).length()];
        }

        for (int i = String.valueOf(ans).length(); i >= 0; i--) {
            answer[i] = String.valueOf(ans).charAt(i);
        }

        return answer;
    }
}
