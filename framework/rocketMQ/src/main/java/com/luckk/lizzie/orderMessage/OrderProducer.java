package com.luckk.lizzie.orderMessage;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@Slf4j
public class OrderProducer {
    public static void main(String[] args) throws UnsupportedEncodingException, MQClientException {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
//            producer.setNamesrvAddr("192.168.232.128:9876");
            producer.start();

            for (int i = 0; i < 10; i++) {
                int orderId = i;

                for(int j = 0 ; j <= 5 ; j ++){
                    Message msg =
                            new Message("OrderTopicTest", "order_"+orderId, "KEY" + orderId,
                                    ("order_"+orderId+" step " + j).getBytes(RemotingHelper.DEFAULT_CHARSET));
                    // MessageQueueSelector 把消息存入同一个topic的同一个queue队列，让消费者对每个queue消费时局部有序
                    // 光靠生产者也不能完成
                    SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                        @Override
                        public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                            Integer id = (Integer) arg; //根据orderId选择合适的MessageQueue进行发送
                            int index = id % mqs.size();
                            return mqs.get(index);
                        }
                    }, orderId);

                    System.out.printf("%s%n", sendResult);
                }
            }

            producer.shutdown();
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
