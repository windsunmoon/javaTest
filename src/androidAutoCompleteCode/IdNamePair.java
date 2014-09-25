/**   
* @author wangboxuan   
* @date 2014-9-25 下午01:51:23 
* @Description: TODO
* @version V1.0   
*/
package androidAutoCompleteCode;

/**   
 * @author wangboxuan   
 * @date 2014-9-25 
 * @Description:
 */
public class IdNamePair {
	private String  id;
	private String name;
	
	/**
	 * @param id
	 * @param name
	 */
	public IdNamePair(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
