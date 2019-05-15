/**
 * @author wenjianwu
 * @date 2019/2/28 0028 上午 8:29
 */

public class RealObjeect implements  ProxyInterface {
    @Override
    public void say() {
        System.out.println("我是被代理者");
    }
}
