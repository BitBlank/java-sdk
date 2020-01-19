package app.b.sdk.server.model;

public class BappApiRes<T> {
    private int code;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return code == 200;
    }

    public int getCode() {
        return code;
    }

    public BappApiRes<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BappApiRes<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public BappApiRes<T> setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "BappApiRes{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
