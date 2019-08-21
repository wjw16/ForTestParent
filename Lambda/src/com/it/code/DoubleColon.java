/**
 * File : DoubleColon.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/8/21 0021下午 6:41:20
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code;

/**
 * @Author : 温建武
 * @Datetime :  2019/8/21 0021下午 6:41:20
 * @Desc : 
 *
 * @Modor :  温建武：2019/8/21 0021下午 6:41:20
 * @modDesc : 
 */
public class DoubleColon {
    public static void printStr(String str) {
        System.out.println("printStr : " + str);
    }

    public void toUpper(){
        System.out.println("toUpper : " + this.toString());
    }

    public void toLower(String str){
        System.out.println("toLower : " + str);
    }

    public int toInt(String str){
        System.out.println("toInt : " + str);
        return 1;
    }

}
