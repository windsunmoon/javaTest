/**   
* @author ������   
* @date 2013-12-23 ����11:11:22 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @version V1.0   
*/
package wbx;

import java.util.Properties;

/**   
 * @author ������   
 * @date 2013-12-23 
 * @Description:
 * @version V1.0   
 */
public class ThreadLocalTest {

	private    ThreadLocal<Integer>  inta = new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			return 1;
		};
	};
	
	public static void main(String[] args) {
		final ThreadLocalTest a = new ThreadLocalTest();
		new Thread("test1"){
			public void run() {
				int i =1;
				while (i<=10) {
					i++;
					a.inta.set(a.inta.get()+1);
					System.out.println(Thread.currentThread().getName()+": "+ a.inta.get());
				
				}
			};
		}.start();
		
		new Thread("test2"){
			public void run() {
				int i =1;
				while (i<=10) {
					i++;

					a.inta.set(a.inta.get()+1);
					System.out.println(Thread.currentThread().getName()+": "+ a.inta.get());
				}
			};
		}.start();
		
		new Thread("test3"){
			public void run() {
				int i =1;
				while (i<=10) {
					i++;
					a.inta.set(a.inta.get()+1);
					System.out.println(Thread.currentThread().getName()+": "+ a.inta.get());
				}
			};
		}.start();
		
		
		new Thread("test4"){
			public void run() {
				int i =1;
				while (i<=10) {
					i++;
					a.inta.set(a.inta.get()+1);
					System.out.println(Thread.currentThread().getName()+": "+ a.inta.get());
				}
			};
		}.start();
		
		new Thread("test5"){
			public void run() {
				int i =1;
				while (i<=10) {
					i++;
					a.inta.set(a.inta.get()+1);
					System.out.println(Thread.currentThread().getName()+": "+ a.inta.get());
				}
			};
		}.start();
	}
}


 