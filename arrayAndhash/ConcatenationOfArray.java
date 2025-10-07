package arrayAndhash;

import java.util.Arrays;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        getConcatenation(new int[]{1,2,1});
    }

    public static int[] getConcatenation(int[] nums) {
        // int array the size is fixed, different from list
        int[] ans = new int[nums.length * 2 ]; // shallow copy, suitable for primitive types
        for(int i = 0; i < nums.length * 2; i++){
            ans[i] = i < nums.length ? nums[i] : nums[i- nums.length];

        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }

    public int[] solution(int[] nums) {
        int[] ans = new int[2 * nums.length];
        int idx = 0;
        // execute 2 times
        for (int i = 0; i < 2; i++) {
            for (int num : nums) {
                ans[idx++] = num;
            }
        }
        return ans;
    }
}
