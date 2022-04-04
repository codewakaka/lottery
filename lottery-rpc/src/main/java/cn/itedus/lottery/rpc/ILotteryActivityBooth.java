package cn.itedus.lottery.rpc;

import cn.itedus.lottery.rpc.req.DrawReq;
import cn.itedus.lottery.rpc.req.QuantificationDrawReq;
import cn.itedus.lottery.rpc.res.DrawRes;

/**
 * 抽奖活动展台
 */
public interface ILotteryActivityBooth {

    /**
     *  指定活动抽奖
     * @param drawReq
     * @return
     */
    DrawRes doDraw(DrawReq drawReq);


    /**
     * 量化人群抽奖
     * @param quantificationDrawReq
     * @return
     */
    DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq);

}
