/**   
* @author 王柏轩   
* @date 2013-12-23 上午11:29:57 
* @Description: TODO(用一句话描述该文件做什么) 
* @version V1.0   
*/
package wbx;

import java.util.concurrent.atomic.AtomicReference;

/**   
 * @author 王柏轩   
 * @date 2013-12-23 
 * @Description:
 * @version V1.0   
 */
public class CLHlockqueue {

	private final ThreadLocal<Node> node;
	
	private final ThreadLocal<Node> pre;
	
	private final AtomicReference<Node> tali = new AtomicReference<CLHlockqueue.Node>( new Node());
	
	
	
	
	public CLHlockqueue() {
		
		node = new ThreadLocal<CLHlockqueue.Node>(){ 
			protected Node initialValue() {
				return new Node();
			};
		};
		
		pre = new ThreadLocal<CLHlockqueue.Node>(){ 
			protected Node initialValue() {
				return new Node();
			};
		};
		
	}

	
	public void lock(){
        final Node node = this.node.get();  
        node.locked = true;
        
        Node pred  = this.tali.getAndSet(node);
        this.pre.set(pred);
        while (pred.locked){
			
		}
		
	}
	
	public void unLock(){
		  final Node node = this.node.get(); 
		  node.locked = false;
		  this.node.set(pre.get());//相当于当前的node 移除队列，优化gc,否则会一直被保持引用。
		  //当执行unlock的时候，可以保证pre.get 所得到的节点一定未被锁定。
		  
	}


	class Node{
		private volatile boolean locked = false;
	}
}

