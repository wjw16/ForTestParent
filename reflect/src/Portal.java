import com.it.code.TestClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wenjianwu
 * @date 2019/2/27 0027 下午 7:14
 */

public class Portal {
    public static   void main(String[] args){
        testLoad();

    }
    /**
     *@Author 温建武 2019/8/20 0020 上午 9:45
     *@Desc
     *@param
     *@Return void
     */
    public  void testPgRead(){
        try {
            Class threadClazz = Class.forName("PgReadUtils");
            Object obj=new Object();
            try {
                obj=(Object) threadClazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            Method method = threadClazz.getMethod("unionInterCall", String.class,Object.class);
            Method morning=threadClazz.getMethod("morning",String.class);
            System.out.println(morning.invoke(obj,"早上好"));
            System.out.println(method.invoke(null,"aaaa" ,new HashMap()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static  void testLoad(){
        try {
            System.out.println(TestClass.class.getName());
            Class threadClazz = Class.forName("com.it.code.TestClass");

            System.out.println(Thread.currentThread().getClass());
            Class tt=Thread.currentThread().getContextClassLoader().loadClass(TestClass.class.getName());
            Object obj=new Object();
            try {
                obj=(Object) threadClazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
