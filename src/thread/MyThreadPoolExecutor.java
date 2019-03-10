/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: MyThreadPoolExecutor
 * Author:   pengweiqiang
 * Date:     2019/3/8 14:37
 * Description: 自定义线程池
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义线程池〉
 *
 * @author pengweiqiang
 * @create 2019/3/8
 * @since 1.0.0
 */
public class MyThreadPoolExecutor {

    public void testThreadPoolExecutor(){


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,3,
                60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(1));


        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" 1 "+ Thread.currentThread().getName());
            }
        });



        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("  2 "+Thread.currentThread().getName());
            }
        });


        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("  3 "+Thread.currentThread().getName());
            }
        });

        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("  4 "+Thread.currentThread().getName());
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("  5 "+Thread.currentThread().getName());
            }
        });
    }

    public static void main(String[] args) {
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor();
        myThreadPoolExecutor.testThreadPoolExecutor();
    }


}