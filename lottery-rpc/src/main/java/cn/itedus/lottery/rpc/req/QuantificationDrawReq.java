package cn.itedus.lottery.rpc.req;


import java.io.Serializable;
import java.util.Map;

/**
 * 量化人群抽奖请求参数
 */
public class QuantificationDrawReq implements Serializable {

    /**
     * 用户id
     */
    private String uId;

    private Long treeId;

    private Map<String,Object> valMap;

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }
}
