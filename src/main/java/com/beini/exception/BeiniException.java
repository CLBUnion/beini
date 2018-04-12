package com.beini.exception;

import com.beini.enums.ResultEnum;

import lombok.Getter;

/**
 * 系统异常处理类 <br>
 * 建议直接使用其构造方法 <code>BeiniException(ResultEnum re)</code> 传参并使用
 * 
 * @author lb_chen
 */
@Getter
public class BeiniException extends RuntimeException {
	private static final long serialVersionUID = -634219731336988958L;
	/**
	 * 异常编码
	 */
	private Integer code;
	/**
	 * 异常消息
	 */
	private String message;

	/**
	 * 推荐使用<br>
	 * 结果枚举类 <br>
	 * 
	 * @see ResultEnum
	 * @param resultEnum
	 */
	public BeiniException(ResultEnum resultEnum) {
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
		this.message = resultEnum.getMessage();
	}
	/**
	 * 返回model中的属性合法控制<br>
	 * @param code
	 * @param message
	 */
	public BeiniException(Integer code,String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
}
