import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 往销退细单临时表插入的Bean
 */
public class SaleReturnDtlTmpBean {
    private String goodsid;
    private String goodsdtlid;
    private String goodsqty;
    private String saledtlid;
    private String lotid;
    private String batchid;
    private int usestatus=1;
    private int goodsstatusid=1;
    private String iodtlid;
    private Double unitprice;
    private Integer backwhyid;
    private Double total_line;

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsdtlid() {
        return goodsdtlid;
    }

    public void setGoodsdtlid(String goodsdtlid) {
        this.goodsdtlid = goodsdtlid;
    }

    public String getGoodsqty() {
        return goodsqty;
    }

    public void setGoodsqty(String goodsqty) {
        this.goodsqty = goodsqty;
    }

    public String getSaledtlid() {
        return saledtlid;
    }

    public void setSaledtlid(String saledtlid) {
        this.saledtlid = saledtlid;
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid;
    }

    public String getBatchid() {
        return batchid;
    }

    public void setBatchid(String batchid) {
        this.batchid = batchid;
    }

    public int getUsestatus() {
        return usestatus;
    }

    public void setUsestatus(int usestatus) {
        this.usestatus = usestatus;
    }

    public int getGoodsstatusid() {
        return goodsstatusid;
    }

    public void setGoodsstatusid(int goodsstatusid) {
        this.goodsstatusid = goodsstatusid;
    }

    public String getIodtlid() {
        return iodtlid;
    }

    public void setIodtlid(String iodtlid) {
        this.iodtlid = iodtlid;
    }

    public Double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Double unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getBackwhyid() {
        return backwhyid;
    }

    public void setBackwhyid(Integer backwhyid) {
        this.backwhyid = backwhyid;
    }

    public Double getTotal_line() {
        return total_line;
    }

    public void setTotal_line(Double total_line) {
        this.total_line = total_line;
    }
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
    public String getPlaceholder(int len){
        String placeStr="";
        for(int i=0;i<len;i++){
            placeStr=placeStr.equals("")?"?":placeStr+","+"?";
        }
        return  placeStr;
    }
    /* 根据属性名获取属性值
     * */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value;
        } catch (Exception e) {

            return null;
        }
    }

}
