import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SingleNumberIIv1{
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
        System.out.println(singleNumber(new int[]{30000,500,100,30000,100,30000,100}));
    }

    public static int singleNumber(int[] nums){
        HashMap <Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {map.put(nums[i], 1);}
            else{
                map.get(nums[i]);
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        Map<Integer, Integer> sortedReverseByKey = new TreeMap<>(Collections.reverseOrder());
        sortedReverseByKey.putAll(map);
        int result = sortedReverseByKey.keySet().iterator().next();
        return result;
    }
}
