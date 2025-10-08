package arrayAndhash;

import java.util.Arrays;

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
}
