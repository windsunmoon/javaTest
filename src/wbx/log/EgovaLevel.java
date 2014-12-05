/*
 * EgovaLevel		20090917
 * 
 * Copyright (c) 2009 北京数字政通科技股份有限公司
 * 版权所有
 * 
 * 文件功能描述：自定义的日志级别类
 *
 * 修改标识：于浩20091208
 * 修改描述：创建
 */
package wbx.log;

import java.util.logging.Level;

/**
 * 自定义的日志级别类.
 * 
 * @version	0.1	20091208
 * @author	于浩
 */
public class EgovaLevel extends Level {
	/**ERROR级别.*/
	public static final Level ERROR = new EgovaLevel("ERROR", 980); 
	/**WARN级别.*/
	public static final Level WARN = new EgovaLevel("WARN", 880); 
	/**INFO级别.*/
	public static final Level INFO = new EgovaLevel("INFO", 650); 
	/**DEBUG级别.*/
	public static final Level DEBUG = new EgovaLevel("DEBUG", 620);  
	
	/**
	 * 构造方法.
	 * @param name 名称.
	 * @param value 值.
	 */
	protected EgovaLevel(String name, int value) {
		super(name, value);
	}
}
