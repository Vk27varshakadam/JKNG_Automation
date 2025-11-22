package test2;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class Rnd 
{
	@Test
	public void timecheck()
	{
		
		Date d1 = new Date();
		String tod = new SimpleDateFormat("ddMMyyyy--HHmmss").format(d1);
		System.out.println(tod);
		String s2[] = tod.split("--");
		String tddate = s2[0];
		String crntime = s2[1];
		
		System.out.println("current time is "+crntime);
		
		String datedd = tddate.substring(0, 2);
		System.out.println(datedd);
		String datemm = tddate.substring(2, 4);
		System.out.println(datemm);
		
	}
	
}
