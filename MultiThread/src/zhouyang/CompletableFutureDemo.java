package zhouyang;

import java.util.concurrent.*;

/**
 * @FileName: CompletableFutureDemo
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/18 19:47
 */
public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 20, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "-----come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            System.out.println(Thread.currentThread().isDaemon());
            //暂停几秒钟线程
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
          //  System.out.println("-----计算结束耗时1秒钟，result： "+result);
            return result;
        },threadPoolExecutor).thenApply(arg->{ //前一个任务的结果作为arg参数

            return arg+2;
        }).whenComplete((v,e) ->{ //第一个是传入的参数，第二个是异常
            if(e == null)
            {
                System.out.println("-----result: "+v);
            }
        }).exceptionally(e -> {
            System.out.println("-----exception: "+e.getCause()+"\t"+e.getMessage());
            return -44;
        });

        //主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭:暂停3秒钟线程
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }


    }


    public void testCompletableFuture01() throws ExecutionException, InterruptedException{
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 20, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());


        CompletableFuture<Integer> c1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("zhe ge fang fa ti gong supplier hanshu jieko ");
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 100;
        });
        System.out.println(c1.get());


        CompletableFuture<Integer> c2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("zhe ge fang fa ti gong supplier hanshu jieko ");
            System.out.println(Thread.currentThread().getName());
            return 200;
        }, threadPoolExecutor);

        System.out.println(c2.get());
        threadPoolExecutor.shutdown();
    }
}
