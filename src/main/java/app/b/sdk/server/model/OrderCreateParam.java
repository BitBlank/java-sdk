package app.b.sdk.server.model;

import java.io.Serializable;

public class OrderCreateParam implements Serializable {
    private String orderId;
    private AmountType amountType;
    private long amount;
    private String body;
    private String returnUrl;
    private String notifyUrl;
    private long time;
    private String appKey;
    private String sign;
    private String orderIp;
    private String extra;
    private String lang;

    public String getOrderId() {
        return orderId;
    }

    public OrderCreateParam setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public AmountType getAmountType() {
        return amountType;
    }

    public OrderCreateParam setAmountType(AmountType amountType) {
        this.amountType = amountType;
        return this;
    }

    public long getAmount() {
        return amount;
    }

    public OrderCreateParam setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public String getBody() {
        return body;
    }

    public OrderCreateParam setBody(String body) {
        this.body = body;
        return this;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public OrderCreateParam setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public OrderCreateParam setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public long getTime() {
        return time;
    }

    public OrderCreateParam setTime(long time) {
        this.time = time;
        return this;
    }

    public String getAppKey() {
        return appKey;
    }

    public OrderCreateParam setAppKey(String appKey) {
        this.appKey = appKey;
        return this;
    }

    public String getSign() {
        return sign;
    }

    public OrderCreateParam setSign(String sign) {
        this.sign = sign;
        return this;
    }

    public String getOrderIp() {
        return orderIp;
    }

    public OrderCreateParam setOrderIp(String orderIp) {
        this.orderIp = orderIp;
        return this;
    }

    public String getExtra() {
        return extra;
    }

    public OrderCreateParam setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    public String getLang() {
        return lang;
    }

    public OrderCreateParam setLang(String lang) {
        this.lang = lang;
        return this;
    }

    @Override
    public String toString() {
        return "OrderCreateParam{" +
                "orderId='" + orderId + '\'' +
                ", amountType=" + amountType +
                ", amount=" + amount +
                ", body='" + body + '\'' +
                ", returnUrl='" + returnUrl + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", time=" + time +
                ", appKey='" + appKey + '\'' +
                ", sign='" + sign + '\'' +
                ", orderIp='" + orderIp + '\'' +
                ", extra='" + extra + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
