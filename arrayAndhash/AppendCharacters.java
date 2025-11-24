package arrayAndhash;

/**
 * 双指针/ 迭代对象的选择
 */
public class AppendCharacters {
    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
        System.out.println(appendCharacters("abcde", "ace"));
        System.out.println(appendCharacters("z", "abcde"));

    }

    // Input: s = "coaching", t = "coding" 	•	s = "abcde"  t = "ace"
    public static int mySolution(String s, String t) {
        int indexOfT = 0;
        int indexOfS = 0;

        while(indexOfT < t.length()){
            while(indexOfS < s.length()) {
                if(t.charAt(indexOfT) == s.charAt(indexOfS)){
                    indexOfT++;
                    break;
                }
                indexOfS++;
            }

            if(indexOfS == s.length()){
                break;
            }
        }

        return  t.length() - indexOfT;
    }


    // better practice
    public static  int appendCharacters(String s, String t) {
        int j = 0; // pointer for t

        //  迭代s 长字符串， t的index 在条件满足时前进
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }

        return t.length() - j;
    }


    // my solution
    public static int appendCharacters2(String s, String t) {
        int indexOfT = 0;
        int indexOfS = 0;

        while (indexOfS < s.length() && indexOfT < t.length()) {
            if (t.charAt(indexOfT) == s.charAt(indexOfS)) {
                indexOfT++;
            }
            indexOfS++;
        }

        return t.length() - indexOfT;
    }

}
