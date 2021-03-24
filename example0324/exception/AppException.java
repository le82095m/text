package org.example.exception;

/**
 *
 * 自定义异常类，业务代码抛自定义异常或其他异常
 * 自定义异常返回给定的错误码，其他异常
 * */

public class AppException extends RuntimeException {
    private String message;
    private String coda;
    public AppException(String coda,String message) {
        super(message);
        this.coda = coda;
        this.message = message;
    }

    public AppException(String coda, String message, Throwable cause) {
        super(message, cause);
        this.coda = coda;
        this.message = message;
    }

    public String getCoda() {
        return coda;
    }

    public String getMessage() {
        return message;
    }
}
