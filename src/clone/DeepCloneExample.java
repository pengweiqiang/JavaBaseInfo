/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: DeepCloneExample
 * Author:   pengweiqiang
 * Date:     2019/1/29 16:56
 * Description: 深拷贝
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package clone;

/**
 * 〈一句话功能简述〉<br> 
 * 〈深拷贝〉
 *
 * @author pengweiqiang
 * @create 2019/1/29
 * @since 1.0.0
 */
public class DeepCloneExample implements Cloneable{
    private int []arr;

    public DeepCloneExample(){
        arr = new int[10];
        for(int i = 0 ;i<arr.length;i++){
            arr[i] = i;
        }
    }

    public void set(int index,int value){
        arr[index] = value;
    }

    public int get(int index){
        return arr[index];
    }

    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample deepCloneExample = (DeepCloneExample)super.clone();
        deepCloneExample.arr = new int [arr.length];
        for (int i = 0 ;i<arr.length;i++){
            deepCloneExample.arr[i] = arr[i];
        }
        return deepCloneExample;
    }

    public static void main(String[]args){
        DeepCloneExample e1 = new DeepCloneExample();
        DeepCloneExample e2 = null;

        try {
            e2 = e1.clone();
            System.out.println(e1+"   "+e2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        e1.set(2,222);
        System.out.println(e2.get(2));
    }
}