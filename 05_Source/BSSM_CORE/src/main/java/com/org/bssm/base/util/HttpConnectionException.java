package com.org.bssm.base.util;

/**
 * 〈一句话功能简述〉<br>
 * 〈HTTP 异常类〉
 * 
 * @author Administrator
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class HttpConnectionException extends Exception {


    private static final long serialVersionUID = -2248572723114818655L;


    public HttpConnectionException() {
    }

    /**
     * @param message
     */
    public HttpConnectionException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public HttpConnectionException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public HttpConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
