package leetcode_alogorithm;

/**
 * @FileName: toHex
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/8 9:47
 */

/**
 * 405. 数字转换为十六进制数
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * ********* ************************************
 * 注意，这里有一定的思路和想法在里面
 * 1.如果i从0开始，也就是从低位开始计算十六进制，这样最后需要倒置，且需要额外处理前置0的情况，毕竟麻烦
 * 2.如果从高位先计算，不仅前导0容易处置(sb.length() > 0 || val > 0)，且最后不需要导致
 */
public class ToHex {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 7; i >= 0; i --) {
            //移位相与
            //0(零)xf 十六进制1111
            int val = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || val > 0) {
                //这里主要(char) 有时候要注意加上，否则('0' + val)可能得到的是数字而非字符
                char digit = val < 10 ? (char) ('0' + val) : (char) ('a' + val - 10);
                sb.append(digit);
            }
        }
        return sb.toString();
    }
}
