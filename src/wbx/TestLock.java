/**   
 * @author ������   
 * @date 2013-11-26 ����06:04:26 
 * @Description: TODO(��һ�仰�������ļ���ʲô) 
 * @version V1.0   
 */
package wbx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ������
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
		test(); // �ݹ���� ����������������������1
		// test2();// ����test2 ������������������2
		lock.unlock();// ����Ӧ�÷���finally ���У������ʡ�ԣ��Ժ�һ����
	}

	public void test2() {
		lock.lock();
		System.out.println("I am test1");
		test2();//
		lock.unlock();
	}

}
