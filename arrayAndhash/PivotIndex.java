package arrayAndhash;

public class PivotIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{1,7,3,6,5,6};
        int[] arr1 = new int[]{-1,-1,-1,1,1,1};
        int[] arr2 = new int[]{2,1,-1};
        System.out.println(pivotIndex(arr2));
        System.out.println(pivotIndex(arr));
        System.out.println(pivotIndex(arr1));
    }


    // nums = [1,7,3,6,5,6]
    public static int pivotIndex(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int leftSum = 0;
        int rightSum = totalSum;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                leftSum = 0;
            }else{
                leftSum += nums[i-1];
            }

            rightSum = rightSum - nums[i];

            if(leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }


    // better
    public static int pivotIndex2(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
