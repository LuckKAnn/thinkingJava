package com.luckk.lizzie.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class SimpleProducer {

    /**
     * 同步发送消息
     * 引用场景：通知消息、短信通知、短信营销系统
     */
    public void syncSendMsg(String content) throws MQClientException, UnsupportedEncodingException, MQBrokerException, RemotingException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("defaultProducer");
        producer.setNamesrvAddr("");
        producer.start();
        Message message = new Message("topic", "tagA", ("Message " + content).getBytes(RemotingHelper.DEFAULT_CHARSET));

        SendResult sendResult = producer.send(message);
        System.out.println(sendResult);


        producer.shutdown();

    }



    /**
     * 异步发送消息
     * 使用场景：一般用于响应时间敏感的业务场景
     */
    public void asyncSendMsg() throws MQClientException, InterruptedException {
        // 1.使用生产者组名称进行实例化
        DefaultMQProducer producer = new DefaultMQProducer("defaultProducer");
        // 2.指定服务器地址
        producer.setNamesrvAddr("192.168.1.20:9876");
        // 3.启动实例
        producer.start();
        // 4.在异步模式下声明发送失败之前在内部执行的最大重试次数
        producer.setRetryTimesWhenSendAsyncFailed(0);
        int messageCount = 50;
        // 5.计数初始化
        final CountDownLatch countDownLatch = new CountDownLatch(messageCount);
        for (int i = 0; i < messageCount; i++) {
            try {
                final int index = i;
                Message msg = new Message("TopicTest",
                        "TagA",
                        "OrderID188",
                        "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
                // 发送消息 SendCallback：发送完成时执行的回调，成功或不成功
                producer.send(msg, new SendCallback() {
                    // 成功
                    @Override
                    public void onSuccess(SendResult sendResult) {
                        // 递减锁存器的计数，如果计数达到零，则释放所有等待的线程
                        countDownLatch.countDown();
                        System.out.printf("%-10d OK %s %n", index, sendResult.getMsgId());
                    }
                    // 失败
                    @Override
                    public void onException(Throwable e) {
                        // 递减锁存器的计数，如果计数达到零，则释放所有等待的线程
                        countDownLatch.countDown();
                        System.out.printf("%-10d Exception %s %n", index, e);
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 等待子线程运行结束
        countDownLatch.await(5, TimeUnit.SECONDS);
        // 一旦生产者实例不再使用，就关闭它
        producer.shutdown();
    }

    /**
     * 单项发送消息
     * 使用场景：日志收集。
     */
    public void oneWaySendMsg() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException {
        // 1.使用生产者组名称进行实例化
        DefaultMQProducer producer = new DefaultMQProducer("defaultProducer");
        // 2.指定服务器地址
        producer.setNamesrvAddr("192.168.1.20:9876");
        // 3.启动实例
        producer.start();
        for (int i = 0; i < 100; i++) {
            // 创建一个消息实例，指定主题、标记和消息主体
            Message msg = new Message("TopicTest" /* Topic 主题*/,
                    "TagA" /* Tag 版本*/,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body 消息主体*/
            );
            // 调用发送消息将消息传递到其中一个代理。
            producer.sendOneway(msg);
        }
        // 4. 等待发送完成
        Thread.sleep(5000);
        producer.shutdown();
    }
}
