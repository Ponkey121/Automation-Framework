package spotdraft.test;

import org.testng.annotations.DataProvider;

public class dataprovider {
	
	
	
	@DataProvider
	public Object[][] login()
	{
		Object[][] provid = new Object[1][2] ;
		
		provid [0][0] = "varunkapil77@gmail.com";
		provid [0][1] = "Varun@121";

		
		return provid ;
	}
	
	

}
