/**   
* @author wangboxuan   
* @date 2014-11-7 下午03:24:59 
* @Description: TODO
* @version V1.0   
*/
package wbx;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**   
 * @author wangboxuan   
 * @date 2014-11-7 
 * @Description:
 */
public class TestGjson {

	public static void main(String[] args) {
		
		List<String> aa = new ArrayList<String>();
		aa.add("aaaa");
		
		aa.add("bbbb");
		aa.add("cccc");
		
		List<Student> bb = new ArrayList<Student>();

		bb.add(new Student());
		
		bb.add(new Student());
		bb.add(new Student());
		 System.out.println(bb);

		Gson s= new Gson();
		
		
		String res =  s.toJson(aa);
		String res1 =  s.toJson(bb);

		System.out.println(res);
		System.out.println(res1);

		
//		 List<String> temp = GjsonUtil.jsontoList(res,"");
		 List<Student> temp1 = new  GjsonUtil<Student>().jsontoList(res1);
		 Type cc = new TypeToken<List<Student>>(){}.getType();

//		 System.out.println(s.fromJson(res1, cc));
		 
		 System.out.println("%%%%   "+s.fromJson(res1, bb.getClass()));

//		 System.out.println(temp);
		 System.out.println(temp1);
		 System.out.println(s.fromJson(res1, cc));

		 System.out.println("%%%%   "+s.fromJson(res1, bb.getClass()));

	}
	
	
}

class Student{
	int id =1 ;
	String name = "aa";
}
