package arrayAndhash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KthDistinctString {
    public static void main(String[] args) {
        String[] s1 = new String[]{"aaa","aa","a"};
        System.out.println(kthDistinct(s1, 3));
    }

    // arr = ["d","b","c","b","c","a"], k = 2
    public static String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (String s : arr) {
            if (map.get(s) == 1) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }

        return "";
    }

    public static String mySolution(String[] arr, int k){
        HashMap<String,Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
                res.add(arr[i]);
            }else{
                res.remove(arr[i]);
            }
        }
        if(k > res.size()){
            return "";
        }
        return res.get(k-1);
    }
}
