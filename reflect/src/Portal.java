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
}
