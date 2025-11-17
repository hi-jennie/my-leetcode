package arrayAndhash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3}, {2,2}};
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));

    }

    // grid = [[1,3],[2,2]]
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j],0) +1);
            }
        }
        System.out.println(map);
        for (int i = 1; i <= grid.length * grid.length; i++) {
            if(map.containsKey(i) && map.get(i) > 1){
                res[0] = i;
            }
            if(!map.containsKey(i)){
                res[1] = i;
            }
        }

        return res;
    }
}
