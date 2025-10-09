package arrayAndhash;

import java.util.Arrays;

public class ReplaceElementToRight {
    public static void main(String[] args) {
        Arrays.toString(MySolution(new int[]{17,18,5,4,6,1}));
        Arrays.toString(MySolution(new int[]{60}));

    }

    public static int[] MySolution(int[] arr){
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1){
                result[i] = -1;
            }else{
                result[i] = getMaxOfRight(arr, i+1);
            }

        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static int getMaxOfRight(int[]arr, int startIdx){
        int max = arr[startIdx];
        for (int i = startIdx + 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static int[] solution(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        int rightMax = -1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = rightMax;
            rightMax = Math.max(rightMax, arr[i]);
        }
        return ans;
    }

}
