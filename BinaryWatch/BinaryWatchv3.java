import java.util.*;

public class BinaryWatchv3 {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
        System.out.println(readBinaryWatch(5));
    }

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        if (turnedOn < 0 || turnedOn > 8){return result;}

        for (int hBits = 0; hBits <= Math.min(turnedOn, 4); hBits++) {
            int mBits = turnedOn - hBits;
            if (mBits > 6){continue;}

            List<Integer> hours = generateNumbersWithBits(hBits, 4, 12);  // 0–11
            List<Integer> minutes = generateNumbersWithBits(mBits, 6, 60); // 0–59

            for (int h : hours) {
                for (int m : minutes) {
                    result.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }

        return result;
    }

    // Generates all numbers with exactly 'bits' bits set, within 'maxBits' total bits and value < 'limit'
    private static List<Integer> generateNumbersWithBits(int bits, int maxBits, int limit) {
        List<Integer> result = new ArrayList<>();
        generateCombinations(0, bits, 0, maxBits, limit, result);
        return result;
    }

    private static void generateCombinations(int num, int bitsLeft, int pos, int maxBits, int limit, List<Integer> result) {
        if (bitsLeft == 0) {
            if (num < limit) result.add(num);
            return;
        }
        for (int i = pos; i < maxBits; i++) {
            generateCombinations(num | (1 << i), bitsLeft - 1, i + 1, maxBits, limit, result);
        }
    }
}
