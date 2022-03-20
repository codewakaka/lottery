package cn.itedus.lottery.infrastructure.dao;

import cn.itedus.lottery.domain.activity.model.vo.AlterStateVO;
import cn.itedus.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IActivityDao {

    /**
     * 插入数据
     * @param req
     */
    void insert(Activity req);


    /**
     *  根据活动好查询活动信息
     * @param activityId
     * @return
     */
    Activity queryActivityById(Long activityId);

    /**
     * 变更活动状态
     * @param alterStateVO
     * @return
     */
    int alterState(AlterStateVO alterStateVO);

    /**
     * 扣减活动库存
     * @param activityId
     * @return
     */
    int subtractionActivityStock(Long activityId);
}
