import javafx.beans.DefaultProperty;

/**
 * @author wenjianwu
 * @date 2019/3/27 0027 下午 8:00
 */

public class Student {
    private  int id;
    private  String name;
    private  String address;
    private  int age=0;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
