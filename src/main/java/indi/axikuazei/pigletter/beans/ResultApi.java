package indi.axikuazei.pigletter.beans;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
public class ResultApi {
    private int status;
    private String message;
    private Object data;

    public ResultApi(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResultApi newSuccessResult(Object data){
        return new ResultApi(200, "success", data);
    }

    public static ResultApi newFailResult(Object data){
        return new ResultApi(400, "fail", data);
    }
}
