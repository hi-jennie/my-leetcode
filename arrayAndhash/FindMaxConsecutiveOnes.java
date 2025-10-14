package arrayAndhash;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        System.out.println(mySolution(new int[]{1,1,1,1,1,1}));
        System.out.println(mySolution(new int[]{1,0,1,1,0,1}));
       }

    public static int mySolution(int[] nums){
        int prevMax= 0;
        int currMax = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                currMax ++;
            }
            if(nums[i] == 0){
                // every time we encounter 0 we check if current max is greater than previous max
                // only if the current max is greater we update the previous max
                if(currMax > prevMax) prevMax = currMax;
                currMax = 0;
            }
        }
        return Math.max(prevMax, currMax);
    }
}
