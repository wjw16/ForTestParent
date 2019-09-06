/**
 * File : People.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/29 0029上午 8:25:19
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/29 0029上午 8:25:19
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/29 0029上午 8:25:19
 * @modDesc : 
 */
public class People {
    private  int age;
    private  String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  String toString(){
        if(this==null)
            return  "is null";
        else
            return  "name:"+getName()+",age:"+getAge();
    }
}
