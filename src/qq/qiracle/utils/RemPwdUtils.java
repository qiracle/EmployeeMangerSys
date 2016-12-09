package qq.qiracle.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class RemPwdUtils {
	
	public static void writePwd(String name,String pwd,boolean flag){
		
		try {
			FileOutputStream fos =new FileOutputStream("1.txt");
			String info =name+"="+pwd+"="+flag;
			fos.write(info.getBytes());
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static String readPwd(){
		
		try {
			FileInputStream fis =new FileInputStream("1.txt");
			
			int len=0;
			byte[] b =new byte[1024];
			while((len=fis.read(b))!=-1){
				//System.out.print(new String(b));
			}
			fis .close();
			
			return new String(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
