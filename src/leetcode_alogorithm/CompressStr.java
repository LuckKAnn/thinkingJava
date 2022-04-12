package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 10:26 PM 9/1/2021
 * @email: 1546165200@qq.com
 */

/**
 * 443. 压缩字符串
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 *
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 *
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 *
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 *
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 */
public class CompressStr {
    /**
     * 这道题的核心，就是统计还有int转字符串
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if(chars.length==0 ) return  0;
        int count  = 1;
        char pre = chars[0];
        char index = 0;
        for(int i=1;i<chars.length;i++){
            if(chars[i]==pre) count++;
            else {
                chars[index++] = pre;
                if(count!=1){
                    String s = int2String(count);
                    for(int j=s.length()-1;j>=0;j--){
                        chars[index++] = s.charAt(j);
                    }
                }
                pre = chars[i];
                count = 1;
            }
        }
        if(count==1){
            chars[index++]= pre;
        }
        else {
            String s = int2String(count);
            chars[index++] = pre;
            for(int j=s.length()-1;j>=0;j--){
                chars[index++] = s.charAt(j);
            }
        }
//        注意，返回的是长度，本身就有index长，只是在数组中index未使用
        return  index;

    }

//    int转换为string，注意这是倒序的，与输出的要求不同
    public String int2String(int x){
        StringBuilder sb = new StringBuilder();
        while (x!=0){
            sb.append(x%10);
            x/=10;
        }
        return  sb.toString();

    }
}
