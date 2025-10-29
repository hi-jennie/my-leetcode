package arrayAndhash;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int[] nums2 = {3,2,3};
        System.out.println(mySolution(nums2));
        System.out.println(mySolution(nums));
    }

    public static int mySolution(int[] nums) {
        HashMap<Integer, Integer> hs = new HashMap<>();

        for (int num : nums) {
            hs.put(num, hs.getOrDefault(num, 0) + 1);
        }
        int maxKey = Integer.MIN_VALUE;
        int maxVal = Integer.MIN_VALUE;

        // loop through the hashmap to find the key with the maximum value
        for (Map.Entry<Integer, Integer> entry : hs.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxKey = entry.getKey();
                maxVal = entry.getValue();
            }
        }

        return maxKey;
    }

    // optimized version（try to document something when loop through)
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int res = 0, maxCount = 0;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            if (count.get(num) > maxCount) {
                res = num;
                maxCount = count.get(num);
            }
        }
        return res;
    }
}
