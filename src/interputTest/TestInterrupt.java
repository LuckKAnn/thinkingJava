package interputTest;

/**
 * @FileName: TestInterrupt
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2022/3/18 10:14
 */
public class TestInterrupt {


    public static void main(String[] args) {
        MyJob02 myRunnable=new MyJob02();
        Thread thread=new Thread(myRunnable,"子线程");
        thread.start();
        try{
            //主线程休眠
            Thread.sleep(100);
            //调用中断，true
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class MyJob implements  Runnable{

    @Override
    public void run() {
        int i=0;
        while(true){
            System.out.println(Thread.currentThread().getName()+"循环第"+ ++i+"次");
            try{
                //判断线程的中断情况
                boolean interruptStatus=Thread.currentThread().isInterrupted();
                System.out.println(Thread.currentThread().getName()+"循环第"+ ++i+"次"+interruptStatus);
                Thread.sleep(1000);
                //非阻塞中断 只是设置标记位true
                //非阻塞中断 只是设置标记位true
                if(interruptStatus){
                    //如果中断为true则退出
                    //break;
                    return;
                }
            } catch (InterruptedException e) {

                // 一个线程在运行状态中，其中断标志被设置为true之后，一旦线程调用了
                // wait、join、sleep方法中的一种，立马抛出一个InterruptedException，且中断标志被程序会自动清除，重新设置为false
                System.out.println("阻塞中断"+Thread.currentThread().isInterrupted());//显示false并抛异常
                return;//不想返回还可继续写代码
            }
        }
    }
}
class MyJob02 implements  Runnable{

    @Override
    public void run() {
        int i=0;
        while(true){
            System.out.println(Thread.currentThread().getName()+"循环第"+ ++i+"次");

            //判断线程的中断情况
            boolean interruptStatus=Thread.currentThread().isInterrupted();
            System.out.println(Thread.currentThread().getName()+"循环第"+ ++i+"次"+interruptStatus);
            //非阻塞中断 只是设置标记位true
            //非阻塞中断 只是设置标记位true
            if(interruptStatus){
                //如果中断为true则退出
                //break;
                System.out.println("end");
                System.exit(0);
            }

        }
    }
}
