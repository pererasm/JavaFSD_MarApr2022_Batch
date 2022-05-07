package mainPackage.Resources;

import java.util.Scanner;

import mainPackage.Program;
import mainPackage.Helpers.Errors;

public class UserInput
{
	private Scanner input;
	private Boolean showError = false;
	
	public UserInput()
	{
		this.showError = Program.getOptions().getShowError();
		setScanner();
	}
	
	private void setScanner()
	{
		input = new Scanner(System.in);
	}
	
	public void closeScanner()
	{
		input.close();
	}
	
	public Integer getInteger()
	{
		//setScanner();
		var returnValue = -1;
		try 
		{
			returnValue = input.nextInt();
			return returnValue;
		} 
		catch (Exception e)
		{
			Errors.printError("Please Enter a vaild Input:", e.getMessage(), showError);
			return returnValue;
		}
		finally
		{
			//closeScanner();
		}
	}
	
	public String getString()
	{
		setScanner();
		var returnValue = "";
		try 
		{
			returnValue = input.next();
			return returnValue;
		} 
		catch (Exception e)
		{
			Errors.printError("Please Enter a vaild Input:", e.getMessage(), showError);
			return returnValue;
		}
		finally
		{
			//closeScanner();
		}
	}

	//public Boolean getIsShowErrorsEnableds() {
	//	return isShowErrorsEnabled;
	//}

	public void setIsShowErrorsEnableds(Boolean isShowErrorsEnableds) {
		this.showError = isShowErrorsEnableds;
	}
}
