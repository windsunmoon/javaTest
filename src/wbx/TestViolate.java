/**   
* @author wangboxuan   
* @date 2014-7-14 下午01:43:02 
* @Description: TODO
* @version V1.0   
*/
package wbx;

import javax.swing.plaf.SliderUI;

/**   
 * @author wangboxuan   
 * @date 2014-7-14 
 * @Description:
 */
public class TestViolate {

	private static volatile int c = 0;
	
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			new Thread( ){
				public void run() {
					c++;
				};
				
			}.start();
		}
		Thread.sleep(10*1000);
		System.out.println(c);
	}
}
