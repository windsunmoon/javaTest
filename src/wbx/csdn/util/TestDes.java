package wbx.csdn.util;

public class TestDes{
	
	public static void main(String[] args) throws Exception {
		String str = "wbxnf";
		
		DES d1 = new DES();
		
		String res1 = d1.encrypt(str);
		System.out.println(res1);
		System.out.println(d1.decrypt(res1));
		
		DES d2 = new DES(1);
		
		String res2 = d2.encrypt(str);
		
		System.out.println(res2);
		System.out.println(d2.decrypt(res2));
		
		String res3 =  BCrypt.hashpw(str, BCrypt.gensalt());
		System.out.println(res3);
		
		System.out.println(BCrypt.checkpw(str, res3));
		System.out.println(BCrypt.checkpw(str, "$2a$10$LzCfIZzmd7ZIwE5CgwRMGOla0tQR25/P9lI3CLiJirjZ5gmNsKKCq"));


	}
	
}