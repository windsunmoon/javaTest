/**   
* @author ������   
* @date 2013-11-25 ����04:49:54 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @version V1.0   
*/
package wbx;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**   
 * @author ������   
 * @date 2013-11-25 
 * @Description:
 * @version V1.0   
 */
public class TestStringBuilder {
     public  static void build() throws IOException{
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\testdbsql.sql"), "UTF-8"));
			String strLine;
			StringBuilder sb = new StringBuilder();
			while ((strLine = reader.readLine()) != null) {
				// ���������#��ͷ��ע��,����ΪSQL���,�����SQL����.
				if ((!strLine.contains("--"))&&(!strLine.startsWith("#"))) {
					sb.append(strLine);
				}
			}
			System.out.println(sb);
     }
}
