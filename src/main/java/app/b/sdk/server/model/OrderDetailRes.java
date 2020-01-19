package app.b.sdk.server.model;

public class OrderDetailRes {
    private String bappId;
    private String orderId;
    private int orderStatus;
    private String body;
    private String notifyUrl;
    private String orderIp;
    private String amount;
    private AmountType amountType;
    private long amount_btc;
    private long payTime;
    private long createTime;
    private int orderType;
    private String appKey;
    private String extra;

    public String getBappId() {
        return bappId;
    }

    public OrderDetailRes setBappId(String bappId) {
        this.bappId = bappId;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderDetailRes setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public OrderDetailRes setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getBody() {
        return body;
    }

    public OrderDetailRes setBody(String body) {
        this.body = body;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public OrderDetailRes setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getOrderIp() {
        return orderIp;
    }

    public OrderDetailRes setOrderIp(String orderIp) {
        this.orderIp = orderIp;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public OrderDetailRes setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public AmountType getAmountType() {
        return amountType;
    }

    public OrderDetailRes setAmountType(AmountType amountType) {
        this.amountType = amountType;
        return this;
    }

    public long getAmount_btc() {
        return amount_btc;
    }

    public OrderDetailRes setAmount_btc(long amount_btc) {
        this.amount_btc = amount_btc;
        return this;
    }

    public long getPayTime() {
        return payTime;
    }

    public OrderDetailRes setPayTime(long payTime) {
        this.payTime = payTime;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public OrderDetailRes setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public int getOrderType() {
        return orderType;
    }

    public OrderDetailRes setOrderType(int orderType) {
        this.orderType = orderType;
        return this;
    }

    public String getAppKey() {
        return appKey;
    }

    public OrderDetailRes setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    public String getExtra() {
        return extra;
    }

    public OrderDetailRes setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    @Override
    public String toString() {
        return "OrderDetailRes{" +
                "bappId='" + bappId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderStatus=" + orderStatus +
                ", body='" + body + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", orderIp='" + orderIp + '\'' +
                ", amount='" + amount + '\'' +
                ", amountType=" + amountType +
                ", amount_btc=" + amount_btc +
                ", payTime=" + payTime +
                ", createTime=" + createTime +
                ", orderType=" + orderType +
                ", appKey='" + appKey + '\'' +
                ", extra='" + extra + '\'' +
                '}';
    }
}
