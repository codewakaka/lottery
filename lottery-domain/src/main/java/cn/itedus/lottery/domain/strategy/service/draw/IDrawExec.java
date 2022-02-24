package cn.itedus.lottery.domain.strategy.service.draw;


import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;

public interface IDrawExec {

    DrawResult doDrawExec(DrawReq req);
}
