public class plusOnev3 {
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

        String s = String.valueOf(ans);
        int[] answer;
        if(s.length() > digits.length){answer = new int[digits.length+1];}
        else{answer = new int[digits.length];}
        

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = ans % 10;
            ans/=10;
        }
        
        return answer;
    }
}
