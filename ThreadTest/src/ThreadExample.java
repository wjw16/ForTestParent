/**
 * @author wenjianwu
 * @date 2019/1/24 0024 下午 4:32
 */

public class ThreadExample extends  Thread {
    private  String name;
    public  ThreadExample(String name){
        this.name=name;
    }
    private  int tickets=5;
    @Override
    public void run() {
      while (true){
          if(tickets<0)
              break;
            System.out.println(this.name+"->"+tickets--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public  static  void main(String [] args){
        ThreadExample t1=new ThreadExample("t1");
        ThreadExample t2=new ThreadExample("t2");
        t1.start();
        t2.start();
    }
}
