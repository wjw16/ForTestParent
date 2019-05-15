import java.util.Date;

/**
 * @author wenjianwu
 * @date 2019/1/24 0024 下午 6:25
 */

public class ThreadLoacalExample {
    public  static  void main(String[] args) {
        ThreadLocal tl = new ThreadLocal();
        Thread thread1 = new Thread() {
            public void run() {
                tl.set(Thread.currentThread().getName());
                tl.set(new Date());
                System.out.println(tl.get());
            }
        };
        thread1.setName("aa");
        thread1.start();
        tl.set(Thread.currentThread().getName());
       // tl.set(this.getClass());
        System.out.println(tl.get());
    }
}
