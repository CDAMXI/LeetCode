package _srccode;

public class GuessGame {
    private int pick; // secret number to guess

    // Constructor to establish the number to guess
    public GuessGame(int pick) {
        this.pick = pick;
    }

    // API guess simulation
    public int guess(int num) {
        if (num == pick){return 0;}
        else if (num > pick){return -1;}
        else{return 1;}
    }

    public int guessNumber(int n) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guessNumber'");
    }
}
