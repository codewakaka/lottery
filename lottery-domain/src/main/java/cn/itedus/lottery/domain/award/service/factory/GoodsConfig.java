package cn.itedus.lottery.domain.award.service.factory;

import cn.itedus.lottery.domain.award.service.goods.IDistributionGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GoodsConfig {


    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private Map<String,IDistributionGoods> beanNameMap;


    @PostConstruct
    public void init(){
        beanNameMap.forEach((key, value) -> goodsMap.put(value.getDistributionGoodsName(), value));
    }
}
