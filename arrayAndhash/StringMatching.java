package arrayAndhash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatching {
    public static void main(String[] args) {
        System.out.println(mySolution(new String[]{"mass","as","hero","superhero"}));
    }

    public static List<String> mySolution(String[] words){
        Arrays.sort(words, Comparator.comparing(s -> s.length()));
        System.out.println(Arrays.toString(words));
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if(words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
