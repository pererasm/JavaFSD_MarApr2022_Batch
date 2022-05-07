package mainPackage;


import mainPackage.Helpers.Errors;
import mainPackage.Helpers.MenuHandler;
import mainPackage.Models.Options;
import mainPackage.Resources.MainDisplayElements;
import mainPackage.Resources.UserInput;

public class Program
{
	private static Options option = new Options();
	
	private static Boolean run = true;
	
	public static Options getOptions() {
		return option;
	}

	public static void setOptions(Options options) {
		option = options;
	}
	
	public static Boolean getRun() {
		return run;
	}

	public static void setRun(Boolean run) {
		Program.run = run;
	}
	
	public static void main(String[] args)
	{
		MainDisplayElements.welcomeScreen();
		
		UserInput input = new UserInput();
		
		while (run)
		{
			MenuHandler.mainFunction(input);
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				Errors.printError("Thread Sleep Error", e.getMessage(), getOptions().getShowError());
			}
		}
	}

}
