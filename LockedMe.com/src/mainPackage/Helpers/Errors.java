package mainPackage.Helpers;

public class Errors
{
	public static void printError(String message, String error, Boolean isShowErrorsEnabled)
	{
		if (isShowErrorsEnabled)
		{
			System.out.println(message + ": \n" + error);
		}
		else
		{
			System.out.println(message);
		}
		
	}
	
	public static void printError(String message, String error)
	{
		System.out.println(message);
	}
}
