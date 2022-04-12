import annotation.MyAnnotation;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

@MyAnnotation
public class Main {

    public  static  CountDownLatch countDownLatch = new CountDownLatch(2);
    public  static  Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        boolean annotationPresent = Main.class.isAnnotationPresent(MyAnnotation.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        if (annotationPresent) System.out.println(df.format(new Date()));


        new HashMap<>();


    }

    public static int tesT(){
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            int x = i / 0 ;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            return i;

        }
    }
}
