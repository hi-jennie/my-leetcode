package arrayAndhash;

import java.util.HashMap;
import java.util.Map;

public class LuckyInteger {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,3,3,3};
        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {
        int res = -1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue().equals(entry.getKey())){
                res = entry.getKey();
            }
        };

        return res;
    }
}
