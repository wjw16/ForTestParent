import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @CopyRight : 华润河南医药有限公司
 * @Version:1.0
 * @Author wenjianwu
 * @Datetime 2019-05-17 09:34
 * @Modor wenjianwu
 * @ModDesc
 */
public class Portal {
    public  static  void main(String []args){
        TestClass tc=new TestClass();
        String tsStr=JSON.toJSONString(tc);
        String dateStr=JSON.toJSONStringWithDateFormat(tc,"yyyy-MM-dd HH:mm:ss",
                SerializerFeature.WriteDateUseDateFormat);
        System.out.println(tsStr);
        System.out.println(dateStr);
    }
}
