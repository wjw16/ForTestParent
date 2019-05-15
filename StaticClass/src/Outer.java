import java.lang.annotation.Retention;

/**
 * @author wenjianwu
 * @date 2019/1/25 0025 上午 10:42
 */

public class Outer {
    private String name;
    private int age;

    public static class Builder {
        private String name;
        private int age;

        public Builder(int age) {
            this.age = age;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Outer build() {
            return new Outer(this);
        }
    }
    public  String toString(){
        return  "name:"+this.name+",age"+this.age;
    }
    private Outer(Builder b) {
        this.age = b.age;
        this.name = b.name;
    }
    public static Outer getOuter()
    {
        Outer outer = new Outer.Builder(2).withName("Yang Liu").build();
        return outer;
    }
    public  static  void main(String [] args){
        System.out.println(getOuter().toString());
    }
}
