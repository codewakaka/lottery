package cn.itedus.lottery.domain.activity.model.aggregate;

import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.AwardVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * 活动配置聚合信息
 */
public class ActivityConfigRich {

    /**
     * 活动配置
     */
    private ActivityVO activity;

    /**
     * 策略配置（含明细）
     */
    private StrategyVO strategy;

    /**
     * 奖品配置
     */
    private List<AwardVO> awardVOList;

    public ActivityConfigRich() {
    }

    public ActivityConfigRich(ActivityVO activity, StrategyVO strategy, List<AwardVO> awardVOList) {
        this.activity = activity;
        this.strategy = strategy;
        this.awardVOList = awardVOList;
    }

    public ActivityVO getActivity() {
        return activity;
    }

    public void setActivity(ActivityVO activity) {
        this.activity = activity;
    }

    public StrategyVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyVO strategy) {
        this.strategy = strategy;
    }

    public List<AwardVO> getAwardVOList() {
        return awardVOList;
    }

    public void setAwardVOList(List<AwardVO> awardVOList) {
        this.awardVOList = awardVOList;
    }
}
