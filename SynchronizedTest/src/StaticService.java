import jdk.internal.dynalink.beans.StaticClass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.locks.Lock;

/**
 * @author wenjianwu
 * @date 2019/1/28 0028 下午 3:47
 */

public class StaticService {
    public synchronized   static  void methodA(){
          System.out.println("A开始........");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A结束........");
    }
    public synchronized   static  void methodB(){
        System.out.println("B开始........");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B结束........");
    }
    public    static  void lockClassMethodA(){
        synchronized (StaticClass.class){
        System.out.println("A开始........");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A结束........");
        }
    }
    public    static  void lockClassMethodB(){
        synchronized (StaticClass.class) {
            System.out.println("B开始........");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B结束........");
        }
    }
    class ThreadA extends  Thread{
        String methodName;
        public  ThreadA(String methodName){
            this.methodName=methodName;
        }
        @Override
        public void run() {
            super.run();
            try {
                Class<?>  methodClass=Class.forName("StaticService");
                Method method=methodClass.getMethod(methodName);
                method.invoke(null);
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
    class ThreadB extends  Thread{
        String methodName;
        public  ThreadB(String methodName){
            this.methodName=methodName;
        }
        @Override
        public void run() {
            try {
                Class<?>  methodClass=Class.forName("StaticService");
                Method method=methodClass.getMethod(methodName);
                method.invoke(null);
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
    class LockClassThreadA extends  Thread{
        @Override
        public void run() {
            super.run();
            StaticService.lockClassMethodA();
        }
    }
    class LockClassThreadB extends  Thread{
        @Override
        public void run() {
            super.run();
           StaticService.lockClassMethodB();
        }
    }
    public  static  void testlockMethod(){
        ThreadA ta=new StaticService().new ThreadA("methodA");
        ThreadB tb=new StaticService().new ThreadB("methodB");
        ta.start();
        tb.start();
    }
    public  static  void testLockClass(){
        ThreadA ta=new StaticService().new ThreadA("lockClassMethodA");
        ThreadB tb=new StaticService().new ThreadB("lockClassMethodB");
        ta.start();
        tb.start();
    }
    public  static  void main(String[] args){
        //静态方法加锁，都加锁才可以同步
        //testlockMethod();
        //类加锁，都加锁才可以同步
        testLockClass();
    }
}
