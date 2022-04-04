package cn.itedus.lottery.domain.strategy.service.algorithm;


import cn.itedus.lottery.domain.strategy.model.vo.AwardRateVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 公用的算法接口
 */
public abstract class BaseAlgorithm implements IDrawAlgorithm {


    /**
     * 斐波那契散列增量
     * 逻辑：黄金分割点（√5 - 1）/2 = 0.6180339887，Math.pow(2,32)*0.6180339887 = 0x61c88647
     */
    private final int HASH_INCREMENT = 0x61c88647;

    /**
     * 数组初始化长度
     */
    private final int RATE_TUPLE_LENGTH = 128;

    /**
     * 存放概率与奖品对应的散列结果 strategyId-> rateTuple
     */
    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();


    /**
     * 奖品区间概率值，strategyId -> [awardId -> begin、awardId -> end]
     * 保存奖品id和奖品概率等基本信息集合
     *
     */
    protected Map<Long, List<AwardRateVO>> awardRateInfoMap = new ConcurrentHashMap<>();


    @Override
    public void initRateTuple(Long strategyId, List<AwardRateVO> awardRateInfoList) {
        //保存奖品概率信息
        awardRateInfoMap.put(strategyId, awardRateInfoList);

        //对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hasMap 中
        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);

        int cursorVal = 0;

        for (AwardRateVO awardRateInfo : awardRateInfoList) {
            //例如奖品1 中奖概率0.05 rateVal就是5
            int rateVal = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();
            //循环填充概率范围值
            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++) {
                rateTuple[hashIdx(i)] = awardRateInfo.getAwardId();
            }
            cursorVal += rateVal;
        }


    }

    @Override
    public boolean isExistRateTuple(Long strategyId) {
        return rateTupleMap.containsKey(strategyId);
    }


    protected int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);

    }
}
