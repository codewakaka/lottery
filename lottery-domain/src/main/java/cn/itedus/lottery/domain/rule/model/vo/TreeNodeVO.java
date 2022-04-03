package cn.itedus.lottery.domain.rule.model.vo;

import java.util.List;

public class TreeNodeVO {

    /**
     * 规则树id
     */
    private Long treeId;

    /**
     * 规则树节点id
     */
    private Long treeNodeId;

    /**
     * 节点类型 1 叶子 2 果实
     */
    private Integer nodeType;

    /**
     * 节点值[nodeType=2] 果实值
     */
    private String nodeValue;

    /**
     * 规则key
     */
    private String ruleKey;

    /**
     * 规则描述
     */
    private String ruleDesc;

    /**
     * 节点链路
     */
    private List<TreeNodeLineVO> treeNodeLineInfoList;


    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeNodeId() {
        return treeNodeId;
    }

    public void setTreeNodeId(Long treeNodeId) {
        this.treeNodeId = treeNodeId;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(String nodeValue) {
        this.nodeValue = nodeValue;
    }

    public String getRuleKey() {
        return ruleKey;
    }

    public void setRuleKey(String ruleKey) {
        this.ruleKey = ruleKey;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public List<TreeNodeLineVO> getTreeNodeLineInfoList() {
        return treeNodeLineInfoList;
    }

    public void setTreeNodeLineInfoList(List<TreeNodeLineVO> treeNodeLineInfoList) {
        this.treeNodeLineInfoList = treeNodeLineInfoList;
    }
}
