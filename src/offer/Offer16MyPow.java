package offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @FileName: Offer16MyPow
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/30 10:20
 */

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 */
public class Offer16MyPow {
   /**
    * 基于快速幂进行实现
    *
    * 快速幂的理解，可以通过二进制位来理解
    * 将n解析成二进制形式，带入到x^n里面，拆分来看，即可
    *
    * @param x
    * @param n
    * @return
    */
   public double myPow(double x, int n) {
      if(n==0) return 1;
      boolean flag = false;
      long ln = n; //这里主要是为了应付n=Integer.MIN_VALUE;的问题，因为直接转换成整数可能存在溢出的问题

      if(ln<0){
         flag = true;
         ln=-ln;
      }


      double tmp = x;
      x=1.0;
      while(ln!=0){
         if((ln&1)==1) x*=tmp;
         tmp*=tmp;
         ln>>=1;
      }

      if(flag) return 1/x;
      else return x;

   }
}
