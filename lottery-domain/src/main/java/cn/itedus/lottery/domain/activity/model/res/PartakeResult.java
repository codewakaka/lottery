package cn.itedus.lottery.domain.activity.model.res;

import cn.itedus.lottery.common.Result;

public class PartakeResult extends Result {

    /**
     * 策略id
     */
    private Long strategyId;

    /**
     * 活动领取id
     */
    private Long takeId;


    public PartakeResult(String code, String info) {
        super(code, info);
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }
}
