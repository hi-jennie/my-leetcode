package arrayAndhash;

// You are given a string s. The score of a string is defined
// as the sum of the absolute difference between the ASCII values of adjacent characters.
public class ScoreOfString {
    public static void main(String[] args) {
        scoreOfString("hello");
        scoreOfString("zaz");
    }

    public static int scoreOfString(String s) {
        int result = 0;
        for(int i = 0; i < s.length()-1; i++ ){
            char currChar = s.charAt(i);
            char nextChar = s.charAt(i+1);
            int currDiff = (int)nextChar - (int)currChar;
            result +=Math.abs(currDiff);
        }
        System.out.println(result);
        return result;
    }
}
