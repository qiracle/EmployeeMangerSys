package qq.qiracle.utils;

public class TestUtils {
	
	public static void main(String[] args) {
		RemPwdUtils.writePwd("qwe", "456",true);
		String readPwd = RemPwdUtils.readPwd();
		
		//System.out.println(readPwd);
	}

}
