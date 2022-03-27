package cn.itedus.lottery.application.process;

import cn.itedus.lottery.application.process.req.DrawProcessReq;
import cn.itedus.lottery.application.process.res.DrawProcessResult;

/**
 * 活动抽奖流程编排接口
 */
public interface IActivityProcess {


    /**
     *  执行抽奖流程
     * @param req
     * @return
     */
    DrawProcessResult doDrawProcess(DrawProcessReq req);
}
