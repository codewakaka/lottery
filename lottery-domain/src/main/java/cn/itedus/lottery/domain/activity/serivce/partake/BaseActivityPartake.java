package cn.itedus.lottery.domain.activity.serivce.partake;

import cn.itedus.lottery.common.Constants;
import cn.itedus.lottery.common.Result;
import cn.itedus.lottery.domain.activity.model.req.PartakeReq;
import cn.itedus.lottery.domain.activity.model.res.PartakeResult;
import cn.itedus.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.itedus.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.itedus.lottery.domain.support.ids.IIdGenerator;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import javax.annotation.Resource;
import java.util.Map;

public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Override
    public PartakeResult doPartake(PartakeReq req) {
        //1查询是否存在未执行抽奖活动单【user_task_activity 存在state=0 领取了但是抽奖活动失败，可以直接返回领取结果继续抽奖】
        UserTakeActivityVO userTakeActivity = this.queryNoConsumedTakeActivityOrder(req.getActivityId(),req.getuId());
        if(null != userTakeActivity){
            return buildPartakeResult(userTakeActivity.getStrategyId(), userTakeActivity.getTakeId());
        }

        //2查询活动账单
        ActivityBillVO activityBillVO  = super.queryActivityBill(req);

        //3活动信息校验处理【活动库存，状态，日期，个人参与次数】
        Result checkResult = this.checkActivityBill(req,activityBillVO);

        if(!Constants.ResponseCode.SUCCESS.getCode().endsWith(checkResult.getCode())){
            return new PartakeResult(checkResult.getCode(),checkResult.getInfo());
        }

        //4扣减活动库存【目前为直接对配置库中的lottery.activity 直接操作表扣减库存，后续优化redis】
        Result subtractionActivityResult = this.subtractionActivityStock(req);
        if(!Constants.ResponseCode.SUCCESS.getCode().endsWith(subtractionActivityResult.getCode())){
            return new PartakeResult(subtractionActivityResult.getCode(),subtractionActivityResult.getInfo());
        }

        // 5. 插入领取活动信息【个人用户把活动信息写入到用户表】
        Long takeId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        Result grabResult = this.grabActivity(req, activityBillVO,takeId);
        if(!Constants.ResponseCode.SUCCESS.getCode().endsWith(grabResult.getCode())){
            return new PartakeResult(grabResult.getCode(),grabResult.getInfo());
        }

        //封装结果【返回的策略id ，用于继续完成抽奖步骤】
        return buildPartakeResult(activityBillVO.getStrategyId(), takeId);

    }

    private PartakeResult buildPartakeResult(Long strategyId, Long takeId){
        PartakeResult result = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(),Constants.ResponseCode.SUCCESS.getInfo());
        result.setStrategyId(strategyId);
        result.setTakeId(takeId);
        return result;
    }


    /**
     *  查询是否存在未执行抽奖活动单【user_task_activity 存在state=0 领取了但是抽奖活动失败，可以直接返回领取结果继续抽奖】
     * @param activityId
     * @param getuId
     * @return
     */
    protected abstract  UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String getuId) ;

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
    protected abstract Result grabActivity(PartakeReq partake,ActivityBillVO bill,Long takeId);
}
