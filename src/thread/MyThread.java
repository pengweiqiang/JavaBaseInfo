/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: MyThread
 * Author:   pengweiqiang
 * Date:     2019/3/6 14:12
 * Description: 线程相关
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread;


/**
 * 〈一句话功能简述〉<br> 
 * 〈线程相关〉
 *
 * @author pengweiqiang
 * @create 2019/3/6
 * @since 1.0.0
 */
public class MyThread {



    public static void main(String[] args) {
//        Producer producer = new Producer();
//       Consumer consumer = new Consumer();
//
//       producer.setPriority(Thread.MIN_PRIORITY);
//       consumer.setPriority(Thread.MAX_PRIORITY);
//
//       producer.start();
//       consumer.start();

        Thread t = new Thread(){
            @Override
            public void run() {
                super.run();

                    System.out.println("123123");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        };

        t.start();

        t.interrupt();

    }

}

class Producer extends Thread{

    @Override
    public void run() {
        super.run();
        for(int i = 0;i<5;i++){
            System.out.println("Producer "+getId()+"   i="+i);
            Thread.yield();
        }

    }
}

class Consumer extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i = 0;i<5;i++){
            System.out.println("Consumer "+getId()+"   i="+i);
            Thread.yield();
        }
    }
}