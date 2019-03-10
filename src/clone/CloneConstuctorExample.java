/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: CloneConstuctorExample
 * Author:   pengweiqiang
 * Date:     2019/1/29 17:04
 * Description: 构造函数拷贝
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package clone;

/**
 * 〈一句话功能简述〉<br> 
 * 〈构造函数拷贝〉
 *
 * @author pengweiqiang
 * @create 2019/1/29
 * @since 1.0.0
 */
public class CloneConstuctorExample {
    private int []arr;

    public CloneConstuctorExample(){
        arr = new int [10];
        for(int i =0;i<arr.length;i++){
            arr[i] = i;
        }
    }


    public CloneConstuctorExample(CloneConstuctorExample original){
        arr = new int [original.arr.length];
        for(int i =0;i<arr.length;i++){
            arr[i] = original.arr[i];
        }
    }

    public void set(int index,int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    public static void main(String[]args){
        CloneConstuctorExample c1 = new CloneConstuctorExample();
        CloneConstuctorExample c2 = new CloneConstuctorExample(c1);
        System.out.println(c1+"  "+c2);
        c1.set(2,222);
        System.out.println(c2.get(2));
    }
}