package cn.itedus.lottery.domain.award.service.goods;

import cn.itedus.lottery.domain.award.model.req.GoodsReq;
import cn.itedus.lottery.domain.award.model.res.DistributionRes;

/**
 * 抽奖，抽象出配送货物接口，把各类奖品模拟成货物，配送代表着发货，包括虚拟奖品和实物奖品
 */
public interface IDistributionGoods {

    /**
     * 奖品配送接口，奖品类型（1，文字描述。2兑换码，3优惠卷 4实物奖品）
     * @param req
     * @return
     */
    DistributionRes doDistribution(GoodsReq req);


    Integer getDistributionGoodsName();
}
