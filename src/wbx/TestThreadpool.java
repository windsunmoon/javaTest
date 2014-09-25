/**   
* @author ������   
* @date 2013-11-14 ����10:16:34 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @version V1.0   
*/
package wbx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**   
 * @author ������   
 * @date 2013-11-14 
 * @Description:
 * @version V1.0   
 */
public class TestThreadpool {

    
	public static void main(String[] args) {
		
		 Runnable a = new Runnable() {
				
				@Override
				public void run() {
					System.out.println("test");
					
				}
			};
		
		ExecutorService ser = Executors.newFixedThreadPool(2);
		
		Thread t1 =new Thread(a, "t1");
		Thread t2 =new Thread(a, "t2");
		Thread t3 =new Thread(a, "t3");
		
		ser.submit(t1);
		ser.submit(t2);
		ser.submit(t3);
		
		ser.shutdown();
	}
	
	
}
