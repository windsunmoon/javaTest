/**   
* @author 王柏轩   
* @date 2014-1-16 下午04:46:25 
* @Description: TODO(用一句话描述该文件做什么) 
* @version V1.0   
*/
package wbx;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**   
 * @author 王柏轩   
 * @date 2014-1-16 
 * @Description:
 * @version V1.0   
 */
public class TestUtilLock {

    public static class LockTest {  
    	  
        Lock lock = new ReentrantLock();// 锁  
        double value = 0d; // 值  
        int addtimes = 0;  
  
        /** 
         * 增加value的值，该方法的操作分为2步，而且相互依赖，必须实现在一个事务中 
         * 所以该方法必须同步，以前的做法是在方法声明中使用Synchronized关键字。 
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
			}// 取得锁  
			finally{
				lock.unlock();// 释放锁  
			}
           
            
        }  
  
        public double getValue() {  
            return this.value;  
        }  
    } 
    
    public static void testLockTest() throws Exception{  
        final LockTest lockTest = new LockTest();  
        // 新建任务1，调用lockTest的addValue方法  
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
