package arrayAndhash;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();

        // sort at original array
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        System.out.println(charArray1);
        System.out.println(charArray2);
        return Arrays.equals(charArray1, charArray2);

        // compare  address
        // if(charArray1.equals(charArray2)){
        //     return true;
        //  }
        // return false;
    }

    // using HashMap
    public class Solution1 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            // key / value pair
            HashMap<Character, Integer> countS = new HashMap<>();
            HashMap<Character, Integer> countT = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                // getOrDefault(key, defaultValue) : return the value of key s.charAt(i), if not exist, return 0
                countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
                countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
            }
            return countS.equals(countT);
        }
    }

    public boolean Solution2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // char - char, both char values are implicitly converted to int.
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
