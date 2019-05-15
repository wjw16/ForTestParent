/**
 * @author wenjianwu
 * @date 2019/1/25 0025 上午 8:11
 */

public class RunableExample implements  Runnable {
    private  int tickets=5;
    private  String name;
    public  RunableExample(String name){
        this.name=name;
    }
    @Override
    public void run() {
        synchronized(this){
        while (true){
              if(tickets<0)
                  break;
            System.out.println(this.name="->"+tickets--);
         }
        }
    }
    public static  void test(){
        RunableExample rb=new RunableExample("r1");
        new Thread(rb).start();
        new Thread(rb).start();
    }
}
