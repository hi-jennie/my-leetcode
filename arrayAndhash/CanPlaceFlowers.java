package arrayAndhash;

import java.util.Arrays;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = new int[]{1,0,0,1,0,0,1,0,1};
        int[] flowerbed2 = new int[]{1,0,0,0,1,0,0};
        int[] flowerbed3 = new int[]{0,0,1,0,1};
        System.out.println(canPlaceFlowers(flowerbed, 2));
        System.out.println(canPlaceFlowers(flowerbed2, 2));
        System.out.println(canPlaceFlowers(flowerbed3, 2));
    }

    public static boolean mySolution(int[] flowerbed, int n) {
        // 参数预处理
        int max = 0;
        int i = 0;
        while(i <= flowerbed.length -2){
            if(i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                max++;
                i++;
                continue;

            }

            if( i == flowerbed.length -2 && flowerbed[i] == 0 && flowerbed[i+1] == 0){
                max++;
                break;
            }

            if(flowerbed[i] == 0 && flowerbed[i+1] == 0 && flowerbed[i+2] == 0){
                max++;
                i+=2;
            }else{
                i++;
            }
        }
        return max >= n;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int[] f = new int[flowerbed.length + 2];
        for (int i = 0; i < flowerbed.length; i++) {
            f[i + 1] = flowerbed[i];
        }

        for (int i = 1; i < f.length - 1; i++) {
            if (f[i - 1] == 0 && f[i] == 0 && f[i + 1] == 0) {
                f[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }
}
