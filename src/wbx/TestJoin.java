/**   
* @author ������   
* @date 2013-12-25 ����03:09:47 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @version V1.0   
*/
package wbx;

/**   
 * @author ������   
 * @date 2013-12-25 
 * @Description:
 * @version V1.0   
 */
public class TestJoin {

	public static void main(String[] args) throws InterruptedException {
		Thread a = new Thread(){
			@Override
			public void run() {
				System.out.println(" Thread a am over");
			}
		};
		
		a.start();
		
		Thread.sleep(1000);
		
		a.join();
		
		System.out.println(" Thread main am over");
	}
}
