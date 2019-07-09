/**
 * @CopyRight : 华润河南医药有限公司
 * @Version:1.0
 * @Author wenjianwu
 * @Datetime 2019-07-09 10:25
 * @Modor wenjianwu
 * @ModDesc
 */
public class Portal {
    public  static  void main(String[]args){
        String a=null;
        String b="w";
        //这个会报空指针的
        if(a.equals("w"))
            System.out.println("I think it come into");
        if(!"w".equals(a)){
            System.out.println("that is different");
        }
        else if("w".equals(b)){
            System.out.println("that is same");
        }

    }
}
