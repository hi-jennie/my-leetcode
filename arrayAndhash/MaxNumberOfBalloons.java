package arrayAndhash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxNumberOfBalloons {
    public static void main(String[] args) {
        System.out.println(mySolution("nlaebolko"));
    }

    // text = "nlaebolko"
    public static int mySolution(String text) {
        Map<Character, Integer> countText = new HashMap<>();
        for (char c : text.toCharArray()) {
            countText.put(c, countText.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> balloon = new HashMap<>();
        for (char c : "balloon".toCharArray()) {
            balloon.put(c, balloon.getOrDefault(c, 0) + 1);
        }

        // 看countText 里面每个字母能拼多少个单词
        int res = text.length();
        for (char c : balloon.keySet()) {
            res = Math.min(res, countText.getOrDefault(c, 0) / balloon.get(c));
        }
        return res;
    }
}
