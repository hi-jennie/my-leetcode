package arrayAndhash;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strings = new String[]{""};
        System.out.println(groupAnagrams(strings));
    }

    // sorting ; map;
    // strs = ["act","pots","tops","cat","stop","hat"]
    // [["hat"],["act", "cat"],["stop", "pots", "tops"]]
    public static List<List<String>> mySolution(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        String[] sortedStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sortedStrs[i] = String.valueOf(chars);
        }

        for (int i = 0; i < sortedStrs.length; i++) {
            List<String> stringList  = new ArrayList<>();
            if(strs[i] == null) continue;
            for (int j = i; j < sortedStrs.length; j++) {
                if(sortedStrs[i].equals(sortedStrs[j])){
                    stringList.add(strs[j]);
                    strs[j] = null;
                }
            }
            res.add(stringList);
        }

        return res;
    }

    // better practice
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            // map.computeIfAbsent(key, k -> new ArrayList<>()).add(str); same with following
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
