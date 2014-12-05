/*
 * Copyright (c) 2010 北京数字政通科技股份有限公司
 * 版权所有
 * 
 * 修改标识：史先方20100702
 * 修改描述：创建
 */
package wbx.log;


/**
 * 封装日志记录类,便于改变不同的Log工具.
 * 
 * @version 0.1 20100702
 * @author 史先方
 */
public class MLogger {

	/** 自定义的EgovaLogger实例. */
	private static final EgovaLogger ELOGGER = EgovaLogger.getInstance();

	/**
	 * 记录一条DEBUG日志信息.
	 * 
	 * @param tag 判断日志来源. 通常为打印日志的类和方法.
	 * @param msg 要记录的日志内容
	 */
	public static void debug(String tag, String msg) {
		if(null != ELOGGER) {
			ELOGGER.log(EgovaLevel.DEBUG, tag + " " + msg);
		} else {
		}
	}

	/**
	 * 记录一条INFO日志信息.
	 * 
	 * @param tag 判断日志来源. 通常为打印日志的类和方法.
	 * @param msg 要记录的日志内容
	 */
	public static void info(String tag, String msg) {
		if(null != ELOGGER) {
			ELOGGER.log(EgovaLevel.INFO, tag + " " + msg);
		} else {
		}
	}

	/**
	 * 记录一条WAN日志信息.
	 * 
	 * @param tag 判断日志来源. 通常为打印日志的类和方法.
	 * @param msg 要记录的日志内容
	 */
	public static void warn(String tag, String msg) {
		if(null != ELOGGER) {
			ELOGGER.log(EgovaLevel.WARN, tag + " " + msg);
		} else {
		}
	}

	/**
	 * 记录一条WAN日志信息.
	 * @param tag 判断日志来源. 通常为打印日志的类和方法.
	 * @param msg 要记录的日志内容
	 */
	public static void warn(String tag, String msg, Exception e) {
		if(null != ELOGGER) {
			ELOGGER.log(EgovaLevel.WARN, tag + " " + msg,e);
		} else {
		}
	}
	
	/**
	 * 记录一条ERROR日志信息.
	 * 
	 * @param tag 判断日志来源. 通常为打印日志的类和方法.
	 * @param msg 要记录的日志内容
	 */
	public static void error(String tag, String msg) {
		if(null != ELOGGER) {
			ELOGGER.log(EgovaLevel.ERROR, tag + " " + msg);
		} else {
		}
	}

	/**
	 * 记录一条ERROR日志信息.
	 * 
	 * @param tag 判断日志来源. 通常为打印日志的类和方法.
	 * @param msg 要记录的日志内容
	 * @param e 异常
	 */
	public static void error(String tag, String msg, Exception e) {
		if(null != ELOGGER) {
			ELOGGER.log(EgovaLevel.ERROR, tag + " " + msg, e);
		} else {
		}
	}
}
