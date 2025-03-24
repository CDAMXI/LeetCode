package StringToInt;

public class StringToIntv1 {
    public static void main(String[] args){
        System.out.println(stringToInt("Zero"));
        System.out.println(stringToInt("Twenty Five"));
    }

    public static int stringToInt(String str){
        int[] ones = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] onesStr = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        int[] teens = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        String[] teensStr = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        int[] tens = {20, 30, 40, 50, 60, 70, 80, 90};
        String[] tensStr = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        int[] hundreds = {100, 200, 300, 400, 500, 600, 700, 800, 900};
        String[] hundredsStr = {"One Hundred", "Two Hundred", "Three Hundred", "Four Hundred", "Five Hundred", "Six Hundred", "Seven Hundred", "Eight Hundred", "Nine Hundred"};
        int[] thousands = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
        String[] thousandsStr = {"One Thousand", "Two Thousand", "Three Thousand", "Four Thousand", "Five Thousand", "Six Thousand", "Seven Thousand", "Eight Thousand", "Nine Thousand"};
        int[] millions = {1_000_000, 2_000_000, 3_000_000, 4_000_000, 5_000_000, 6_000_000, 7_000_000, 8_000_000, 9_000_000};
        String[] millionsStr = {"One Million", "Two Million", "Three Million", "Four Million", "Five Million", "Six Million", "Seven Million", "Eight Million", "Nine Million"};
        int[] billions = {1_000_000_000, 2_000_000_000};
        String[] billionsStr = {"One Billion", "Two Billion"};
        
        int value = 0;
        for (int i = 0; i < onesStr.length; i++){
            if (str.equals(onesStr[i])){
                value = ones[i];
                break;
            }
        }
        for (int i = 0; i < teensStr.length; i++){
            if (str.equals(teensStr[i])){
                value = teens[i];
                break;
            }
        }
        for (int i = 0; i < tensStr.length; i++){
            if (str.equals(tensStr[i])){
                value = tens[i];
                break;
            }
        }
        for (int i = 0; i < hundredsStr.length; i++){
            if (str.equals(hundredsStr[i])){
                value = hundreds[i];
                break;
            }
        }
        for (int i = 0; i < thousandsStr.length; i++){
            if (str.equals(thousandsStr[i])){
                value = thousands[i];
                break;
            }
        }
        for (int i = 0; i < millionsStr.length; i++){
            if (str.equals(millionsStr[i])){
                value = millions[i];
                break;
            }
        }
        for (int i = 0; i < billionsStr.length; i++){
            if (str.equals(billionsStr[i])){
                value = billions[i];
                break;
            }
        }
        return value;
    }
}
