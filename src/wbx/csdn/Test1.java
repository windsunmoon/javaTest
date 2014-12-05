/**   
* @author wangboxuan   
* @date 2014-9-25 下午05:58:33 
* @Description: TODO
* @version V1.0   
*/
package wbx.csdn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**   
 * @author wangboxuan   
 * @date 2014-9-25 
 * @Description:
 */
public class Test1 {
ArrayList<E>
	/*
	 * {sn:'112304111',month:09,count:3},
 {sn:'112304111',month:10,count:2},
 {sn:'112304111',month:08,count:4},
 {sn:'110942231',month:08,count:1},
 {sn:'110942231',month:09,count:3},
 {sn:'110942231',month:10,count:2}
	 */
	/**   
	* @date 2014-9-25
	* @Description: 
	* @param   
	* @return void
	*/
	public static void main(String[] args) {
		List<Map<String, String>> source = new ArrayList<Map<String,String>>();
		Map<String, String> a = new HashMap<String, String>();
		a.put("sn", "112304111");
		a.put("month", "10");
		a.put("count", "2");

		//其他省略
		
		source.add(a);
		
		Map<String,List<Map<String, String>>> res =new HashMap<String,List<Map<String,String>>>();
		for (Map<String, String> map : source) {
			 String sn = map.get("sn");
			 if (res.get(sn)==null) {
				 List<Map<String, String>> temp = new ArrayList<Map<String,String>>();
				 temp.add(map);
				 res.put(sn, temp);
			 }else{
				 res.get(sn).add(map);
			 }
		}
		
		//下面构造json 
		
		for (int i = 0; i < res.size(); i++) {
			
		}
		
	}
}
