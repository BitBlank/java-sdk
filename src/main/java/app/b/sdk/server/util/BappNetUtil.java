package app.b.sdk.server.util;

import app.b.sdk.server.exception.BappException;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

public class BappNetUtil {
    private BappNetUtil() {
    }

    public static <T> T execute(Call<T> call) {
        try {
            Response<T> response = call.execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new BappException("Request fail");
            }
        } catch (IOException e) {
            throw new BappException(e);
        }
    }

}
