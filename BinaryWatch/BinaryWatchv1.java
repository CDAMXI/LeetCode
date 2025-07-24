import java.util.*;

public class BinaryWatchv1{
    public static int[] H = {1,2,4,8};
    public static int[] M = {1,2,4,8,16,32};
    public static void main(String[] args){
        System.out.println(readBinaryWatch(1));
        System.out.println(readBinaryWatch(5));
    }

    public static List<String> readBinaryWatch(int turnedOn){
        if(turnedOn < 0 || turnedOn > 8) {return new ArrayList<>();}
        if(turnedOn == 0) {return Arrays.asList("0:00");}
        List<String> result = new ArrayList<>();
        if(turnedOn == 1){
            for(int i = 0; i < M.length; i++){
                if(M[i] < 10){result.add("0:0" + M[i]);}
                else {result.add("0:" + M[i]);}
            }

            for(int i = 0; i < H.length; i++){
                String hour = H[i] < 10 ? String.valueOf(H[i]).substring(1) : String.valueOf(H[i]);
                result.add(hour + ":00");
            }
        }
        if(turnedOn > 1){
            for(int i = 0; i < H.length; i++){
                for(int j = 0; j < M.length; j++){
                    if(H[i] + M[j] < 60 && (H[i] + M[j]) > 0){
                        String hour = H[i] < 10 ? "0" + H[i] : String.valueOf(H[i]);
                        String minute = M[j] < 10 ? "0" + M[j] : String.valueOf(M[j]);
                        result.add(hour + ":" + minute);
                    }
                }
            }
        }
        return result;
    }
}
