/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: AwaitSignalDemo
 * Author:   pengweiqiang
 * Date:     2019/3/8 12:51
 * Description: Await、signal、signalAll线程之间的协调
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Await、signal、signalAll线程之间的协调〉
 *
 * @author pengweiqiang
 * @create 2019/3/8
 * @since 1.0.0
 */
public class AwaitSignalDemo {
    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void before(){
        lock.lock();

        try{
            System.out.println("before");
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public void after(){
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalDemo awaitSignalDemo = new AwaitSignalDemo();
        executorService.execute(()->awaitSignalDemo.after());
        executorService.execute(()->awaitSignalDemo.before());
    }

}