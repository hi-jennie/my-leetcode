package arrayAndhash;

public class MaxAscendingSum {
    public static void main(String[] args) {
        int[] arr = new int[]{10,20,30,5,10,50};
        int[] arr2 = new int[]{10,20,30,5,10,50};
        System.out.println(maxAscendingSum(arr));
        System.out.println(maxAscendingSum(arr2));
    }


    // [10,20,30,5,10,50] [100,10,1]
    public static int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int curAscSum = nums[0];
        for (int i = 0; i < nums.length -1; i++) {
            if(nums[i+1] > nums[i]){
                curAscSum += nums[i +1];
            }else{
                curAscSum = nums[i+1];
            }
            res = Math.max(res, curAscSum);
        }
        return res;
    }
}
