package zhouyang;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @FileName: CompareSyncAsync
 * @Author: LuckKun
 * @Email: 1546165200@qq.com
 * @Date: 2021/10/20 15:23
 */

/**
 * 大数据同步和异步处理的比较
 * 模拟从各大网络商城爬取某个商品的价格
 * 借此学习lambda表达式的使用和java 流式编程
 */
public class CompareSyncAsync
{
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("tmall"),
            new NetMall("pdd"),
            new NetMall("mi")
    );

    /**
     * 采用同步的方式获取某个商品的价格
     * @param list
     * @param productName
     * @return
     */
    public static List<String> findPriceSync(List<NetMall> list,String productName)
    {
        return list.stream()
                .map(mall -> String.format(productName+" %s price is %.2f",mall.getNetMallName(),mall.getPriceByName(productName)))
                .collect(Collectors.toList());
    }

    /**
     * 采用异步的方式获取商品价格
     * @param list
     * @param productName
     * @return
     */
    public static List<String> findPriceASync(List<NetMall> list,String productName)
    {
        //流式编程
        //CompletableFuture开始异步任务爬取商品价格
        //CompletableFuture::join用于获取CompletableFuture任务完成后的结果
        return list.stream()
                .map(mall -> CompletableFuture.supplyAsync(() -> String.format(productName + " %s price is %.2f", mall.getNetMallName(), mall.getPriceByName(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
    }


    /**
     * 从结果来看，异步的方式比同步的方式快了约3倍
     * @param args
     */
    public static void main(String[] args)
    {
        //测试同步方法耗费的时间
        long startTime = System.currentTimeMillis();
        List<String> list1 = findPriceSync(list, "thinking in java");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        //----costTime: 4184 毫秒
        System.out.println("----costTime: "+(endTime - startTime) +" 毫秒");
        //测试异步方法耗费的时间
        long startTime2 = System.currentTimeMillis();
        List<String> list2 = findPriceASync(list, "thinking in java");
        for (String element : list2) {
            System.out.println(element);
        }
        long endTime2 = System.currentTimeMillis();
        //----costTime: 1019 毫秒
        System.out.println("----costTime: "+(endTime2 - startTime2) +" 毫秒");

    }
}

/**
 * NetMall用于模拟商城
 */
class NetMall
{
    private String netMallName;


    public String getNetMallName() {
        return netMallName;
    }

    public void setNetMallName(String netMallName) {
        this.netMallName = netMallName;
    }

    public NetMall(String netMallName)
    {
        this.netMallName = netMallName;
    }

    public double getPriceByName(String productName)
    {
        return calcPrice(productName);
    }

    /**
     * 模拟爬取商品价格
     * @param productName
     * @return
     */
    private double calcPrice(String productName)
    {
        // 简单起见，设置1s作为爬取的间隔
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        return ThreadLocalRandom.current().nextDouble() + productName.charAt(0);
    }
}