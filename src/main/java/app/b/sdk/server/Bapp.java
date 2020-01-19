package app.b.sdk.server;

import app.b.sdk.server.api.BappApi;
import app.b.sdk.server.exception.BappException;
import app.b.sdk.server.model.*;
import app.b.sdk.server.util.BappNetUtil;
import app.b.sdk.server.util.BappSignUtil;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Bapp {
    private String appKey;
    private String appSecret;
    private BappApi bappApi;

    private static final OkHttpClient sharedClient;
    static {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(500);
        dispatcher.setMaxRequests(500);

        sharedClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .pingInterval(20, TimeUnit.SECONDS)
                .build();
    }

    private Bapp(String appKey, String appSecret, Proxy proxy) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        okhttp3.OkHttpClient client = sharedClient;
        if (proxy != null) {
            client = sharedClient.newBuilder().proxy(proxy).build();
        }

        Converter.Factory converterFactory = GsonConverterFactory.create(gson);
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(ApiConstants.API_BASE_URL)
                .addConverterFactory(converterFactory);

        OkHttpClient adaptedClient = client.newBuilder().build();
        retrofitBuilder.client(adaptedClient);

        Retrofit retrofit = retrofitBuilder.build();
        bappApi = retrofit.create(BappApi.class);
    }


    public static Bapp newInstance(String appKey, String appSecret) {
        return new Bapp(appKey, appSecret, null);
    }

    public static Bapp newInstance(String appKey, String appSecret, Proxy proxy) {
        return new Bapp(appKey, appSecret, proxy);
    }

    public boolean isSignOk(Map<String, ?> param) {
        return BappSignUtil.isSignOk(param, appSecret);
    }

    public OrderCreateRes createOrder(OrderCreateBuilder builder) {
        return createOrder(builder.build());
    }

    public OrderCreateRes createOrder(OrderCreateParam param) throws BappException {
        param.setAppKey(appKey);
        if (StringUtils.isEmpty(param.getSign())) {
            Map<String, Object> paramMap = toSignParamMap(param);
            String sign = BappSignUtil.createSign(paramMap, appSecret);
            param.setSign(sign);
        }

        BappApiRes<OrderCreateRes> res = BappNetUtil.execute(bappApi.createOrder(param));
        if (res.isSuccess()) {
            return res.getData();
        }

        throw new BappException(res);
    }

    public OrderCreateRes createBankPayOrder(OrderCreateParam param) throws BappException {
        param.setAppKey(appKey);
        if (StringUtils.isEmpty(param.getSign())) {
            Map<String, Object> paramMap = toSignParamMap(param);
            String sign = BappSignUtil.createSign(paramMap, appSecret);
            param.setSign(sign);
        }

        BappApiRes<OrderCreateRes> res = BappNetUtil.execute(bappApi.createBankPayOrder(param));
        if (res.isSuccess()) {
            return res.getData();
        }

        throw new BappException(res);
    }

    private Map<String, Object> toSignParamMap(OrderCreateParam param) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("app_key", param.getAppKey());
        paramMap.put("order_id", param.getOrderId());
        paramMap.put("sign", param.getSign());
        paramMap.put("time", param.getTime());
        paramMap.put("amount", param.getAmount());
        paramMap.put("body", param.getBody());
        paramMap.put("return_url", param.getReturnUrl());
        paramMap.put("notify_url", param.getNotifyUrl());
        paramMap.put("order_ip", param.getOrderIp());
        paramMap.put("extra", param.getExtra());
        paramMap.put("amount_type", param.getAmountType());
        paramMap.put("lang", param.getLang());
        return paramMap;
    }

    public OrderDetailRes getOrder(String orderId) throws BappException {
        long time = System.currentTimeMillis();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("order_id", orderId);
        paramMap.put("app_key", appKey);
        paramMap.put("time", time);
        String sign = BappSignUtil.createSign(paramMap, appSecret);
        BappApiRes<OrderDetailRes> res = BappNetUtil.execute(bappApi.getOrder(appKey, orderId, sign, time));
        if (res.isSuccess()) {
            return res.getData();
        }
        throw new BappException(res);
    }

}
