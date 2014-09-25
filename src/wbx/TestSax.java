/**   
* @author wangboxuan   
* @date 2014-9-24 下午01:43:26 
* @Description: TODO
* @version V1.0   
*/
package wbx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**   
 * @author wangboxuan   
 * @date 2014-9-24 
 * @Description:
 */
public class TestSax  extends DefaultHandler{
	
	private   List<IdNamePair> map = new ArrayList<IdNamePair>();

	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("-------------------------------------");
		
		String tempid = attributes.getValue("android:id");
		String id = null;
		if (tempid!=null) {
			String[] ss  = tempid.split("/");
			if (ss!=null && ss.length==2) {

				id = ss[1];
			}
		}
		if (id!=null) {
			map.add(new IdNamePair(id,qName));

		}
		System.out.println(id);
		System.out.println(qName);
		
	}
	
	
	public  List<IdNamePair> getRes(){
		return map;
		
	}
	
	
	
	/**   
	 * @date 2014-9-24
	 * @Description: 
	 * @param   
	 * @return void
	 * @throws ParserConfigurationException 
	 * @throws Exception 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	
	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		SAXParserFactory saxfac = SAXParserFactory.newInstance();   
		TestSax mySax = new TestSax();
		saxfac.newSAXParser().parse(new File("./res/report.xml"),mySax);
		
		List<IdNamePair> res = mySax.getRes();
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		sb.append("//---------- 开始定义域--------------\n");
		sb1.append("//----------开始initView方法------------------\n");
		sb1.append("public void initView() { \n");

		for (IdNamePair idNamePair : res) {
			sb.append(" private "+idNamePair.getName()+"  "+ idNamePair.getId()+idNamePair.getName()+";\n");
		    
			sb1.append("    "+idNamePair.getId()+idNamePair.getName()+" = ("+idNamePair.getName()+")findViewById(R.id."+idNamePair.getId()+");\n");
		
		}
		sb1.append("}\n");
		
		System.out.println(sb.toString());
		System.out.println(sb1.toString());
	}
	
	
}

class IdNamePair{
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
