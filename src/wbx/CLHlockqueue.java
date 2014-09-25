/**   
* @author ������   
* @date 2013-12-23 ����11:29:57 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @version V1.0   
*/
package wbx;

import java.util.concurrent.atomic.AtomicReference;

/**   
 * @author ������   
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
		  this.node.set(pre.get());//�൱�ڵ�ǰ��node �Ƴ����У��Ż�gc,�����һֱ���������á�
		  //��ִ��unlock��ʱ�򣬿��Ա�֤pre.get ���õ��Ľڵ�һ��δ��������
		  
	}


	class Node{
		private volatile boolean locked = false;
	}
}

