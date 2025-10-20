package arrayAndhash;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> currList = new ArrayList<>();
            if(i == 0){
                currList.add(1);
                res.add(currList);
            }else{
                List<Integer> lastList = res.getLast();
                for (int j = 0; j < lastList.size()-1; j++) {
                    currList.add(lastList.get(j) + lastList.get(j+1));
                }
                currList.addFirst(1);
                currList.addLast(1);
                res.add(currList);
            }
        }
        return res;
    }
}
