public class IntToStringv1 {
    public static void main(String[] args){
        System.out.println(numbersToWords(123));
        System.out.println(numbersToWords(12345));
        System.out.println(numbersToWords(1234567));
    }

    public static String numbersToWords(int num){
        String[] spelledNumbers = {"zero",
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
            "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety",
            "one hundred", "one thousand"
        };

        if (num >= 0 && num < 21) {return spelledNumbers[num];}
        else if (num < 100) {
            return spelledNumbers[20 + num / 10] + (num % 10 == 0 ? "" : " " + spelledNumbers[num % 10]);
        }
        else if (num < 1000) {
            return spelledNumbers[num / 100] + " hundred" + (num % 100 == 0 ? "" : " and " + numbersToWords(num % 100));
        }
        else if (num < 10000) {
            return spelledNumbers[num / 1000] + " thousand" + (num % 1000 == 0 ? "" : " " + numbersToWords(num % 1000));
        }
        else {return "Number out of range";}
    }
}
