package Pages;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;


import Tests.testbase;


public class takeScrnshot extends testbase {
	
	public void teardown(ITestResult result) {
		
		
		// Here will compare if test is failing then only it will enter into if condition
		if(ITestResult.FAILURE==result.getStatus())
		{
			try 
			{
				// Create refernce of TakesScreenshot
				TakesScreenshot ts=(TakesScreenshot)driver;
		 
				// Call method getScreenshotAs to capture screenshot
				File source=ts.getScreenshotAs(OutputType.FILE);
		 
				// Copy files to specific location here it will save all screenshot in our project home directory and
				// result.getName() will return name of test case so that screenshot name will be same
				//FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));
				FileUtils.copyFile(source, new File("D:\\test\\" + result.getName()+".png"));
				//File destination = new File("D:\\test\\" + result.getName()+ ".png");
				
				System.out.println(result.getName());
				
				//FileHandler.copy(source, destination);
		 
				//System.out.println("Screenshot taken"   + destination);
			} 
			catch (Exception e)
			{
		 
				System.out.println("Exception while taking screenshot "+e.getMessage());
			} 
		 
		
		
		
	}

	}
}
