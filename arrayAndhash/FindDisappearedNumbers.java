package arrayAndhash;

import java.util.*;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        int[] arr1 = new int[]{1,1};

        System.out.println(findDisappearedNumbers(arr));
        System.out.println(findDisappearedNumbers(arr1));
    }
    

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],0);
            nums[i] = i +1;
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null){
                res.add(nums[i]);
            }
        }
        return res;
    }

    // optimized
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, true);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                res.add(i);
            }
        }
        return res;
    }

    // using set
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int n = nums.length;
        Set<Integer> store = new HashSet<>();
        for (int i = 1; i <= n; i++) store.add(i);

        for (int num : nums) {
            store.remove(num);
        }

        return new ArrayList<>(store);
    }

    public List<Integer> findDisappearedNumbers3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();
        int idx = 0;
        for (int num = 1; num <= n; num++) {
            while (idx < n && nums[idx] < num) {
                idx++;
            }
            if (nums[idx] > num || idx == n ) {
                res.add(num);
            }
        }
        return res;
    }
}
