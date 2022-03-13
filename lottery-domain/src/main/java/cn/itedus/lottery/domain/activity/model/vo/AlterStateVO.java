package cn.itedus.lottery.domain.activity.model.vo;

/**
 * 变更活动状态对象
 */
public class AlterStateVO {

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 变更前状态
     */
    private Integer beforeState;

    /**
     * 变更后状态
     */
    private Integer afterState;


    public AlterStateVO() {
    }

    public AlterStateVO(Long activityId, Integer beforeState, Integer afterState) {
        this.activityId = activityId;
        this.beforeState = beforeState;
        this.afterState = afterState;
    }


    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getBeforeState() {
        return beforeState;
    }

    public void setBeforeState(Integer beforeState) {
        this.beforeState = beforeState;
    }

    public Integer getAfterState() {
        return afterState;
    }

    public void setAfterState(Integer afterState) {
        this.afterState = afterState;
    }
}
