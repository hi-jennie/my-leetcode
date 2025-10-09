package arrayAndhash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {
    public static void main(String[] args) {
        System.out.println(hasDuplicate(new int[]{1,2,1}));
        System.out.println(hasDuplicate(new int[]{1,2}));
        System.out.println(solution(new int[]{1,2,1}));
        System.out.println(solution(new int[]{1,2}));
    }
    // brutal force
    public static boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    // sort first
    public static boolean solution(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i +1]){
                return true;
            }
        }
        return false;
    }

    // using HashSet --> don't allow duplicate
    public boolean solution1(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
