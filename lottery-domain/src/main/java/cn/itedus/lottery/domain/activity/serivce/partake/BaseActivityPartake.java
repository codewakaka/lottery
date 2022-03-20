package cn.itedus.lottery.domain.activity.serivce.partake;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
import cn.itedus.lottery.domain.activity.model.vo.ActivityBillVO;

public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {

    @Override
    public PartakeResult doPartake(PartakeReq req) {
        //查询活动账单
        ActivityBillVO activityBillVO  = super.queryActivityBill(req);

        //活动信息校验处理【活动库存，状态，日期，个人参与次数】
        Result checkResult = this.checkActivityBill(req,activityBillVO);

        if(!Constants.ResponseCode.SUCCESS.getCode().endsWith(checkResult.getCode())){
            return new PartakeResult(checkResult.getCode(),checkResult.getInfo());
        }

        //扣减活动库存【目前为直接对配置库中的lottery.activity 直接操作表扣减库存，后续优化redis】
        Result subtractionActivityResult = this.subtractionActivityStock(req);
        if(!Constants.ResponseCode.SUCCESS.getCode().endsWith(subtractionActivityResult.getCode())){
            return new PartakeResult(subtractionActivityResult.getCode(),subtractionActivityResult.getInfo());
        }

        Result grabResult = this.grabActivity(req, activityBillVO);
        if(!Constants.ResponseCode.SUCCESS.getCode().endsWith(grabResult.getCode())){
            return new PartakeResult(grabResult.getCode(),grabResult.getInfo());
        }

        //封装结果【返回的策略id ，用于继续完成抽奖步骤】
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(),Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(activityBillVO.getStartegyId());
        return partakeResult;

    }

    /**
     * 活动信息校验处理，把活动库存，状态，日期，个人参与次数
     * @param req
     * @param activityBillVO
     * @return
     */
    protected abstract Result checkActivityBill(PartakeReq req, ActivityBillVO activityBillVO) ;


    /**
     * 扣减活动库存
     * @param req
     * @return
     */
    protected abstract Result subtractionActivityStock(PartakeReq req);


    /**
     * 领取活动
     * @param partake
     * @param bill
     * @return
     */
    protected abstract Result grabActivity(PartakeReq partake,ActivityBillVO bill);
}
