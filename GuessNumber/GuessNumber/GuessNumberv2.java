package GuessNumber;

public class GuessNumberv2 {
    private int pick; // Secret Number

    // Constructor method to establish the secret Number
    public GuessNumberv2(int pick) {
        this.pick = pick;
    }

    // guess API Simulator
    public int guess(int num) {
        if (num == pick) return 0;
        else if (num > pick) return -1;
        else return 1;
    }

    // Mehtod that will guess the number using Binary Search
    public int guessNumber(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);

            if (res == 0) {
                return mid; // You guessed
            } else if (res < 0) {
                right = mid - 1; // The number is smaller
            } else {
                left = mid + 1; // The number is higher
            }
        }

        return -1; // Just in case, eventhough nothing should happen acording to the restrictions
    }

    // Método para pruebas
    public static void main(String[] args) {
        GuessNumberv2 game = new GuessNumberv2(6); // Establecemos que el número secreto es 6
        int n = 10;
        int result = game.guessNumber(n);
        System.out.println("El número secreto es: " + result);
    }
}
