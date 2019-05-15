public class Main {

    public static void main(String[] args) {
       // testCastCatch();
        testDefaultValue();
    }
    public  static void testDefaultValue(){
      TestField tf=new TestField();
      System.out.println(tf.toFields());
      System.out.println(tf.getPlaceholder());
      System.out.println(tf.toValue()[0]);
    }
    public static void  testCastCatch(){
        try {
            System.out.println("开始(String)测试....................");
            Object obj = new Integer(100);
            String strVal = (String)obj;
            System.out.println(strVal);
        } catch (Exception e) {
            System.out.println("(String)转换数字失败--------------------");
            e.printStackTrace();
        }
        try {
            Object objnull = null;
            String strnull = (String)objnull;
            System.out.println(strnull);
        } catch (Exception e) {
            System.out.println("(String)转换null失败--------------------");
            e.printStackTrace();
        }
        try {
            System.out.println("开始valueOf测试....................");
            Object objof = new Integer(100);
            String strof = String.valueOf(objof);
            System.out.println(strof);
        } catch (Exception e) {
            System.out.println("valueOf转换数字失败--------------------");
            e.printStackTrace();
        }
        try {
            Object objofnull = null;
            String strofnull = String.valueOf(objofnull);
            if(strofnull==null)
                System.out.println(strofnull+"是 null");
            else if(strofnull.equals("null"))
                System.out.println(strofnull+"是 字符串 null");
            else
                System.out.println(strofnull);
        } catch (Exception e) {
            System.out.println("valueOf转换null失败--------------------");
            e.printStackTrace();
        }
        try {
            System.out.println("开始toString测试....................");
            Object objto = new Integer(100);
            String strto = objto.toString();
            System.out.println(strto);
        } catch (Exception e) {
            System.out.println("toString转换数字失败--------------------");
            e.printStackTrace();
        }
        try {
            Object objtonull = null;
            String strtonull = objtonull.toString();
            System.out.println(strtonull);
        } catch (Exception e) {
            System.out.println("toString转换null失败--------------------");
            e.printStackTrace();
        }
    }
    public  static  void testReflect(){
        SaleReturnDtlTmpBean tmpBean=new SaleReturnDtlTmpBean();
        String fields=tmpBean.toFields();
        Object []values=tmpBean.toValue();
        System.out.println(fields);
        System.out.println(values.length);
    }
}
