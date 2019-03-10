/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: CountDownLatchDemo
 * Author:   pengweiqiang
 * Date:     2019/3/8 15:32
 * Description: Java.util.concurrent
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package juc;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Java.util.concurrent(J.U.C)〉
 *
 * @author pengweiqiang
 * @create 2019/3/8
 * @since 1.0.0
 */
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException{
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(5);

        ExecutorService executorService =
                new ThreadPoolExecutor
                        (0,Integer.MAX_VALUE,60L,TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        for(int i =0 ;i<totalThread;i++){
            final int y = i;
            executorService.execute(()->{
                try {
                    Thread.sleep(y*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("run ..."+ y +"   "+Thread.currentThread().getName()+"   count="+countDownLatch.getCount());
                countDownLatch.countDown();
            });
        }
        System.out.println("start");
        countDownLatch.await();

        System.out.println("end");
        executorService.shutdown();

    }
}