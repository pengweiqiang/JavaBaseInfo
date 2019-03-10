/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: ExchangerDemo
 * Author:   pengweiqiang
 * Date:     2019/3/10 11:07
 * Description: Exchanger交换器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package juc;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Exchanger交换器〉
 *
 * @author pengweiqiang
 * @create 2019/3/10
 * @since 1.0.0
 */
public class ExchangerDemo {

    public static void main(String[] args) {
        ExchangerDemo exchangerDemo = new ExchangerDemo();
        exchangerDemo.testExchanger();
    }

    public void testExchanger(){

        Exchanger<String> exchanger = new Exchanger<String>();

        for(int i =0;i<3;i++){//3个消费者
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true){
                        try {
                            String data = exchanger.exchange(null);
                            TimeUnit.SECONDS.sleep(2);
                            if(data !=null){
                                System.out.println("[" + Thread.currentThread().getName() + "]取得数据：" + data);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            },"消费者-"+i).start();
        }


        for (int i = 0; i < 2; i++) { //2个生产者
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 2; j++) {
                        String data = "iTermis-" + temp + "-" + j;
                        try {
                            TimeUnit.SECONDS.sleep(2); //让生产者节奏放慢
                            exchanger.exchange(data);
                            System.out.println("[" + Thread.currentThread().getName() + "]生产了数据：" + data);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "生产者-" + i).start();
        }



    }

}