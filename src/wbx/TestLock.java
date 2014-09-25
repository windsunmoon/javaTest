/**   
 * @author 王柏轩   
 * @date 2013-11-26 下午06:04:26 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @version V1.0   
 */
package wbx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 王柏轩
 * @date 2013-11-26
 * @Description:
 * @version V1.0
 */
public class TestLock {

	public synchronized void a() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aaa");
	}

	public synchronized void b() {
		System.out.println("bbb");
		Lock a = new ReentrantLock();
	}

	Lock lock = new ReentrantLock();

	public void test() {
		lock.lock();
		System.out.print("I am test1");
		test(); // 递归调用 ……………………………1
		// test2();// 调用test2 ………………………2
		lock.unlock();// 这里应该放在finally 块中，这里简单省略，以后一样。
	}

	public void test2() {
		lock.lock();
		System.out.println("I am test1");
		test2();//
		lock.unlock();
	}

}
