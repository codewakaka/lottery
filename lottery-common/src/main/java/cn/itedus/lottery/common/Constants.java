package cn.itedus.lottery.common;

public class Constants {

    public enum ResponseCode {
        /**
         * 成功code
         */
        SUCCESS("0000", "成功"),
        UN_ERROR("0001","未知失败"),
        ILLEGAL_PARAMETER("0002","非法参数"),
        INDEX_DUP("0003","主键冲突"),
        NO_UPDATE("0004","SQL操作无更新"),

        LOSING_DRAW("D001", "未中奖"),

        ;



        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

    }


    /**
     * 抽奖策略模式：总体概率 ，单项概率
     * 场景：两种抽奖算法描述 ，场景A、20% B、30% C、50%
     *  单项概率：如果A奖品抽空后，B和C保持目前的中奖概率，用户抽奖仍有20%中为A ，因A库存抽空则结果展示为未中奖，为了运营成本，通常采用这种
     *  总体概率：如果A抽完后，B和C奖品的概率按照3:5均分，相当于B奖品中奖概率由0.35提升喂0.375
     *
     */
    public enum StrategyMode{

        /**
         *  单项概率：如果A奖品抽空后，B和C保持目前的中奖概率，用户抽奖仍有20%中为A ，因A库存抽空则结果展示为未中奖，为了运营成本，通常采用这种
         */
        SINGLE(1,"单项概率"),


        /**
         * 总体概率：如果A抽完后，B和C奖品的概率按照3:5均分，相当于B奖品中奖概率由0.35提升喂0.375
         */
        ENTIRETY(2,"总体概率")
        ;


        private Integer code;

        private String info;


        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    public enum ActivityState{
        /**
         * 1.编辑
         */
        EDIT(1,"编辑"),

        ARRAIGNMENT(2,"提审"),

        REVOKE(3,"撤审"),

        PASS(4,"通过"),

        DOING(5,"运行(活动中)"),

        REFUSE(6,"拒绝"),

        CLOSE(7,"关闭"),

        OPEN(8,"开启")

        ;


        private Integer code;

        private String info;

        ActivityState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     * 中奖状态 0：未中奖 1已中奖 2 兜底奖
     */
    public enum DrawState{
        /**
         * 未中奖
         */
        FAIL(0,"未中奖"),


        /**
         * 已中奖
         */
        SUCCESS(1,"已中奖"),

        /**
         * 兜底奖
         */
        COVER(2,"兜底奖")

        ;

        private Integer code;

        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }


    /**
     * 发奖状态：0等待发奖、1发奖成功、2发奖失败
     */
    public enum AwardState{
        /**
         * 等待发奖
         */
        WAIT(0,"等待发奖"),
        /**
         * 发奖成功
         */
        SUCCESS(1,"发奖成功"),
        /**
         * 发奖失败
         */
        FAILURE(2,"发奖失败"),

        ;
        private Integer code;

        private String info;

        AwardState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     * 奖品类型（1:文字描述、2:兑换码、3:优惠券、4:实物奖品）
     */
    public enum AwardType{
        /**
         * 文字描述
         */
        DESC(1, "文字描述"),
        /**
         * 兑换码
         */
        RedeemCodeGoods(2, "兑换码"),
        /**
         * 优惠券
         */
        CouponGoods(3, "优惠券"),
        /**
         * 实物奖品
         */
        PhysicalGoods(4, "实物奖品");

        private Integer code;
        private String info;

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
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


    }

    /**
     * id生成策略
     */
    public enum Ids{
        /**
         * 雪花算法
         */
        SnowFlake,
        /**
         * 日期算法
         */
        ShortCode,
        /**
         * 随机算法
         */
        RandomNumeric;


    }

    /**
     * 活动单使用状态 0未使用、1已使用
     */
    public enum TaskState {
        /**
         * 未使用
         */
        NO_USED(0, "未使用"),
        USED(1, "已使用");

        private Integer code;
        private String info;

        TaskState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    /**
     * 发奖状态 0初始、1完成、2失败
     */
    public enum GrantState{
        /**
         * 初始
         */
        INIT(0, "初始"),
        COMPLETE(1, "完成"),
        FAIL(2, "失败");

        private Integer code;
        private String info;

        GrantState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }



}
