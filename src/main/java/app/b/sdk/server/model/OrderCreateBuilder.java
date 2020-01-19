package app.b.sdk.server.model;

public class OrderCreateBuilder {
    private final OrderCreateParam param;

    public OrderCreateBuilder() {
        param = new OrderCreateParam()
                .setTime(System.currentTimeMillis())
                .setAmountType(AmountType.CNY);
    }

    public static OrderCreateBuilder newBuilder() {
        return new OrderCreateBuilder();
    }

    public OrderCreateBuilder setOrderId(String orderId) {
        param.setOrderId(orderId);
        return this;
    }

    public OrderCreateBuilder setAmount(long amount) {
        param.setAmount(amount);
        return this;
    }

    public OrderCreateBuilder setBody(String body) {
        param.setBody(body);
        return this;
    }

    public OrderCreateBuilder setReturnUrl(String returnUrl) {
        param.setReturnUrl(returnUrl);
        return this;
    }

    public OrderCreateBuilder setNotifyUrl(String notifyUrl) {
        param.setNotifyUrl(notifyUrl);
        return this;
    }

    public OrderCreateBuilder setLang(String lang) {
        param.setLang(lang);
        return this;
    }

    public OrderCreateParam build() {
        return param;
    }
}
