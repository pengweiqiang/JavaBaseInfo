/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: ReentrantLockDemo
 * Author:   pengweiqiang
 * Date:     2019/3/7 18:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 * ReentrantLock 是java.util.concurrent(J.U.C)包中的锁
 *
 * @author pengweiqiang
 * @create 2019/3/7
 * @since 1.0.0
 */
public class ReentrantLockDemo {

    private Lock lock = new ReentrantLock();

    public void func(){
        lock.lock();
        try{
            for(int i =0 ;i<10;i++){
                System.out.println(" " +i);
            }

        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
            lock.unlock();//确保释放锁，从而避免发生死锁。
        }

    }

    public void func2(){
        try{
            for(int i =0 ;i<10;i++){
                System.out.println(" func 2" +i);
            }

        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("finally");
        }

    }

    public static void main(String[] args) {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        ReentrantLockDemo reentrantLockDemo2 = new ReentrantLockDemo();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> reentrantLockDemo.func());
        executorService.execute(() -> reentrantLockDemo.func2());
    }
}