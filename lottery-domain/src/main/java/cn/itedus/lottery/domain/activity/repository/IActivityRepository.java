package cn.itedus.lottery.domain.activity.repository;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.activity.model.vo.ActivityVO;
import cn.itedus.lottery.domain.activity.model.vo.AwardVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.itedus.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * 活动仓库服务（活动表，奖品表，策略表，策略明细）
 */
public interface IActivityRepository {

    /**
     * 变更活动状态
     * @param activityId 活动id
     * @param beforeState 修改前状态
     * @param afterState 修改后状态
     * @return 更新结果
     */
    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState,Enum<Constants.ActivityState> afterState);

    /**
     * 添加活动配置
     * @param activity
     */
    void addActivity(ActivityVO activity);

    /**
     * 添加奖品配置
     * @param awardList
     */
    void addAward(List<AwardVO> awardList);

    /**
     * 添加活动策略
     * @param strategy
     */
    void addStrategy(StrategyVO strategy);

    /**
     * 添加活动策略明细
     * @param strategyDetailList
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);
}
