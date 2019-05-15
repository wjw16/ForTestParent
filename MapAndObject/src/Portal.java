import java.util.HashMap;
import  java.util.Map;
/**
 * @author wenjianwu
 * @date 2019/3/27 0027 下午 7:57
 */

public class Portal {
    public  static  void main(String[] args){
        Map map=new HashMap();
        map.put("id",1);
        map.put("name","wjw");
        try {
            Student stu=(Student) MapObject.mapToObject(map,Student.class);
            if(stu!=null)
                System.out.println(stu.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
