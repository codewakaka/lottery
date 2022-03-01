package cn.itedus.lottery.domain.strategy.model.repository;

import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.infrastructure.po.Award;

public interface IStrategyRepository {


    StrategyRich queryStrategyRich(Long strategyId);


    Award queryAwardInfo(String awardId);
}
