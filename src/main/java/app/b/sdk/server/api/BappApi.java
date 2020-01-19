package app.b.sdk.server.api;

import app.b.sdk.server.model.BappApiRes;
import app.b.sdk.server.model.OrderCreateParam;
import app.b.sdk.server.model.OrderCreateRes;
import app.b.sdk.server.model.OrderDetailRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BappApi {

    @POST("/api/v2/pay")
    Call<BappApiRes<OrderCreateRes>> createOrder(@Body OrderCreateParam param);

    @POST("/api/v2/pay/bank")
    Call<BappApiRes<OrderCreateRes>> createBankPayOrder(@Body OrderCreateParam param);

    @GET("/api/v2/order")
    Call<BappApiRes<OrderDetailRes>> getOrder(
            @Query("app_key") String appKey,
            @Query("order_id") String orderId,
            @Query("sign") String sign,
            @Query("time") long time);

}
