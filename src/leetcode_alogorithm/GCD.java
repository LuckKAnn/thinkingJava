package leetcode_alogorithm;

/**
 * @FileName: GCD
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/5/19 19:37
 */
public class GCD {


    //利用辗转相除法计算最大公约数的方法
    //时间复杂度为O(log(|b-a|))
    public int gcd (int a,int b){
    //    保证a>=b
        if (a<b){
            int tmp = a;
            a=b;
            b=tmp;
        }
        else if(a==b) return a;
        return b!=0?gcd(b,a%b):a;
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(20, 8));
    }


}
