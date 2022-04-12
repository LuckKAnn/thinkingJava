package leetcode_alogorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : LuckKAnn
 * @date : 12:55 2021/9/5
 * @email: 1546165200@qq.com
 */

/**
 * 5864. 游戏中弱角色的数量
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。
 *
 * 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。
 *
 * 返回 弱角色 的数量。
 *
 * 力扣周赛问题
 */
public class NumberOfWeakCharacters {
    /**
     * 这道题，当时没写出来
     * 当时想到了排序，但是没想到有一个应该顺序排，有一个逆序排
     * 譬如，按我所写的，如果攻击力顺序排，防御也顺序排，那这个方法不对，因为会出现某个用户，其防御力小于最大防御，但是其攻击力等同于这个最大防御者，这就导致不能判断
     * 现在防御力逆序排，那么对于某个用户，当期防御小于最大防御的时候，那他一定是弱角色，因为其后面的要么是攻击不相同但防御大的，要么是攻击相同但是防御小的，所以如果其小于最大防御，那其攻击一定弱于最大防御
     * @param properties
     * @return
     */

    public int numberOfWeakCharacters(int[][] properties) {
        int count = 0;
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //数组也可以用comparator
                //此外，返回负值，代表小于，正值代表大于
                //小于正序，大于逆序
                if(o1[0]!=o2[0]) return o1[0]-o2[0];
                else return o2[0]-o1[0];
            }
        });
        int MaxDf =properties[properties.length-1][1];
        for(int i=properties.length-2;i>=0;i--){
            if(properties[i][1]<MaxDf) count++;
            MaxDf = Math.max(MaxDf,properties[i][1]);
        }

        return  count;

    }
}
