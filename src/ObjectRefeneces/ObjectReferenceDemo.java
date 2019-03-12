/**
 * Copyright (C), 2012-2019, www.shopin.net
 * FileName: ObjectReferenceDemo
 * Author:   pengweiqiang
 * Date:     2019/3/11 15:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package ObjectRefeneces;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * 〈一句话功能简述〉<br> 
 * 〈引用类型〉
 *
 * @author pengweiqiang
 * @create 2019/3/11
 * @since 1.0.0
 */
public class ObjectReferenceDemo {

    public void init(){
        //强引用
        Object objStrong = new Object();

        //软引用
        Object objSoft = new Object();
        SoftReference<Object> sf = new SoftReference<>(objSoft);
        objSoft = null;

        //弱引用
        Object objWeak = new Object();
        WeakReference<Object> wf = new WeakReference<>(objWeak);
        objWeak = null;

        //虚拟用
        Object objPhan = new Object();
        PhantomReference<Object> pf = new PhantomReference<Object>(objPhan,new ReferenceQueue <>());
        objPhan = null;
    }

}