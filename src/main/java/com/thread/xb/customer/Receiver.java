package com.thread.xb.customer;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.core.Message;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

@Component
@EnableAsync
//@RabbitListener(queues = "xbQueue")
public class Receiver {

//    @RabbitListener(queues = "xbQueue")
//    @RabbitHandler
    public void process(Message message, Channel channel) throws IOException {
//        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            byte[] body = message.getBody();
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(body));
            Map<String,String> msgMap = (Map<String,String>) ois.readObject();
            String messageId = msgMap.get("messageId");
            String messageData = msgMap.get("messageData");
            String createTime = msgMap.get("createTime");
            System.out.println("  Receiver  messageId:"+messageId+"  messageData:"+messageData+"  createTime:"+createTime);
            channel.basicReject(deliveryTag, true);
        }catch (Exception e){
            channel.basicReject(deliveryTag, true);
        }


//        System.out.println("DirectReceiver消费者收到消息,但是拒绝消费  : " + testMessage.toString());

    }


    @RabbitListener(queues = "lonelyQueue")
    @RabbitHandler
    public void process2(Message message, Channel channel) throws IOException {
//        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            byte[] body = message.getBody();
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(body));
            Map<String,String> msgMap = (Map<String,String>) ois.readObject();
            String messageId = msgMap.get("messageId");
            String messageData = msgMap.get("messageData");
            String createTime = msgMap.get("createTime");
            System.out.println("  Receiver  messageId:"+messageId+"  messageData:"+messageData+"  createTime:"+createTime);
            channel.basicReject(deliveryTag, true);
        }catch (Exception e){
            channel.basicReject(deliveryTag, true);
        }


//        System.out.println("DirectReceiver消费者收到消息,但是拒绝消费  : " + testMessage.toString());

    }


//    @RabbitHandler
//    public void onMessage(Map testMessage){
//        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
//    }
}
