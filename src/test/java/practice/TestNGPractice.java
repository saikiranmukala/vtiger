package practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPractice {

	@Test(priority = 2)
	public void createUser()
	{
		System.out.println("User created");
	}
	
	@Test(priority = 1, dependsOnMethods = {"createUser"})
	public void modifyUser()
	{
		System.out.println("User modified");
	}
	
	@Ignore
	@Test(priority = 3)
	public void deleteUser()
	{
		System.out.println("User deleted");
	}
	
}
