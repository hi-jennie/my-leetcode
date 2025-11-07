package arrayAndhash;

import java.util.*;

public class NextGreaterNumber {
    public static void main(String[] args) {
        int[] arr1 = new int[]{4,1,2,5};
        int[] arr2 = new int[]{7,5,4,6,2,1,8};
        System.out.println(Arrays.toString(mySolution(arr1, arr2)));
        System.out.println(Arrays.toString(nextGreaterElement3(arr1, arr2)));
    }


    // using stack and hashmap
    public static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nums1Idx = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1Idx.put(nums1[i], i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = -1;
        }
        int[] arr1 = new int[]{4,1,2};
        int[] arr2 = new int[]{1,2,5,3,4};
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            // 如果当前num比stack顶端元素大，说明找到了下一个更大值， 比如stack
            // 现有元素{7,5,4,2}，当前num=8，那么8>2, 8>6, 8>4, 8>5, 8>7，说明所有元素都在找到了右边的下一个更大值
            // 此时元素可能还剩{8,4,5,7}, 继续遍历nums2
            while(!stack.isEmpty() && num > stack.peek()) {
                int val = stack.pop();
                int idx = nums1Idx.get(val);
                res[idx] = num;
            }
            // 遍历nums2，把nums1的值放入stack
            if (nums1Idx.containsKey(num)) {
                stack.push(num);
            }
        }
        return res;
    }

    // nums1 = [4,1,2], nums2 = [1,3,4,2]
    public static int[] mySolution(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums2.length; i++) {
            list.add(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            // list.indexOf(nums1[i]) time complexity O(n)
            for (int j = list.indexOf(nums1[i]); j < nums2.length; j++) {
                if(nums2[j] > nums1[i]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }

    // brutal force
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int nextGreater = -1;
            // iterate from right to left
            for (int j = n - 1; j >= 0; j--) {
                if (nums2[j] > nums1[i]) {
                    nextGreater = nums2[j];
                } else if (nums2[j] == nums1[i]) {
                    break;
                }
            }
            res[i] = nextGreater;
        }
        return res;
    }

    // better key is that the nums1 the subset of nums2
    public int[] nextGreaterElement2(int[] nums1, int[] nums2){
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> nums1Idx = new HashMap<>();
        // using hashmap to get the index, time complexity O(1)
        for (int i = 0; i < nums1.length; i++) {
            nums1Idx.put(nums1[i], i);
        }

        for (int i = 0; i < nums2.length; i++) {
            // nums1Idx.containsKey(nums2[i] ) time complexity O(1)
            if(!nums1Idx.containsKey(nums2[i])){
                continue;
            }

            // if contains, then find the next greater
            for (int j = i + 1; j < nums2.length; j++) {
                if(nums2[j] > nums2[i]){
                    int  nextGreater = nums2[j];
                    // find where to put the next greater in nums1
                    int idx = nums1Idx.get(nums2[i]);
                    res[idx] = nextGreater;
                    break;
                }
            }
        }
        return res;
    }
}
