/**
 * @author wenjianwu
 * @date 2019/1/24 0024 下午 4:31
 */

public class Portal {
    public  static  void main(String[] args){
        testThread();
    }

    public static   void testThread(){
        ThreadExample t1=new ThreadExample("t1");
        ThreadExample t2=new ThreadExample("t2");
        t1.start();
        t2.start();
    }
    public static   void testRunable(){
        RunableExample rb=new RunableExample("r1");
        new Thread(rb).start();
        new Thread(rb).start();
    }
}
