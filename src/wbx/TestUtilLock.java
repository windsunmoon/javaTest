/**   
* @author ������   
* @date 2014-1-16 ����04:46:25 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @version V1.0   
*/
package wbx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**   
 * @author ������   
 * @date 2014-1-16 
 * @Description:
 * @version V1.0   
 */
public class TestUtilLock {

    public static class LockTest {  
    	  
        Lock lock = new ReentrantLock();// ��  
        double value = 0d; // ֵ  
        int addtimes = 0;  
  
        /** 
         * ����value��ֵ���÷����Ĳ�����Ϊ2���������໥����������ʵ����һ�������� 
         * ���Ը÷�������ͬ������ǰ���������ڷ���������ʹ��Synchronized�ؼ��֡� 
         * @throws InterruptedException 
         */  
        public void addValue(double v)  {  
            try {
				lock.lock();
				 System.out.println("LockTest to addValue: " + v + "   "  
		                    + System.currentTimeMillis());  
		            try {  
		                Thread.sleep(1000);  
		            } catch (InterruptedException e) {  
		            }  
		            this.value += v;  
		            this.addtimes++;  
			} catch(Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}// ȡ����  
			finally{
				lock.unlock();// �ͷ���  
			}
           
            
        }  
  
        public double getValue() {  
            return this.value;  
        }  
    } 
    
    public static void testLockTest() throws Exception{  
        final LockTest lockTest = new LockTest();  
        // �½�����1������lockTest��addValue����  
        Runnable task1 = new Runnable(){  
            public void run(){  
                lockTest.addValue(55.55);  
            }  
        };  
       Thread a = new Thread(task1, "aa");
       Thread b = new Thread(task1, "bb");
       a.start();
       b.start();
       b.interrupt();
       
    }  
    
    public static void main(String[] args) throws Exception {
    	testLockTest() ;
	}
}
