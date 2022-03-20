package cn.itedus.lottery.domain.activity.serivce.partake;

import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;

/**
 * 抽奖活动参与接口
 */
public interface IActivityPartake {

    /**
     * 参与活动
     * @param req
     * @return
     */
    PartakeResult doPartake(PartakeReq req);
}
