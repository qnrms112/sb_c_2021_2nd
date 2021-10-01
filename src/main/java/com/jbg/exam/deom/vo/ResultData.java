package com.jbg.exam.deom.vo;

import lombok.Getter;

public class ResultData {
	@Getter
	private String resultCode;
	@Getter
	private String msg;
	@Getter
	private Object data1;
	
	public ResultData() {
		// TODO Auto-generated constructor stub
	}
	
	public static ResultData from(String resultCode, String msg) {
		return from(resultCode, msg, null);
	}
	
	
	public static ResultData from(String resultCode, String msg, Object data1) {
		ResultData rd = new ResultData();
		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.data1 = data1;
		
		return rd;
	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}
	
	public boolean isFail() {
		return isSuccess() == false;
	}

	public static Object newData(ResultData joinRd, Object newData) {
		return from(joinRd.getResultCode(),joinRd.getMsg(), newData);
	}
	
}