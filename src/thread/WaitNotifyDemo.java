/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: WaitNotifyDemo
 * Author:   pengweiqiang
 * Date:     2019/3/8 12:22
 * Description: Wait、Notify使用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Wait、Notify使用〉
 *
 * @author pengweiqiang
 * @create 2019/3/8
 * @since 1.0.0
 */
public class WaitNotifyDemo {

    public synchronized void before(){
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyDemo waitNotifyDemo = new WaitNotifyDemo();
        executorService.execute(() ->waitNotifyDemo.after());
        executorService.execute(() ->waitNotifyDemo.before());
    }

}