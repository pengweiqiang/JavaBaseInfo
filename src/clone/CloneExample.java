package clone; /**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: clone.CloneExample
 * Author:   pengweiqiang
 * Date:     2019/1/29 15:59
 * Description: clone
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * 〈一句话功能简述〉<br> 
 * 〈clone〉
 *
 * @author pengweiqiang
 * @create 2019/1/29
 * @since 1.0.0
 */
public class CloneExample implements Cloneable{
    private int a;
    private int b;


    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }

    public static void main(String []args){
        CloneExample cloneExample = new CloneExample();
        System.out.println(cloneExample.toString());
        try {
            CloneExample cloneExample1 = cloneExample.clone();
            System.out.println(cloneExample1.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}