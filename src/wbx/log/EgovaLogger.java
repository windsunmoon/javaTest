/*
 * EgovaLogger		20090917
 * 
 * Copyright (c) 2009 北京数字政通科技股份有限公司
 * 版权所有
 * 
 * 文件功能描述：自定义的Logger类
 *
 * 修改标识：于浩20091208
 * 修改描述：创建
 */
package wbx.log;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 自定义的Logger类，使用单例模式，继承了Logger.
 * 
 * @version	0.1	20090917
 * @author	史先方
 */
public class EgovaLogger extends Logger {
	
	/** EgovaLogger类实例.*/
	private static EgovaLogger instance = null;
	
	/**
	 * 构造方法.
	 * @param name Logger名称.
	 * @param resourceBundleName  .
	 */
	protected EgovaLogger(String name, String resourceBundleName) {
		super(name, resourceBundleName);
		setLevel(EgovaLevel.DEBUG);
	}
	
	/**
	 * 获取EgovaLogger的单一实例.
	 * @return EgovaLogger实例.
	 */
	public static EgovaLogger getInstance() {
		if (null == instance) {
			instance = new EgovaLogger("wbxtest", null);
		}		
		return instance;
	}
}
