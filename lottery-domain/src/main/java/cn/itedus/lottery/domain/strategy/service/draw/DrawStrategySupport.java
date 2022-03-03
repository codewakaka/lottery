package cn.itedus.lottery.domain.strategy.service.draw;


import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.repository.IStrategyRepository;
import cn.itedus.lottery.infrastructure.po.Award;

import javax.annotation.Resource;

/**
 * 抽奖策略数据支持，一些通用的数据服务
 */
public class DrawStrategySupport extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;


    /**
     * 查询策略配置信息
     * @param strategyId 策略id
     * @return 策略配置信息
     */
    protected StrategyRich queryStrategyRich(Long strategyId){
        return strategyRepository.queryStrategyRich(strategyId);
    }


    /**
     * 查询奖品详情信息
     * @param awardId
     * @return
     */
    protected Award queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }

}
