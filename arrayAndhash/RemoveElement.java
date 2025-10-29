package arrayAndhash;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums2 = {3,2,2,3};
        System.out.println(removeElement(nums, 2));
        System.out.println(removeElement(nums2, 3));
        System.out.println(Arrays.toString(nums));
    }

    public static int mySolution(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                count ++;
                nums[i] = -1;
            }
        }
        Arrays.sort(nums);
        // order in descending order
        for (int i = 0; i < nums.length / 2; i++) {
            // swap nums[i] and nums[nums.length - 1 - i]
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums.length - count;
    }

    // optimized version using two pointers(i is a reading pointer(in front), k is writing pointer)
    // not deleting elements, just moveing non-val elements to the front and return the length of non-val elements(valid element_)
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                // if found the val, swap the last element with the current element
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }
        return n;
    }
}
