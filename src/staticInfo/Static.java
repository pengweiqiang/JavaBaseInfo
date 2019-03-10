/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: Static
 * Author:   pengweiqiang
 * Date:     2019/1/29 17:39
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package staticInfo;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author pengweiqiang
 * @create 2019/1/29
 * @since 1.0.0
 */
public class Static {
    static {
        System.out.println("static init");
    }

    public static void main(String []args){
        System.out.println("main");
        Static s = new Static();
        Static s2 = new Static();
    }
}