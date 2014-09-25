/**   
* @author 王柏轩   
* @date 2014-2-10 下午03:54:15 
* @Description: TODO(用一句话描述该文件做什么) 
* @version V1.0   
*/
package wbx;

/**   
 * @author 王柏轩   
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

