package arrayAndhash;

public class MonotonicArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2};
        System.out.println(isMonotonic(arr));
    }

    // nums = [1,2,2,3]
    public static boolean isMonotonic(int[] nums) {
        // -1 represent decreasing, 1 represent increasing
        int monotonic = 0;
        for (int i = 1; i < nums.length; i++) {
            if(monotonic == 1 && nums[i] < nums[i-1]){
                return false;
            }

            if(monotonic == -1 && nums[i] > nums[i-1]){
                return false;
            }

            if(nums[i] > nums[i-1]){
                monotonic = 1;
            }

            if(nums[i] < nums[i-1]){
                monotonic = -1;
            }
        }
        return true;
    }
}
