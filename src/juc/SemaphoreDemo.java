/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: SemaphoreDemo
 * Author:   pengweiqiang
 * Date:     2019/3/8 17:44
 * Description: Semaphore信号量
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package juc;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Semaphore信号量〉
 *
 * @author pengweiqiang
 * @create 2019/3/8
 * @since 1.0.0
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = new ThreadPoolExecutor(0,Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<>());

        for(int i=0;i<totalRequestCount;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+" "+semaphore.availablePermits()+"  ");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        semaphore.release();
                    }
                }
            });
        }

        executorService.shutdown();


    }

}