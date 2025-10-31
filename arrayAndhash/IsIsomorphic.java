package arrayAndhash;

import java.util.HashMap;

public class IsIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("badc", "baba"));
        System.out.println(isIsomorphic("paper", "title"));
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(map.containsKey(charS) && map.get(charS)!=charT){
                    return false;
            }
            if(!map.containsKey(charS) && map.containsValue(charT)){
                return false;
            }
            map.put(charS, charT);
        }
        return true;
    }
}
