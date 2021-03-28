package uz.undp.calc.models;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
}
