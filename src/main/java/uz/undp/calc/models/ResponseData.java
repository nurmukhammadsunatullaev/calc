package uz.undp.calc.models;



import java.time.Instant;

public class ResponseData<T> {

    private T data;
    private String errorMessage;
    private Integer status;
    private long time = Instant.now().toEpochMilli();

    public ResponseData(T data) {
        this.data = data;
        this.status = 200;
        this.errorMessage = "";
    }

    public ResponseData(T data, String errorMessage, Integer status) {
        this.data = data;
        this.errorMessage = errorMessage;
        this.status = status;
    }
    public ResponseData(String errorMessage, Integer status) {
        this.errorMessage = errorMessage;
        this.status = status;
    }

    public ResponseData() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
