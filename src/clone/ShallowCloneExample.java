/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: ShallowCloneExample
 * Author:   pengweiqiang
 * Date:     2019/1/29 16:04
 * Description: 浅拷贝
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package clone;

/**
 * 〈一句话功能简述〉<br> 
 * 〈浅拷贝〉
 *
 * @author pengweiqiang
 * @create 2019/1/29
 * @since 1.0.0
 */
public class ShallowCloneExample implements Cloneable{

    private int []arr;
    public ShallowCloneExample(){
        arr = new int[10];
        for(int i =0;i<arr.length;i++){
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
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        ShallowCloneExample shallowCloneExample = new ShallowCloneExample();
        return shallowCloneExample;
//        return (ShallowCloneExample) super.clone();
    }

    public static void main(String []args){
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;

        try {
            e2 = e1.clone();
            System.out.println(e1.toString()+"  "+e2.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2,222);
        System.out.println(e2.get(2));
    }
}