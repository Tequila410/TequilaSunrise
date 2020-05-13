package  webadv.s99201105.p02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.apache.commons.codec.digest.DigestUtils;
public class App {
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("psw.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("17202105");
		bw.write("\n");
		bw.write(sha256hex("gxr123456"));
		bw.close();
		fw.close();
		
    	Scanner in = new Scanner(System.in);
    	System.out.println("Please input your account:");
    	String id=in.nextLine();
    	System.out.println("Please input your password:");
    	String psw=in.nextLine();
		try {
			FileReader fr = new FileReader("psw.txt");
			BufferedReader bf=new BufferedReader(fr);
			try {
				String rId = bf.readLine();
				String rPsw= bf.readLine();
				bf.close();
		    	fr.close();
		    	if(id.equals(rId)&&sha256hex(psw).equals(rPsw)) {
		    		System.out.println("登陆成功！");
		    	}else {
		    		System.out.println("登陆失败！");
		    	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    public static String sha256hex(String input) {
        return DigestUtils.sha256Hex(input);
    }
}
