/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: ThreadUnsafeDemo
 * Author:   pengweiqiang
 * Date:     2019/3/10 14:11
 * Description: 线程不安全示例
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package juc;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 〈一句话功能简述〉<br> 
 * 〈线程不安全示例〉
 *
 * @author pengweiqiang
 * @create 2019/3/10
 * @since 1.0.0
 */
public class ThreadUnsafeDemo {

    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException{
        final int threadSize = 1000;
        ThreadUnsafeDemo unsafeDemo = new ThreadUnsafeDemo();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = new ThreadPoolExecutor
                (0,Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<>());
        for(int i =0;i<threadSize;i++){
            executorService.execute(()->{
                unsafeDemo.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(unsafeDemo.get());
    }


}