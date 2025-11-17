package arrayAndhash;

import java.util.*;

public class DivideArrayIntoEqualPairs {
    public static void main(String[] args) {
        System.out.println("hell0,"+ args[0]);
        int[] arr = new int[]{1,2,3,4};
        System.out.println(divideArray(arr));
    }

    public static boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);
        List<Integer> valuesList = new ArrayList<>(map.values());
        for (Integer value : valuesList) {
           if(value % 2 != 0){
               return false;
           }
        }

        return true;
    }
}
