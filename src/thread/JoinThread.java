/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: JoinThread
 * Author:   pengweiqiang
 * Date:     2019/3/8 11:13
 * Description: Join
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package thread;

/**
 * 〈一句话功能简述〉<br> 
 * 〈Join〉
 *
 * @author pengweiqiang
 * @create 2019/3/8
 * @since 1.0.0
 */
public class JoinThread {

    class AThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("A");
        }
    }

    class BThread extends Thread{
        private AThread a ;

        BThread(AThread a){
            this.a = a;
        }

        @Override
        public void run() {
            super.run();
            try {
                a.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }

    public void testJoin(){
        AThread aThread = new AThread();
        BThread bThread = new BThread(aThread);
        bThread.start();
        aThread.start();
    }

    public static void main(String[] args) {
        JoinThread joinThread = new JoinThread();
        joinThread.testJoin();
    }

}