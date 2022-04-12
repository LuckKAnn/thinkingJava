package zhouyang;

import java.util.concurrent.*;

/**
 * @FileName: CompletableFutureAPIDemo
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/20 15:47
 */
public class CompletableFutureAPIDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 20, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()
                , Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> 100).thenApply(num -> num + " to String");
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> 100).thenCompose(num -> CompletableFuture.supplyAsync(() -> num + " to String"));

        System.out.println(f1.join()); // 100 to String
        System.out.println(f2.join()); // 100 to String

        StringBuilder sb = new StringBuilder();

    }
}
