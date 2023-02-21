import annotation.MyAnnotation;

import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int n = 0,m = 0,k = 0, sum = 0;
            n = scan.nextInt();
            m = scan.nextInt();
            k = scan.nextInt();
            int[] num = new int[n];
            Arrays.fill(num,1);
            sum = (n-1)*(m-1);
            if (sum < k) System.out.println(-1);
            else {
                int i = 0;
                sum = 0;
                while (sum < k && i < n) {
                    if(i % 2 == 1) {
                        num[i] = m;
                        sum = 2 * (m - 1) + sum;
                    }
                    i++;
                }
                if (k % 2 ==0) {
                    while (sum != k) {
                        num[i - 1] = num[i - 1] - 1;
                        sum = sum - 2;
                        if (num[i - 1] == 1) i = i - 2;
                    }
                }else {
                    while (sum != k+1) {
                        num[i - 1] = num[i - 1] - 1;
                        sum = sum - 2;
                        if (num[i - 1] == 1) i = i - 2;
                    }
                    num[0] = num[0] + 1;
                }
//            //验算
//            sum = 0;
//            for (int j = 1; j < n; j++) {
//                sum += Math.abs(num[j]-num[j-1]);
//            }
//            System.out.println(sum);
                for (int j = 0; j < n; j++) {
                    System.out.print(num[j] + " ");
                }
        }
    }



}
