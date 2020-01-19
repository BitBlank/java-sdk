package app.b.sdk.server.exception;

import app.b.sdk.server.model.BappApiRes;

public class BappException extends RuntimeException {
    private BappApiRes apiRes;

    public BappException() {
        super();
    }

    public BappException(String message) {
        super(message);
    }

    public BappException(Throwable cause) {
        super(cause);
    }

    public BappException(String message, Throwable cause) {
        super(message, cause);
    }

    public BappException(BappApiRes apiRes) {
        super();
        this.apiRes = apiRes;
    }

    public BappApiRes getApiRes() {
        return apiRes;
    }

    @Override
    public String getMessage() {
        if (apiRes != null) {
            return apiRes.getMsg();
        }
        return super.getMessage();
    }
}
