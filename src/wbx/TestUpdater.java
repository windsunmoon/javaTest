/**   
* @author ������   
* @date 2014-1-2 ����03:40:33 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @version V1.0   
*/
package wbx;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**   
 * @author ������   
 * @date 2014-1-2 
 * @Description:
 * @version V1.0   
 */
public class TestUpdater {

	private static AtomicIntegerFieldUpdater<TestA> a;

	public static void main(String[] args) {
		
		 a = AtomicIntegerFieldUpdater.newUpdater(TestA.class, "a");//�õ�ƫ����
		 TestA b = new TestA();
		 a.addAndGet(b, 8);//����  ���ڵ�ֵ
	    
		  AtomicReferenceFieldUpdater.newUpdater(TestB.class, Integer.class, "a");
		  
	}
	
	 
	
	
	
	
}
class TestB{
	volatile Integer a =1;
}

class TestA{
	volatile int a =1;
}

	
