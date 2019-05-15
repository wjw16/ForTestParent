import java.lang.reflect.Proxy;

/**
 * @author wenjianwu
 * @date 2019/2/28 0028 上午 8:21
 */

public class ProxyPortal {
    public  static  void main(String[] args){
          consumer(new ProxyObject());
    }
    public  static  void consumer(ProxyInterface pi){
        pi.say();
    }
}
