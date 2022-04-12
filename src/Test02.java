import java.util.*;

/**
 * @FileName: Test02
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/5 11:21
 */


enum Q1{Q1Send, Q1Recv}
enum Q2{Q2None, Q2Send, Q2Recv}

class Q3{
    int x;
    int y;
    Q3(){};
    Q3(int xx,int yy){
        this.x = xx;
        this.y = yy;
    }
}
public class Test02 {

    public  void foo1(Q1 q){
        System.out.println(q);

        switch (q){
            case Q1Send: f();break;
            //case Q2Recv: g();break;
        }

    }
    public  void foo1(Q3 q){
        System.out.println(q);

        //switch (q){
        //    case x: f();break;;
        //    case y: g();break;
        //}

    }
    public void f(){
        System.out.println("method f");
    }


    public void g(){
        System.out.println("method g");
    }
    public static void main(String[] args) {

        Q1 q  = Q1.Q1Recv;
        System.out.println(q.getClass().getName().toString());
        Test02 test02 = new Test02();



    }
}
