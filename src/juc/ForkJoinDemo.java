/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: ForkJoinDemo
 * Author:   pengweiqiang
 * Date:     2019/3/10 12:25
 * Description: 分裂和合并ForkJoin
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * 〈一句话功能简述〉<br> 
 * 〈分裂和合并ForkJoin〉
 *
 * @author pengweiqiang
 * @create 2019/3/10
 * @since 1.0.0
 */
public class ForkJoinDemo extends RecursiveTask<Integer>{

    private final int threshold = 5;
    private int first ;
    private int last;

    public ForkJoinDemo(int first,int last){
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if(last - first <= threshold){
            //任务足够小则直接计算
            for (int i = first;i <= last ;i++){
                result += i;
            }
        }else{
            //拆分成小任务
            int middle = first +(last-first) /2;
            ForkJoinDemo leftTask = new ForkJoinDemo(first,middle);
            ForkJoinDemo rightTask = new ForkJoinDemo(middle + 1,last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join() + rightTask.join();
        }

        return result;
    }

    public static void main(String[] args) throws ExecutionException,InterruptedException{
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1,10000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future result = forkJoinPool.submit(forkJoinDemo);
        System.out.println(result.get());
    }
}