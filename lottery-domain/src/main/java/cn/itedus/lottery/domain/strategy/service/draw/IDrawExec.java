package cn.itedus.lottery.domain.strategy.service.draw;


import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;

/**
 * 抽奖执行接口
 */
public interface IDrawExec {

    /**
     * 抽奖方式
     * @param req 抽奖参数:用户id 策略id
     * @return 中奖结果
     */
    DrawResult doDrawExec(DrawReq req);
}
