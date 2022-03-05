package cn.itedus.lottery.domain.strategy.service.draw.impl;

import cn.hutool.extra.ssh.JschUtil;
import cn.hutool.json.JSONUtil;
import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.itedus.lottery.domain.strategy.model.res.DrawResult;
import cn.itedus.lottery.domain.strategy.model.repository.IStrategyRepository;
import cn.itedus.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.itedus.lottery.domain.strategy.service.draw.AbstractDrawBase;
import cn.itedus.lottery.domain.strategy.service.draw.DrawBase;
import cn.itedus.lottery.domain.strategy.service.draw.IDrawExec;
import cn.itedus.lottery.domain.strategy.model.req.DrawReq;
import cn.itedus.lottery.infrastructure.po.Award;
import cn.itedus.lottery.infrastructure.po.Strategy;
import cn.itedus.lottery.infrastructure.po.StrategyDetail;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class DrawExecImpl extends AbstractDrawBase {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);


    @Resource
    private IStrategyRepository strategyRepository;

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        //执行抽奖
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);
        //判断抽奖结果
        if (null == awardId) {
            return null;
        }
        /*
         *扣减库存，暂时采用数据库行级锁的方式进行扣减库存，后续优化采用redis 分布式扣减 decr/incr
         * 注意，通常数据库直接锁行记录的方式并不能支持较大体量的并发，当此方式需了解，因为在分库分表下的正常数据流量的个人数据记录中，是可以通过使用行级锁的，因为他只影响到自己的记录，不会影响到其他人
         */
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);
        //返回结果，库存扣减成功返回奖品id，否则返回null【在实际业务场景中，如果中奖奖品库存为空，则会发送兜底奖品，比如各类劵】
        return isSuccess ? awardId : null;
    }

    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("执行抽奖策略,strategyId :{},无库存排除奖品列表ID集合，awardList：{}", strategyId, JSON.toJSONString(awardList));
        return awardList;
    }


/*   @Override
    public DrawResult doDrawExec(DrawReq req) {
        logger.info("执行策略抽奖开始,strategyId：{}",req.getStrategyId());

        //获取抽奖策略配置数据
        StrategyRich strategyRich =  strategyRepository.queryStrategyRich(req.getStrategyId());

        Strategy strategy = strategyRich.getStrategy();

        List<StrategyDetail> strategyDetailList = strategyRich.getStrategyDetailList();

        //校验和初始化数据
        checkAndInitRateData(req.getStrategyId(),strategy.getStrategyMode(),strategyDetailList);

        //根据策略方式抽奖

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategy.getStrategyMode());

        String awardId = drawAlgorithm.randomDraw(req.getStrategyId(), new ArrayList<>());

        //获取奖品信息
        Award award =  strategyRepository.queryAwardInfo(awardId);

        logger.info("执行策略抽奖完成,中奖用户：{},奖品id：{}。奖品名称：{}",req.getuId(),awardId,award.getAwardName());

        return new DrawResult(req.getuId(), req.getStrategyId(),  Constants.DrawState.FAIL.getCode());
    }*/
}
