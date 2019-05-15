import jdk.internal.dynalink.beans.StaticClass;

/**
 * @author wenjianwu
 * @date 2019/1/25 0025 上午 10:20
 */

public class Portal {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    static class InnerS{
        public  String  iName="static";
        public  static  String sName="静态类静态名字";
        public String getiName() {
            return iName;
        }

        public void setiName(String iName) {
            this.iName = iName;
        }
    }
   class InnerG{
        public  String iName="general";

       public String getiName() {
           return iName;
       }

       public void setiName(String iName) {
           this.iName = iName;
       }
   }
   public  static void main(String[] args){
        Portal portal=new Portal();
        System.out.println("开始测试静态内部类..................");
        InnerS innerS=new Portal.InnerS();
        System.out.println(innerS.iName);
        System.out.println(InnerS.sName);
        System.out.println("开始测试普通类....................");
        InnerG innerG=new Portal().new InnerG();
        System.out.println(innerG.iName);
   }
}
