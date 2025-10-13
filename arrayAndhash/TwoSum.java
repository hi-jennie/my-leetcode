package arrayAndhash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(usingSorting(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(usingHashMap(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(usingHashMap2(new int[]{2,7,11,15}, 9)));
    }

    public static int[] mySolution(int[] nums, int target) {
       return new int[]{};
    }

    public static int[] usingSorting(int[] nums, int target) {
        // store the value and the corresponding index
        int[][] A = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            A[i][0]  = nums[i];
            A[i][1] = i;
        }

        // sort the 2-d array according the value, a is the component inside the A[value, index]
        Arrays.sort(A, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int front = A[i][0];
            int end = A[j][0];
            int curSum = front + end;
            if(curSum == target){
                return new int[]{
                        Math.min(A[i][1], A[j][1]),
                        Math.max(A[i][1], A[j][1])
                };
            } else if (curSum < target) {
                // if the current sum is less than target, we need to increase the sum by moving to the next larger number
                i++;
            }else{
                // if the current sum is greater than target, we need to decrease the sum by moving to the next smaller number
                j--;
            }
        }
        return new int[0];
    }

    public static int[] usingHashMap(int[] nums, int target){
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer diff = target - nums[i];
            if(m.containsKey(diff) && m.get(diff) != i){
                return new int[]{i, m.get(diff)};
            }
        }
        return new int[0];
    }

    // best practice
    public static int[] usingHashMap2(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer curr = nums[i];
            Integer diff = target - curr;
            if(m.containsKey(diff)){
                return new int[]{m.get(diff), i};
            }
            m.put(nums[i], i);
        }

        return new int[0];
    }
}
