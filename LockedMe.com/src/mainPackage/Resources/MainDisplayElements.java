package mainPackage.Resources;

import java.io.File;
import java.nio.file.Paths;

import mainPackage.Program;

public class MainDisplayElements 
{
	public static void welcomeScreen()
	{
		var welcomeText = 
				  "**********************************************************\n"
				+ "*    Welcome to LockedMe.com - Developed by SM Perera    *\n"
				+ "**********************************************************\n\n\n";
		
		System.out.println(welcomeText);
	}
	
	public static void mainMenu()
	{
		var path = Paths.get(new File("").getAbsolutePath(), "SearchDirectory").toString();
		mainMenu(path);
	}
	
	public static void mainMenu(String path)
	{
		var menuItems =
				  "Current Folder Path:\n" + path + "\n\n"
				+ "[1] View the files in the Folder(Accending Order)\n"
				+ "[2] Add File to the Folder\n"
				+ "[3] Delete a File from the Folder\n"
				+ "[4] Find a File\n"
				+ "[5] Options\n"
				+ "[9] Exit\n\n"
				+ "? ";
		System.out.print(menuItems);
	}
	
	public static void optionsMenu()
	{
		var option = Program.getOptions();
		var optionsItems =
				  "[1] Change the current folder: " + option.getCurrentPath() + "\n"
				+ "[2] Append Data if the file exsist: " + option.getAppendData() + "\n"
				+ "[3] Show Delete Confirmation: " + option.getShowDeleteDialog() + "\n"
				+ "[4] Show Error Messages: " + option.getShowError() + "\n"
				+ "[5] Add 'txt' extension is not present when creating a new file: " + option.getAddTxtExtension() + "\n"
				+ "[0] Back to Main Menu\n\n"
				+ "? ";
		System.out.print(optionsItems);
	}
	
	public static void exitMessage()
	{
		System.out.println("Thanks for using LockedMe.com, see you soon");
	}
}
