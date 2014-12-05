
package wbx.log;

import java.util.logging.ErrorManager;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * 自定义的日志处理类，扩展自框架的Handler.
 * 
 * 
 */
public class EyHandler extends Handler {
	/** 处理完成标志.*/
	private boolean doneHeader = false;
	
	/**
	 * 构造方法.
	 */
	public EyHandler() {
		setFormatter(new EgovaFormatter()); 
	}
	@Override
	public void close() {
		if (!doneHeader) { 
			output(getFormatter().getHead(this)); 
			doneHeader = true; 
			} 
			output(getFormatter().getTail(this)); 
			flush(); 
		
	}

	@Override
	public void flush() {
	
		System.out.flush();
	}

	@Override
	public void publish(LogRecord record) {
		if (!isLoggable(record)) { 
			return; 
		}
		String msg = getFormatter().format(record); 

		try { 
		if (!doneHeader) { 
			output(getFormatter().getHead(this)); 
			doneHeader = true; 
		} 
		output(msg); 
		} catch (Exception ex) { 
			reportError(null, ex, ErrorManager.WRITE_FAILURE); 
		} 	
	}
	
	/**
	 * 输出日志.
	 * @param message 日志消息内容
	 */
	private void output(String message) { 
		System.out.println(message);
	}
	
}
