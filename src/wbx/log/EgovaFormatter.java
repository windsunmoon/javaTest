/*
 * EgovaFormatter		20090917
 * 
 * Copyright (c) 2009 北京数字政通科技股份有限公司
 * 版权所有
 * 
 * 文件功能描述：自定义日志输出格式控制类
 *
 * 修改标识：于浩20091208
 * 修改描述：创建
 */
package wbx.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * 自定义日志输出格式控制类.
 * 
 * @version	0.1	20091208
 * @author	于浩
 */
public class EgovaFormatter  extends Formatter {
	/** 系统分隔符.*/
	private final String lineSeparator = System.getProperty("line.separator"); 
	
	@Override
	public String format(LogRecord record) {
		StringBuffer sb = new StringBuffer(); 
		String message = formatMessage(record); 
		sb.append(record.getLevel().getLocalizedName()); 
		sb.append(message); 
		sb.append(lineSeparator); 
		if (record.getThrown() != null) { 
			try { 
				StringWriter sw = new StringWriter(); 
				PrintWriter pw = new PrintWriter(sw); 
				record.getThrown().printStackTrace(pw); 
				pw.close(); 
				sb.append(sw.toString()); 
			} catch (Exception ex) { 
				ex.printStackTrace();
			} 
		} 
		return sb.toString(); 
	}
}
