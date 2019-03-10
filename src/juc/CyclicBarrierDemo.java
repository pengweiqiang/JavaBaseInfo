/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: CyclicBarrierDemo
 * Author:   pengweiqiang
 * Date:     2019/3/8 16:51
 * Description: CyclicBarrierDemo
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package juc;

import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br> 
 * 〈CyclicBarrierDemo〉
 *
 * @author pengweiqiang
 * @create 2019/3/8
 * @since 1.0.0
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"  run");
            }
        });

        ExecutorService executorService = new ThreadPoolExecutor
                (0,Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        for(int i = 0 ;i<totalThread;i++){
            executorService.execute(()->{
                System.out.println("before..."+Thread.currentThread().getName());




                    try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after..."+Thread.currentThread().getName());
            });
        }
        executorService.shutdown();

    }

}