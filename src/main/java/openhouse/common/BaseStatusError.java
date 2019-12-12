package openhouse.common;

public class BaseStatusError {
    private String code;
    private String message;

    public BaseStatusError() {
        // Default constructor
    }

    public BaseStatusError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
