package cn.itedus.lottery.domain.rule.model.vo;

public class TreeNodeLineVO {

    /**
     * 节点from
     */
    private Long nodeIdFrom;

    /**
     * 节点to
     */
    private Long nodeIdTo;

    /**
     * 限定 类型 1：=，2:> 3:< 4>= 5<=  6enum[枚举范围]</>
     */
    private Integer ruleLimitType;

    /**
     * 限定值
     */
    private String ruleLimitValue;

    public Long getNodeIdFrom() {
        return nodeIdFrom;
    }

    public void setNodeIdFrom(Long nodeIdFrom) {
        this.nodeIdFrom = nodeIdFrom;
    }

    public Long getNodeIdTo() {
        return nodeIdTo;
    }

    public void setNodeIdTo(Long nodeIdTo) {
        this.nodeIdTo = nodeIdTo;
    }

    public Integer getRuleLimitType() {
        return ruleLimitType;
    }

    public void setRuleLimitType(Integer ruleLimitType) {
        this.ruleLimitType = ruleLimitType;
    }

    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    public void setRuleLimitValue(String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }
}
