package arrayAndhash;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(findTheCommonPre("my", "mysdjh"));
        System.out.println(findTheCommonPre("neet","feet"));
        System.out.println(findTheCommonPre("reflower","flow"));
        System.out.println(mySolution(new String[]{"dance","dag","danger","damage"}));
        System.out.println(mySolution(new String[]{"bat","bag","bank","band"}));
        System.out.println(mySolution(new String[]{"neet","feet"}));
        System.out.println(mySolution(new String[]{"reflower","flow","flight"}));

    }

    public static String mySolution(String[] strs) {
        Arrays.sort(strs, Comparator.comparing(s -> s.length()));
        String currPrefix = findTheCommonPre(strs[0], strs[0]);

        for (int i = 0; i < strs.length; i++) {
            if(currPrefix.isEmpty()){
                return currPrefix;
            }
            if(strs[i].substring(0, currPrefix.length() ) != currPrefix){
                currPrefix = findTheCommonPre(currPrefix, strs[i]);

            }

        }
        return currPrefix;
    }

    // assume that s1.len < s2.len
    public static String findTheCommonPre(String s1, String s2){
        String res = "";
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                return res;
            }else {
                res = res+ s1.charAt(i);
            }
        }
        return res;
    }

    // better solution
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
