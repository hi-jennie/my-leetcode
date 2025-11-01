package arrayAndhash;

import java.util.HashMap;
import java.util.Set;

public class MaxDifference {
    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
        System.out.println(maxDifference("abcabcab"));
    }

    public static int maxDifference(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            map.put(currChar, map.getOrDefault(currChar, 0) + 1);
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (Character key : map.keySet()) {
            if(map.get(key) % 2 == 0 && map.get(key) < minEven){
                minEven = map.get(key);
            }
            if(map.get(key) % 2 != 0 && map.get(key) > maxOdd){
                maxOdd = map.get(key);
            }
        }

        return maxOdd-minEven;
    }
}
