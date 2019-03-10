/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: SynchronizedThread
 * Author:   pengweiqiang
 * Date:     2019/3/7 17:12
 * Description: 同步
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈同步〉
 *
 * @author pengweiqiang
 * @create 2019/3/7
 * @since 1.0.0
 */
public class SynchronizedThread {

    public void func1(){
        synchronized(this){
            for(int i =0 ;i<10;i++){
                System.out.println(i+" func1 ");
            }
        }
    }

    public void func11(){
        for(int i =0 ;i<10;i++){
            System.out.println(i+" func11 ");
        }
    }

    public synchronized void func2(){
        for(int i =0 ;i<10;i++){
            System.out.println(" func2 "+i);
        }
    }

    public void func3(){
        synchronized(SynchronizedThread.class){
            for(int i =0;i<10;i++){
                System.out.println("  func3 "+i);
            }
        }
    }


    public static void main(String[] args) {
        SynchronizedThread synchronizedThread = new SynchronizedThread();
        SynchronizedThread synchronizedThread2 = new SynchronizedThread();
        ExecutorService executorService = Executors.newCachedThreadPool();
//        Future future = executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("123");
//            }
//        });
//        future.cancel(true)
        executorService.execute(() -> synchronizedThread.func1());
        executorService.execute(()->synchronizedThread.func11());
    }

}