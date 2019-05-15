import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author wenjianwu
 * @date 2018/12/20 0020 上午 9:19
 */

public abstract class BaseGetInfoBean {
    public String toFields(){
        Field[] fields = this.getClass().getDeclaredFields();
        String fls="";
        for (Field fl:fields) {
            fls=fls.equals("")?fl.getName().toUpperCase():fls+","+fl.getName().toUpperCase();
        }
        return  fls;
    }
    public   Object[] toValue(){
        Field[] fields = this.getClass().getDeclaredFields();
        Object[] values=new Object[fields.length];
        for (int i=0;i<fields.length;i++) {
            Field fl=fields[i];
            Object fl_value = getFieldValueByName(fl.getName(), this);
            values[i]=fl_value;
        }
        return  values;
    }
    public String getPlaceholder(){
        int len =this.getClass().getDeclaredFields().length;
        String placeStr="";
        for(int i=0;i<len;i++){
            placeStr=placeStr.equals("")?"?":placeStr+","+"?";
        }
        return  placeStr;
    }
    /* 根据属性名获取属性值
     * */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Object toValueString(){
        Field[] fields = this.getClass().getDeclaredFields();
        Object values=null;
        for (int i=0;i<fields.length;i++) {
            Field fl=fields[i];
            Object fl_value = getFieldValueByName(fl.getName(), this);
            values=values==null?fl_value:values+","+fl_value;
        }
        return  values;
    }
}

