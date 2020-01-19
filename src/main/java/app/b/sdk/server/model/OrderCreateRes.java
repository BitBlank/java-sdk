package app.b.sdk.server.model;

public class OrderCreateRes {
    private String qrCode;
    private String payUrl;

    public String getQrCode() {
        return qrCode;
    }

    public OrderCreateRes setQrCode(String qrCode) {
        this.qrCode = qrCode;
        return this;
    }

    public String getPayUrl() {
        return payUrl;
    }

    public OrderCreateRes setPayUrl(String payUrl) {
        this.payUrl = payUrl;
        return this;
    }

    @Override
    public String toString() {
        return "OrderCreateRes{" +
                "qrCode='" + qrCode + '\'' +
                ", payUrl='" + payUrl + '\'' +
                '}';
    }
}
