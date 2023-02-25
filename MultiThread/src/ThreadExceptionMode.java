import java.util.concurrent.*;

public class ThreadExceptionMode {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = buildThreadPoolTaskExecutor();
        executorService.execute(() -> run("execute方法"));
        Future<?> future = executorService.submit(() -> run("submit方法"));
        Object o = future.get();

    }

    private static void run(String name) {
        String printStr = "【thread-name:" + Thread.currentThread().getName() + ",执行方式:" + name + "】";
        System.out.println(printStr);
        throw new RuntimeException(printStr + ",出现异常");
    }

    private static ThreadPoolExecutor buildThreadPoolTaskExecutor() {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                5,
                10,
                1000,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy());
//        executorService.setThreadNamePrefix("(小罗技术笔记)-");
//        executorService.setCorePoolSize(5);
//        executorService.setMaxPoolSize(10);
//        executorService.setQueueCapacity(100);
//        executorService.setKeepAliveSeconds(10);
//        executorService.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        executorService.initialize();
        return executorService;
    }
}
