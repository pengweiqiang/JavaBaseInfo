/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: ArrayList
 * Author:   pengweiqiang
 * Date:     2019/2/28 15:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package collection;

import java.util.Collections;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author pengweiqiang
 * @create 2019/2/28
 * @since 1.0.0
 */
public class ArrayList {

    private static final int DEFAULT_CAPACITY = 10;

    public void grow(){
        //位运算，进行原来容量的1.5倍
        int newCapacity = DEFAULT_CAPACITY + (DEFAULT_CAPACITY >> 1);
        System.out.println(newCapacity);

    }

    public List getSynchornizedList(){
        List<String> list = new java.util.ArrayList<>();
        List<String> sysList = Collections.synchronizedList(list);
        return sysList;
    }

    public static void main(String []args){
        ArrayList a = new ArrayList();
        a.grow();

    }

}