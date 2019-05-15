import java.util.Date;

/**
 * @author wenjianwu
 * @date 2019/3/18 0018 下午 6:43
 */

public class Portal {
    public  static  void main(String[] args){
        String dataStr="2018-2-4 14:30:33";

        Date dt=DateUtil.getStartDate(dataStr);
        System.out.println(dt.toString());

    }
}
