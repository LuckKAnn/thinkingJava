package leetcode_alogorithm;

/**
 * @author : LuckKAnn
 * @date : 9:31 PM 9/1/2021
 * @email: 1546165200@qq.com
 */

/**
 * 力扣165题
 给你两个版本号 version1 和 version2 ，请你比较它们。

 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。

 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。

 返回规则如下：

 如果 version1 > version2 返回 1，
 如果 version1 < version2 返回 -1，
 除此之外返回 0。

 */
public class CompareVersion {
    /**
     * 采用字符串分割的方法也可以做这道题，也即是使用spilt方法，一句'.'号将字符串分割
     * 这里直接采用双指针的方式进行分割
     * @param v1
     * @param v2
     * @return
     */
    public int compareVersion(String v1, String v2) {
        int i=0,j=0;
//        可以直接用for循环替代
        while(i<v1.length()||j<v2.length()){
//            初始化为0代表每一段单独计算
            int tmp1=0,tmp2=0;
            while(i<v1.length()&&v1.charAt(i)!='.'){
//                计算字符串的int值可以直接用以下代码替换，可以在使用分割方法的时候有用
//                Integer.parseInt();

//                这里既然前导0要舍弃，那么依据这样的计算方式，同样可以舍去前导0
                tmp1 = tmp1*10+v1.charAt(i)-'0';
                i++;
            }
            while(j<v2.length()&&v2.charAt(j)!='.'){
                tmp2=tmp2*10+v2.charAt(j)-'0';
                j++;
            }
            if(tmp1>tmp2) return 1;
            else if(tmp1<tmp2) return -1;
            else{
                i++;
                j++;
            }
        }

        return 0;

    }
}
