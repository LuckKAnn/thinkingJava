package leetcode_alogorithm;


/**
 * 942. 增减字符串匹配
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 *
 *
 */
public class DiStringMatch942 {

    /**
     * 这道题采用贪心的策略，采用这种策略能够保证，只要原题可解，那么就一定能够满足所给的条件，并获得一个答案
     * @param s
     * @return
     */
    public int[] diStringMatch(String s) {
        int [] ans = new int[s.length()+1];
        int low =0, high = s.length();
        for (int i = 0; i < s.length(); i++) {
            ans[i] = s.charAt(i)=='I'?low++:high--;
        }


        ans[s.length()] = low;

        return ans;

    }
}
