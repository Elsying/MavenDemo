package com.bc.view;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class Result {
	//code 状态码：成功：000000，失败：999999
	private String code;
	//错误信息
	private  String message;
	//返回的数据（链式）
	private Map<String ,Object> date=new HashMap<String ,Object>();

	//成功
	public static Result success(){
		Result result=new Result();
		result.setCode("000000");
		result.setMessage("操作成功");
		return result;
	}

	//失败
	public static Result erro(String string){
		Result result=new Result();
		result.setCode("999999");
		if(StringUtils.isEmpty(string)){
			result.setMessage("操作失败");
		}else
			result.setMessage(string);


		return result;
	}

	//成功
	public  Result add(String key,Object value){
		Result result=new Result();
		result.setCode("000000");
		result.setMessage("操作成功");
		return result;
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

	public Map<String, Object> getDate() {
		return date;
	}

	public void setDate(Map<String, Object> date) {
		this.date = date;
	}
}
