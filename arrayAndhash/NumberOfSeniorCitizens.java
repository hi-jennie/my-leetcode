package arrayAndhash;

import java.sql.Array;
import java.util.Arrays;

public class NumberOfSeniorCitizens {
    public static void main(String[] args) {
        System.out.println(mySolution(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}));
        System.out.println(mySolution(new String[]{"1313579440F2036","2921522980M5644"}));
    }


    public static int mySolution(String[] details) {
        String[] ages = Arrays.stream(details).map(s -> (s.substring(11,13))).toArray(String[]::new);
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            if(Integer.parseInt(ages[i]) > 60){
                count++;
            }
        }
        return count;

    }

    // better practices
    public int countSeniors(String[] details) {
        int res = 0;
        for (String d : details) {
            if (Integer.parseInt(d.substring(11, 13)) > 60) {
                res++;
            }
        }
        return res;
    }

    // another solution
    public int countSeniors2(String[] details) {
        int res = 0;
        for (String d : details) {
            int ten = d.charAt(11) - '0';
            int one = d.charAt(12) - '0';
            int age = one + 10 * ten;
            if (age > 60) {
                res++;
            }
        }
        return res;
    }
}
