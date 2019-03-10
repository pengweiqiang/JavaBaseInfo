/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: FutureTaskDemo
 * Author:   pengweiqiang
 * Date:     2019/3/10 11:52
 * Description: FutureTask类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 〈一句话功能简述〉<br> 
 * 〈FutureTask类〉
 *
 * @author pengweiqiang
 * @create 2019/3/10
 * @since 1.0.0
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws InterruptedException,ExecutionException{

        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0 ;
                for(int i =0 ;i<100;i++){
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        Thread otherThread = new Thread(()->{
            System.out.println("other task is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        otherThread.start();

        System.out.println(futureTask.get());
        System.out.println("end...");

    }
}