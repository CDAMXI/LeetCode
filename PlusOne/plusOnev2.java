public class plusOnev2 {
    public static void main(String[] args) {
        plusone(new int[] {1,2,3});
        plusone(new int[] {4,3,2,1});
        plusone(new int[] {9});
    }

    public static int[] plusone(int[] digitis){
        int ans = 0;

        for (int i = 0; i < digitis.length; i++) {
            ans = ans * 10 + digitis[i];
        }

        ans++;

        int[] answer = new int[digitis.length];

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = ans % 10;
            ans/=10;
        }
        
        return answer;
    }
}
