package com.wccwin.financial.model;

import com.wccwin.financial.pub.BusinessException;

public class RespModel<T> {

	private int status;// 1为正常

	private T data;// 返回的数据

	private String msg;// 返回消息

	private RespModel() {
	}

	private RespModel(T data) {
		this.data = data;
	}

	/**
	 * 成功返回
	 * 
	 * @param data
	 * @return
	 * @author kation
	 * @data 2017年11月3日 下午2:15:11
	 */
	public static <T> RespModel<T> success(T data) {
		RespModel<T> result = new RespModel<T>(data);
		result.setStatus(1);
		result.setMsg("success");
		return result;
	}

	/**
	 * 异常返回
	 *
	 * @param data
	 * @param e
	 * @return
	 * @author kation
	 * @data 2017年11月3日 下午2:15:22
	 */
	public static <T> RespModel<T> error(T data, Exception e) {
		RespModel<T> result = new RespModel<>(data);
		if (e instanceof BusinessException) {// 业务异常
			int code = ((BusinessException) e).getStatus();
			result.setStatus(0 - code);
			result.setMsg(e.getMessage());
		} else {// 其他异常
			result.setStatus(-1);
			result.setMsg("系统异常");
		}
		return result;
	}

	public static <T> RespModel<T> error(String message){
		RespModel<T> result = new RespModel<>();
		result.setStatus(-1);
		result.setMsg(message);
		return result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
