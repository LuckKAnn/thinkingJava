package leetcode_alogorithm;

import java.util.Arrays;

public class MinTaps1326 {

    public int minTaps(int n, int[] ranges) {
        int [] left = new int[n+1];
        for (int i = 0; i < ranges.length; i++) {
            int l = i-ranges[i];
            int r = i+ranges[i];
            if (l<0){
                left[0] = Math.max(left[0],r);
            }else{
                left[l] = Math.max(left[l],r);
            }
        }
        System.out.println(Arrays.toString(left));


        int pre = 0;
        int count = 0;
        int last = 0;

        for (int i = 0; i < ranges.length; i++) {
            last = Math.max(left[i],last);
            if (i == pre){
                if (last==i){
                    return -1;
                }
                count++;
                if (last>=ranges.length-1) return count;
                pre= last;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        MinTaps1326 minTaps1326 = new MinTaps1326();
        int[] ints = {3, 4, 1, 1, 0, 0};

        System.out.println(minTaps1326.minTaps(5,
                ints));
    }
}
