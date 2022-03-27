package cn.itedus.lottery.domain.activity.model.vo;

/**
 * 用户领取活动记录
 * @author xgh
 */
public class UserTakeActivityVO {

    /**
     * 活动id
     */
    private Long activityId;

    /**
     * 活动领取id
     */
    private Long takeId;


    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 活动单使用状态 0 未使用 1已使用
     */
    private Integer state;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
