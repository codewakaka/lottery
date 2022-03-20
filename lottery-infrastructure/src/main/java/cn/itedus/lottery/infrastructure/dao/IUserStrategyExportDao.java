package cn.itedus.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import cn.itedus.lottery.infrastructure.po.UserStrategyExport;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {


    /**
     * 新增数据
     * @param userStrategyExport
     */
    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);


    /**
     * 查询数据
     * @param uId
     * @return
     */
    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);



}
