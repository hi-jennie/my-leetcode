package arrayAndhash;

import java.util.ArrayList;
import java.util.List;

public class LongestMonotonicSubarray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,3,3,2};
        int[] arr2 = new int[]{3,7,1};
//        System.out.println(longestMonotonicSubarray(arr));
        System.out.println(longestMonotonicSubarray2(arr2));
    }



    // *** we don't need to return all the subarray. just return the len;
    public static int longestMonotonicSubarray2(int[] nums) {
        int cur = 1;
        int res = 1;
        // 1 represent increasing, -1 represent decreasing
        int increasing = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (increasing > 0) {
                    cur++;
                } else {
                    cur = 2;
                    increasing = 1;
                }
            } else if (nums[i - 1] > nums[i]) {
                if (increasing < 0) {
                    cur++;
                } else {
                    cur = 2;
                    increasing = -1;
                }
            } else {
                cur = 1;
                increasing = 0;
            }
            res = Math.max(res, cur);
        }

        return res;
    }

    // nums = [1,4,3,3,2]
    public static int mySolution(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> currList = new ArrayList<>();
            currList.add(nums[i]);
            System.out.println(currList);
            int index = i + 1;

            if(index == nums.length){
                resList.add(currList);
                break;
            }

            if(nums[index] > nums[i]){
                while(index < nums.length && nums[index] > nums[index -1]){
                    currList.add(nums[index]);
                    index++;
                }
            }else{
                while(index < nums.length && nums[index] < nums[index -1]){
                    currList.add(nums[index]);
                    index++;
                }
            }
            resList.add(currList);

        }
        System.out.println(resList);
        int res = 0;
        for (List<Integer> integers : resList) {
            if(integers.size() >= res){
                res = integers.size();
            }
        }

        return res;
    }
}
