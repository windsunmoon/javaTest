package wbx;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;

public class TestMain {

	/**
	 * @param args
	 */
	
	static aa jj;
	
	public static void main(String[] args) throws IOException {
		
	final	TestLock a =new TestLock();
		
	 Thread aa =	new Thread("aaa"){ public void run(
			
		) { a.a();};};
		
		aa.start();
		
	Thread bb =	new Thread("bbb"){ public void run(
				
		) { a.b();};};
		
		bb.start();
		
		
		
//		TestStringBuilder.build();
	}
//		String src="D:\\workspace\\PublicInspect\\dbSql\\data\\城管案件相关图片\\100\\00\\";
//		
//		for (int i = 2; i < 27; i++) {
//			if (i<10) {
//				moveFile(src+"Event100000"+i+"\\"+"100000"+i+".jpg");
//			}else
//				moveFile(src+"Event10000"+i+"\\"+"10000"+i+".jpg");
			
		
		
	
		
		
//		if (505004.313==505004.313) {
//			System.out.println("true");
//		}
//		
//		System.out.println(getPattern("wbx"));
//		System.out.println("          dssdsd    "+"wbx".matches(getPattern("wbx")));
//		;
//		System.out.println(HanziToPinyin.getPinYin("王"));
//		;
//		
//		System.out.println(jj);
////		// TODO Auto-generated method stub
////      System.out.printf("%x\n",logic_right(0xffabcd11, 4));
////      System.out.printf("%x\n",0xffabcd11);
//		
//		
//		final Integer a =1;
		
	
	
	static void 	moveFile( String file1 ){
		
		//文件原地址 
		File oldFile = new File(file1); 
		
		String newPath = "D:\\workspace\\PublicInspect\\dbSql\\data\\城管案件相关图片\\100\\"; 
		

		//将文件移到新文件里 
		File fnew = new File(newPath +oldFile.getName()); 
		oldFile.renameTo(fnew); 
		
		}
	
	public static int logic_right(int a,int lenth){
		int b=a>>lenth;
		System.out.printf("%x\n",b);
		
		int mask =(~0)<<(32-lenth);
		mask=~mask;
		System.out.printf("%x\n",mask);
		return b&mask;
		
	}

	public static String getPattern(CharSequence s) {
		if (s==null||s.length()==0) {
			return "";
		}
		StringBuilder sb =new StringBuilder();
		sb.append("[a-z0-9]*");
		System.out.println(s.length());
		for(int i=0;i<=s.length()-1;i++) {
			sb.append(s.charAt(i));
			sb.append("[a-z0-9]*");
		}
		
		return sb.toString();
	}

	
	
}

class aa{
	
	public  int s;
	public  float d;
	@Override
	public String toString() {
		return "aa [s=" + s + ", d=" + d + "]";
	}
	
	
	

}
