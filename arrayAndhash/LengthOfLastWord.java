package arrayAndhash;

import java.util.Arrays;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(mySolution("   fly me   to   the moon  "));
        System.out.println(mySolution("Hello World"));
        System.out.println(mySolution("luffy is still joyboy"));
        System.out.println(mySolution("Hello"));
        System.out.println(mySolution2("moon"));
        System.out.println(mySolution2("   fly me   to   the moon  "));

    }

    public static int mySolution(String s) {
       char[] cArr = s.trim().replace(' ', '0').toCharArray();
        for (int i = cArr.length-1; i >=0; i--) {
            if(cArr[i] == '0'){
                return cArr.length-1-i;
            }
        }
        return cArr.length;
    }

    // best practices
    public static int mySolution2(String s) {
        String subStr = s.trim().replace(' ', '0');
        int lastIdx = subStr.lastIndexOf('0');
        return lastIdx >=0 ? subStr.length() - 1 - lastIdx : subStr.length();
    }
}
