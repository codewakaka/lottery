package cn.itedus.lottery.domain.award.service.goods;

import cn.itedus.lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * 配送货物基础共用类
 */
public class DistributionBase {
    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);


    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId,String orderId,String awardId,Integer awardState,String awardStateInfo){
        //todo 后期添加更新分库分表中，用户个人的抽奖记录放发状态
        logger.info("todo 后期添加更新分库分表中，用户个人的抽奖记录放发状态uId：{}",uId);
    }
}
