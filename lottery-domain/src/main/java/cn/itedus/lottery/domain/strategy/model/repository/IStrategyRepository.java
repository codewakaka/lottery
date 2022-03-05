package cn.itedus.lottery.domain.strategy.model.repository;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.infrastructure.po.Award;

import java.util.List;

public interface IStrategyRepository {


    StrategyRich queryStrategyRich(Long strategyId);


    Award queryAwardInfo(String awardId);


    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     * @param strategyId 策略id
     * @param awardId 奖品id
     * @return 扣减结果
     */
    boolean deductStock(Long strategyId,String awardId);
}
