/**
 * @author wenjianwu
 * @date 2019/2/28 0028 上午 8:30
 */

public class ProxyObject implements ProxyInterface {
    @Override
    public void say() {
        System.out.println("我是代理者");
        RealObjeect ro=new RealObjeect();
        ro.say();
        System.out.println("代理结束");
    }
}
