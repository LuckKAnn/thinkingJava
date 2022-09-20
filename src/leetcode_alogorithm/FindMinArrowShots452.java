package leetcode_alogorithm;

import java.util.Arrays;

/**
 * @FileName: FindMinArrowShots452
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/8/10 22:41
 */

/**
 * TODO:区间相交类问题
 * 衍生题型，如果要找两个相交的怎么办  757
 */
public class FindMinArrowShots452 {
    //那道题是要求最少两个相交
    //  这个题似乎是找一个想交的最小集合
    public int findMinArrowShots(int[][] points) {

        int res = 0;

        Arrays.sort(points,(a, b)->{
            if(a[0]<b[0]) return -1;
            else return 1;
            // return a[0]-b[0];
        });

        boolean []flag = new boolean[points.length];
        for(int i = points.length-1;i>=0;i--){

            if(flag[i]) continue;
            res++;
            flag[i] = true;
            int tmp = points[i][0];
            for(int j=i-1;j>=0;j--){
                if(tmp>points[j][1]) break;
                else{
                    flag[j] = true;

                }
            }
        }
        return res;

    }
}
