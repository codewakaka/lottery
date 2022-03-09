package cn.itedus.lottery.domain.award.model.res;

/**
 * 商品配送结果
 */
public class DistributionRes {

    /** 用户id */
    private String uId;
    /** 编码 */
    private Integer code;
    /** 描述 */
    private String info;
    /** 结算单id 如：发卷后有劵码，发货后有单号等，用户存根查询 */
    private String statementId;


    public DistributionRes() {
    }

    public DistributionRes(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }

    public DistributionRes(String uId, Integer code, String info, String statementId) {
        this.uId = uId;
        this.code = code;
        this.info = info;
        this.statementId = statementId;
    }


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }
}
