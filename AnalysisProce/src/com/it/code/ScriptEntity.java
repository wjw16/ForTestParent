/**
 * File : ScriptEntity.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/9/3 0003下午 5:08:27
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code;

/**
 * @Author : 温建武
 * @Datetime :  2019/9/3 0003下午 5:08:27
 * @Desc : 
 *
 * @Modor :  温建武：2019/9/3 0003下午 5:08:27
 * @modDesc : 
 */
public class ScriptEntity {
    private  ScriptForm sciptForm;
    private  String declare;
    private  String body;
    private  String returnMsg;
    private  String head;
    private  String tail;
    private  String sqlText;
    public String getDeclare() {
        return declare;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }
    enum ScriptForm{
        SQL,PROCEDURE,VIEW
    }

    public ScriptForm getSciptForm() {
        return sciptForm;
    }

    public void setSciptForm(ScriptForm sciptForm) {
        this.sciptForm = sciptForm;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }
}
