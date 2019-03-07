package com.wccwin.financial.pub;

/**
 * 业务逻辑异常
 */
public class BusinessException extends Exception {

    /**
	 * 
	   TODO - 
	   BusinessException.java
	   long
	   2018年7月31日
	   mazkc 
	 */
	private static final long serialVersionUID = 1670307150488508189L;
	private int status;//对应classpath下的exception.properties


    protected BusinessException(){

    }

    private BusinessException(String msg){
        super(msg);
    }

    /**
     * 异常构建方法<br />
     * 根据exception.properties状态码，获取异常文案内容。
     * @param status
     * @return
     */
    public static BusinessException error(int status){
        String msg = ErrorMsgConfig.getErrorMsg(status);
        BusinessException exception = new BusinessException(msg);
        exception.setStatus(status);
        return exception;
    }

    /**
     * 异常构建方法<br />
     * 自定义动态message，异常状态码:999999
     * @param message
     * @return
     */
    public static BusinessException error(String message){
        BusinessException exception = new BusinessException(message);
        exception.setStatus(999999);
        return exception;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}





