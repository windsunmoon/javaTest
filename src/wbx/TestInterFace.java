/**   
* @author ������   
* @date 2014-2-10 ����03:54:15 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @version V1.0   
*/
package wbx;

/**   
 * @author ������   
 * @date 2014-2-10 
 * @Description:
 * @version V1.0   
 */
public class TestInterFace implements b{

	@Override
	public void aa() {
		// TODO Auto-generated method stub
		
	}
	
	a aa = new TestInterFace();
	b bb = new TestInterFace();

}

interface a{
	void aa();
}

interface b extends a{
	void aa();
}

