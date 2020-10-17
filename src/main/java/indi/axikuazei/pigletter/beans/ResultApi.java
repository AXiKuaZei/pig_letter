package indi.axikuazei.pigletter.beans;

/**
 * @author axikuazei
 * @date 2020/9/17 下午3:59
 */
public class ResultApi {
    private int status;
    private String message;
    private String hint;
    private Object data;

    public ResultApi(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    public ResultApi(int status, String message, String hint, Object data) {
        this.status = status;
        this.message = message;
        this.hint = hint;
        this.data = data;
    }
    public static ResultApi newSuccessResult(Object data){
        return new ResultApi(200, "success", data);
    }

    public static ResultApi newSuccessResult(){
        return new ResultApi(200, "success", null);
    }

    public static ResultApi newFailResult(Object data){
        return new ResultApi(400, "fail", data);
    }

    public static ResultApi newFailResult(String hint, Object data){
        return new ResultApi(400, "fail", hint,data);
    }

    public static ResultApi newFailResult(){
        return new ResultApi(400, "fail", null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
