/**
 * File : MainApp.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/9/2 0002上午 11:21:29
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author : 温建武
 * @Datetime :  2019/9/2 0002上午 11:21:29
 * @Desc :
 * @Modor :  温建武：2019/9/2 0002上午 11:21:29
 * @modDesc :
 */
public class MainApp {
    String text = "";

    public static void main(String[] args) {
          String text=loadText().toLowerCase();
          ScriptEntity se=resolveConstruct(text);
          String[] scriptArr=se.getBody().split(";");
          analyzeNodes(scriptArr);

    }

    public static String loadText() {
        String filePath = System.getProperty("user.dir") + "\\Files\\pro.txt";
        File file = new File(filePath);
        StringBuilder resultStr=new StringBuilder();

        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(new FileInputStream(file),"utf-8");
        BufferedReader bReader = new BufferedReader(isr);
        String line=bReader.readLine();
        while (line != null) {
            //String sep=System.getProperty("line.separator");
            //分隔符是\r\n
            line += System.getProperty("line.separator");
            resultStr.append(line);
            line = bReader.readLine();
        }
        bReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		return resultStr.toString();
    }
    public  static ScriptEntity resolveConstruct(String text){
        ScriptEntity se=new ScriptEntity();
        String remain=text;
        String [] partArr= remain.split("declare");
        if(partArr.length==2){
            se.setHead(partArr[0]);
            remain=partArr[1];
        }
        partArr=remain.split("begin");
        if(partArr.length==2){
            se.setDeclare(partArr[0]);
            remain=partArr[1];
        }
        partArr=remain.split("[$]body[$]");
        if(partArr.length==2)
        {
            se.setTail(partArr[1]);
        }
        se.setBody(partArr[0]);
        if(se.getHead()!=null&&se.getTail()!=null){
            se.setSciptForm(ScriptEntity.ScriptForm.PROCEDURE);
        }
        else{
            se.setSciptForm(ScriptEntity.ScriptForm.SQL);
        }
        return  se;
    }
    public static void rexTest( ){

        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        System.out.println(m.groupCount());
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }
    public static List<LinkNode> analyzeNodes(String[] scriptArr){
        List<LinkNode> linkNodeList=new ArrayList<LinkNode>();
        for(int i=0;i<scriptArr.length;i++){
              String script=scriptArr[i];
              judgeScriptType(script);
        }
        return  linkNodeList;
    }
    public static ScriptType  judgeScriptType(String script){
        script=script.replace("\\r\\n","").trim();
        String pattern_scriptInto="^select\\s+\\S+into\\S+from\\S+";
        Boolean isMatch=Pattern.matches(pattern_scriptInto,script);
        if(isMatch){
            return  ScriptType.SELECTINSERT;
        }
        return  ScriptType.ASSIGN;
    }
    public  void testScriptType(){

    }
}
