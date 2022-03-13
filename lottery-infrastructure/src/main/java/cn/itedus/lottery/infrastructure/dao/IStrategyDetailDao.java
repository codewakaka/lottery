package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyDetailDao {

    /**
     * 查询策略表详情配置
     *
     * @param strategyId 策略id
     * @return 返回结果
     */
    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    /**
     * 查询无库存策略奖品id
     *
     * @param strategyId 策略id
     * @return 返回结果
     */
    List<String> queryNoStockStrategyAwardList(Long strategyId);

    /**
     * 扣减库存
     *
     * @param strategyDetailReq 策略id 奖品id
     * @return 返回结果
     */
    int deductStock(StrategyDetail strategyDetailReq);

    /**
     *  插入策略配置组
     * @param req
     */
    void insertList(List<StrategyDetail> req);
}
