package cn.itedus.lottery.domain.strategy.service.algorithm;


import cn.itedus.lottery.domain.strategy.model.vo.AwardRateVO;

import java.util.List;

/**
 * 抽奖算法接口
 */
public interface IDrawAlgorithm {

    /**
     * 程序启动时初始化概率元祖，在初始化完成后使用过程中不允许修改元祖数据
     * <p>
     * 元祖数据作用在于将百分比内（0.2 、0.3/0.5）的数据，转换为一整条数组上分区数据，如下
     * 0.2 =0~0.2
     * 0.3 = 0 + 0.2 ~ 0.2+0.3 = 0.2 ~ 0.5
     * 0.5 = 0.5 ~1
     * <p>
     * 通过数据拆分为整条后，再根据0-100中各个区间的奖品信息，使用斐波那契散列计算出索引位置，把奖品数据存放到元祖中，，比如
     * <p>
     *  1.把0.2转换成20
     *  2.20对应的斐波那契值哈希值:(20 * HASH_INCREMENT + HASH_INCREMENT) = -1549107828 HASH_INCREMENT=0x61c88647
     *  3.再通过哈希值计算索引位置：hashCode &（rateTuple。length - 1 ） = 12
     *  4.那么tup[14]=0.2 中奖概率对应的奖品
     *  5.当后续通过随机数获取到1-100的值后
     *
     * @param strategyId
     */

    void initRateTuple(Long strategyId, List<AwardRateVO> awardRateInfoList);


    /**
     * 判断是否已经。做了数据初始化
     * @param strategyId
     * @return
     */
    boolean isExistRateTuple(Long strategyId);


    /**
     * secureRandom 生成随机数，索引到对应的奖品信息返回结果
     * @param strategyId
     * @param excludeAwardIds
     * @return
     */
    String randomDraw(Long strategyId , List<String> excludeAwardIds);
}
