/**   
* @author wangboxuan   
* @date 2014-11-7 下午03:25:17 
* @Description: TODO
* @version V1.0   
*/
package wbx;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**   
 * @author wangboxuan   
 * @date 2014-11-7 
 * @Description:
 */
public class GjsonUtil<T> {

	public List<T>  jsontoList(String str){
		
		Type cc = new TypeToken<List<T>>(){}.getType();
		
		Gson son  = new Gson();
		return son.fromJson(str, cc);
	}
}
