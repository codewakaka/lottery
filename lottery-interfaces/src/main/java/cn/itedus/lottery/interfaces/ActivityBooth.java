package cn.itedus.lottery.interfaces;


import cn.itedus.lottery.infrastructure.dao.IActivityDao;
import cn.itedus.lottery.rpc.IActivityBooth;
import cn.itedus.lottery.rpc.req.ActivityReq;
import cn.itedus.lottery.rpc.res.ActivityRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ActivityBooth implements IActivityBooth {

    @Resource
    private IActivityDao iActivityDao;

    @Override
    public ActivityRes queryActivityById(ActivityReq req) {

        return null;
    }
}
