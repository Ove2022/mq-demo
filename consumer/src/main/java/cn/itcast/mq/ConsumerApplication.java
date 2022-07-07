package cn.itcast.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Component
    public static class SpringRabbitListener {

    /*    @RabbitListener(queues = "simple.queue")
        public void listenSimpleQueueMessage(String msg) {
            System.out.println("spring消费者接收到消息：【" + msg + "】");
        }*/

        @RabbitListener(queues = "simple.queue")
        public void listenWorkQueueMessage1(String msg) throws InterruptedException {
            System.out.println("消费者1接收到消息：【" + msg + "】"+ LocalTime.now());
            Thread.sleep(20);
        }

        @RabbitListener(queues = "simple.queue")
        public void listenWorkQueueMessage2(String msg) throws InterruptedException {
            System.err.println("消费者2........：【" + msg + "】"+ LocalTime.now());
            Thread.sleep(200);
        }
    }
}
