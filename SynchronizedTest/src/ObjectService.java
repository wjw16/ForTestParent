import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wenjianwu
 * @date 2019/1/28 0028 上午 10:01
 */

public class ObjectService {
    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end   time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("B begin time=" + System.currentTimeMillis());
            System.out.println("B end   time=" + System.currentTimeMillis());
        }
    }
    public void objectMethodA(){
        System.out.println("run----objectMethodA");
    }
    public void objectMethodB(){
        synchronized (this) {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("synchronized thread name:"+Thread.currentThread().getName()+"-->i="+i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


class ThreadA extends Thread {
   String methodName;
   ObjectService objectService=null;
   public  ThreadA(String methodName,ObjectService objectService){
       this.methodName=methodName;
       this.objectService=objectService;
   }

    @Override
    public void run() {
        try {
            Method md=objectService.getClass().getMethod(methodName);
            md.invoke(objectService);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
class ThreadB extends Thread {
    String methodName;
    ObjectService objectService;
    public  ThreadB(String methodName,ObjectService objectService){
        this.methodName=methodName;
        this.objectService=objectService;
    }
    @Override
    public void run() {
        Class<?> userClass=null;
        try {
            Method md=objectService.getClass().getMethod(methodName);
            md.invoke(objectService);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
    private String lock=new String();
    public void methodA(){
        try {
            synchronized (lock) {
                System.out.println("a begin");
                Thread.sleep(3000);
                System.out.println("a   end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void methodB(){
        System.out.println("b begin");
        System.out.println("b   end");
    }
    public void lockClassMethodA(){
        try {
            synchronized (ObjectService.class) {
                System.out.println("methodA begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("methodA end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void lockClassMethodB(){
        synchronized (ObjectService.class) {
            System.out.println("methodB begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            System.out.println("methodB end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
        }
    }


public static  void testThis(){
    ObjectService service = new ObjectService();
    ThreadA a = new ObjectService().new ThreadA("serviceMethodA",service);
    a.setName("a");
    a.start();
    ThreadB b = new ObjectService().new ThreadB("serviceMethodB",service);
    b.setName("b");
    b.start();
}
public static  void testOneThis(){
    ObjectService service = new ObjectService();

    ThreadB b = new ObjectService().new ThreadB("objectMethodB",service);
    b.setName("b");
    b.start();
    ThreadA a = new ObjectService().new ThreadA("objectMethodA",service);
    a.setName("a");
    a.start();
}
    public static  void testLockField(){
        ObjectService service = new ObjectService();

        ThreadB b = new ObjectService().new ThreadB("methodA",service);
        b.setName("b");
        b.start();
        ThreadA a = new ObjectService().new ThreadA("methodB",service);
        a.setName("a");
        a.start();
    }
    public static  void testLockClass(){
        ObjectService service = new ObjectService();
        ThreadB b = new ObjectService().new ThreadB("lockClassMethodA",service);
        b.setName("b");
        b.start();
        ThreadA a = new ObjectService().new ThreadA("lockClassMethodB",service);
        a.setName("a");
        a.start();
    }


    public static void main(String[] args) {
        //锁this可以同步，锁也可以在定义方法时写
         //testThis();
        //一个用锁,一个不用，不可以同步
         //testOneThis();
        //锁变量,锁this 不可以同步
        //testLockField();
          testLockClass();
    }
}

