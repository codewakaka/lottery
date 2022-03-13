package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IStrategyDao {

    /**
     * 查询策略配置
     * @param strategyId
     * @return
     */
    Strategy queryStrategy( Long strategyId);

    /**
     *  新增策略
     * @param req
     */
    void insert(Strategy req);
}
