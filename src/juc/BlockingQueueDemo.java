/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: BlockingQueueDemo
 * Author:   pengweiqiang
 * Date:     2019/3/10 12:06
 * Description: 阻塞队列
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈阻塞队列〉
 *
 * @author pengweiqiang
 * @create 2019/3/10
 * @since 1.0.0
 */
public class BlockingQueueDemo {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producer extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                queue.put("product "+Thread.currentThread().getId());
                System.out.println("produce.."+Thread.currentThread().getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                String product = queue.take();
                System.out.println("consume.."+"  product="+product);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer();
            producer.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer();
            producer.start();
        }
    }
}