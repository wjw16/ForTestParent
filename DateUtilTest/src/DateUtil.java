import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wenjianwu
 * @date 2019/3/18 0018 下午 6:43
 */

public class DateUtil {

        public static Date strToDateLong(String strDate) {
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
               ParsePosition pos = new ParsePosition(0);
                Date strtodate = formatter.parse(strDate, pos);
                return strtodate;
     }
    public static Date getStartDate(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
   public  static  Date getStartDate(String startDate){
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       Date sd=null;
       try {
           sd=formatter.parse(startDate);
       } catch (ParseException e) {
           e.printStackTrace();
       }
       return  getStartDate(sd);
   }
}

