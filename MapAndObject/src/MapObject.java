import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wenjianwu
 * @date 2019/3/11 0011 上午 10:28
 */

public class MapObject {
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
        if (map == null)
            return null;

        Object obj = beanClass.newInstance();

        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
                continue;
            }

            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }

        return obj;
    }

    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if(obj == null){
            return null;
        }

        Map<String, Object> map = new HashMap<String, Object>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }

        return map;
    }

    /**
     * map 列表转化为对象列表
     * @param mapList
     * @param obj
     * @return
     */
   public  static <T> List<T> MapListToObjList(List<Map> mapList, Class<T> obj){
        List<T> tList=new ArrayList<T>();
        for(Map map:mapList){
            try {
                T t=(T)mapToObject(map,obj);
                tList.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return  tList;
   }
}
