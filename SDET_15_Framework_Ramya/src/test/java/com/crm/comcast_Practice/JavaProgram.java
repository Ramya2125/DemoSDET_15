package com.crm.comcast_Practice;



import org.testng.Reporter;
import org.testng.annotations.Test;

public class JavaProgram {
	@Test
	public void Seperatechar() {
		String s="ja$%va";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>=65 && s.charAt(i)<=122) {
				System.out.print(s.charAt(i));
			}
		}
	}
	
	
	

}
