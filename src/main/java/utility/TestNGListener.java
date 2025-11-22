package utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import NG.JK.Base;

public class TestNGListener implements ITestListener
{

	@Override
	public boolean isEnabled() 
	{
		// TODO Auto-generated method stub
		return ITestListener.super.isEnabled();
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		
		String ClassName = result.getTestClass().getName();
		String MethodName = result.getMethod().getMethodName();
		
		try 
		{
			ScreenshotHelper.CaptureScreenshot(Base.driver,ClassName,MethodName," onTestStart");
			
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		String ClassName = result.getTestClass().getName();
		String MethodName = result.getMethod().getMethodName();
		
		try 
		{
			ScreenshotHelper.CaptureScreenshot(Base.driver,ClassName,MethodName," onTestSuccess");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		String ClassName = result.getTestClass().getName();
		String MethodName = result.getMethod().getMethodName();
		
		try 
		{
			ScreenshotHelper.CaptureScreenshot(Base.driver,ClassName,MethodName," onTestFailure");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	
	
}
