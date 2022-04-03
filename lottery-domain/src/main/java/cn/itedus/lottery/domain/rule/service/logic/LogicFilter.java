package cn.itedus.lottery.domain.rule.service.logic;

import cn.itedus.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.itedus.lottery.domain.rule.model.vo.TreeNodeLineVO;

import java.util.List;

/**
 * 规则过滤器接口
 */
public interface LogicFilter {


    /**
     *  逻辑决策器
     * @param matterValue
     * @param treeNodeLineInfoList
     * @return
     */
    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    /**
     *  获取决策值
     * @param decisionMatter
     * @return
     */
    String matterValue(DecisionMatterReq decisionMatter);

}
