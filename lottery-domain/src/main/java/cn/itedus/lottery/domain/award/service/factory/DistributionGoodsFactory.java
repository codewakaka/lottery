package cn.itedus.lottery.domain.award.service.factory;

import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;


/**
 * 配送商品，简单工厂，提供获取配送服务
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig{


    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }
}
