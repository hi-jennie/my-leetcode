package arrayAndhash;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(mySolution("abc","ahbgdc"));
        System.out.println(mySolution("axc","ahbgdc"));
        System.out.println(mySolution("aaaaaa","bbaaaa"));
    }

    public static boolean mySolution(String s, String t) {
        char[] charS = s.toCharArray();
        String subStringOfT = t;
        for (int i = 0; i < charS.length; i++) {
            int index = subStringOfT.indexOf(charS[i]);
            if(index < 0) return false;

            // index should + 1 orelse
            subStringOfT = subStringOfT.substring(index+1, subStringOfT.length());
        }
        return true;
    }
}
