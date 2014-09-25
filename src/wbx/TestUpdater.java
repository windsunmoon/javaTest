/**   
* @author 王柏轩   
* @date 2014-1-2 下午03:40:33 
* @Description: TODO(用一句话描述该文件做什么) 
* @version V1.0   
*/
package wbx;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**   
 * @author 王柏轩   
 * @date 2014-1-2 
 * @Description:
 * @version V1.0   
 */
public class TestUpdater {

	private static AtomicIntegerFieldUpdater<TestA> a;

	public static void main(String[] args) {
		
		 a = AtomicIntegerFieldUpdater.newUpdater(TestA.class, "a");//得到偏移量
		 TestA b = new TestA();
		 a.addAndGet(b, 8);//到的  现在的值
	    
		  AtomicReferenceFieldUpdater.newUpdater(TestB.class, Integer.class, "a");
		  
	}
	
	 
	
	
	
	
}
class TestB{
	volatile Integer a =1;
}

class TestA{
	volatile int a =1;
}

	
