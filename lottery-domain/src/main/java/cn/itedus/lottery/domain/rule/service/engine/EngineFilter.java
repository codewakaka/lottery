package cn.itedus.lottery.domain.rule.service.engine;

import cn.itedus.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.itedus.lottery.domain.rule.model.res.EngineResult;

/**
 * 规则过滤器引擎
 */
public interface EngineFilter {

    /**
     *  规则过滤接口
     * @param matter
     * @return
     */
    EngineResult process(final DecisionMatterReq matter);

}
