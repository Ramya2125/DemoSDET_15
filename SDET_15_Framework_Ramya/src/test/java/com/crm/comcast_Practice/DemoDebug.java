package com.crm.comcast_Practice;

import org.testng.annotations.Test;

public class DemoDebug {
@Test
public void SampleDebug() {
	int y=division(10,0);
	System.out.println(y);
}
public int division(int a,int b) {
	int z=a/b;
	return z;
}
}


