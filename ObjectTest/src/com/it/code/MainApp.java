/**
 * File : MainApp.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/29 0029上午 8:26:07
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/29 0029上午 8:26:07
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/29 0029上午 8:26:07
 * @modDesc : 
 */
public class MainApp {
    public  static void  main(String[] args){
        People people=new People();
        people.setName("wjw");
        people.setAge(18);
        StaticObject.people=people;
        System.out.println("初始化："+StaticObject.people.toString());
        people.setName("我改变了");
        System.out.println("改变值："+StaticObject.people.toString());
        people=null;
        System.out.println("设为空值："+StaticObject.people.toString());

    }
}
