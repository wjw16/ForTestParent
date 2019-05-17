import java.util.Date;

/**
 * @CopyRight : 华润河南医药有限公司
 * @Version:1.0
 * @Author wenjianwu
 * @Datetime 2019-05-17 09:36
 * @Modor wenjianwu
 * @ModDesc
 */
public class TestClass {
    private int id;
    private String name;
    private Date createDate;
    private String uEmail;
    public  TestClass(){
        this.setId(0);
        this.setName("wjw");
        this.setCreateDate(new Date());
        this.setuEmail("www@test.com");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }
}
