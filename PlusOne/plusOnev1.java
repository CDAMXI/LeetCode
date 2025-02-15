public class plusOnev1 {
    public static void main(String[] args) {
        System.out.println(plusone(new int[] {1,2,3}));
        System.out.println(plusone(new int[] {4,3,2,1}));
        System.out.println(plusone(new int[] {9}));
    }

    public static int[] plusone(int[] digits){
        int answer = Integer.parseInt(digits.toString());
        answer += 1;
        int[] ans = new int[digits.length];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = answer % 10;
            answer /= 10;
        }
        return ans;
    }
}
