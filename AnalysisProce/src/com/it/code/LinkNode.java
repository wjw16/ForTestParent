/**
 * File : LinkNode.java
 *
 * @CopyRight : 华润河南医药有限公司
 * @Datetime : 2019/9/6 0006上午 10:09:38
 * @Author : 温建武
 * @Version:1.0
 */
package com.it.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : 温建武
 * @Datetime :  2019/9/6 0006上午 10:09:38
 * @Desc : 
 *
 * @Modor :  温建武：2019/9/6 0006上午 10:09:38
 * @modDesc : 
 */
public class LinkNode {
    public  boolean isMainTable=false;
    public List<LinkNode> linkedNodes;
    //相对于主表说
    private LinkType linkType;
    public List<String> selectFields;
    private String relationText;
    private Map<String,Map> relationMap;
    public Map<String,Object> storeMap;
    private TableType tableType;
    public LinkNode (){
        linkedNodes=new ArrayList<LinkNode>();
        selectFields=new ArrayList<String>();
        relationMap=new HashMap<String,Map>();
        storeMap=new HashMap<String,Object>();
    }
    public boolean isMainTable() {
        return isMainTable;
    }

    public void setMainTable(boolean mainTable) {
        isMainTable = mainTable;
    }

    public List<LinkNode> getLinkedNodes() {
        return linkedNodes;
    }

    public void setLinkedNodes(List<LinkNode> linkedNodes) {
        this.linkedNodes = linkedNodes;
    }

    public LinkType getLinkType() {
        return linkType;
    }

    public void setLinkType(LinkType linkType) {
        this.linkType = linkType;
    }

    public List<String> getSelectFields() {
        return selectFields;
    }

    public void setSelectFields(List<String> selectFields) {
        this.selectFields = selectFields;
    }

    public String getRelationText() {
        return relationText;
    }

    public void setRelationText(String relationText) {
        this.relationText = relationText;
    }

    public TableType getTableType() {
        return tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }
}
