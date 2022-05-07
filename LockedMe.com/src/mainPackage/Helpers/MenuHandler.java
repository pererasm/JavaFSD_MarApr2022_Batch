package mainPackage.Helpers;

import java.util.List;

import mainPackage.Program;
import mainPackage.Resources.MainDisplayElements;
import mainPackage.Resources.UserInput;

public class MenuHandler
{
	public static void mainFunction(UserInput input)
	{
		Integer functionNumber = 0;
		MainDisplayElements.mainMenu();
		functionNumber = input.getInteger();
		
		var fileName = "";
		List<String> list = null;
		
		FilesHandler fh = new FilesHandler();
		switch (functionNumber)
		{
			case 1:
				list = fh.getListOfFileNames();
				for (var file : list)
				{
					System.out.println(file);
				}
				break;
			case 2:
				System.out.print("Please Enter the File Name\n? ");
				fileName = input.getString();
				System.out.println("Please Enter the number of lines for the file\n? ");
				var nl = input.getInteger();
				System.out.print("Please Enter the File Content\n? ");
				var fileContent = "";
				for (var i = 0; i < nl; i++)
				{
					fileContent += input.getString();
					fileContent += "\n";
				}
				fh.addTxtFile(fileName, fileContent);
				break;
			case 3:
				System.out.print("Enter the File Name to delete. (Note: Delete is CASE SENSITIVE)\n? ");
				fileName = input.getString();
				list = fh.getListOfFileNames();
				var isDeleted = false;
				for(var file : list)
				{
					if (file.equals(fileName))
					{
						fh.deleteFile(fileName);
						isDeleted = true;
					}
				}
				if (!isDeleted)
				{
					System.out.println("File Not Found");
				}
				break;
			case 4:
				System.out.println("Enter the File Name to check if exist\n? ");
				fileName = input.getString();
				fh.checkFileExistByName(fileName);
				break;
			case 5:
				MainDisplayElements.optionsMenu();
				optionFunction(input);
				break;
			case 9:
				input.closeScanner();
				Program.setRun(false);
				break;
			default:
				System.out.println("Please enter a valid Number in the Menu");
				break;
		}
		System.out.println("\n");
	}
	
	public static void optionFunction(UserInput input)
	{
		Integer functionNumber = 0;
		functionNumber = input.getInteger();
		var option = 0;
		switch (functionNumber)
		{
			case 1:
				System.out.print("Enter new path\n? ");
				Program.getOptions().setCurrentPath(input.getString());
				break;
			case 2:
				System.out.print("Append Data if the file exsist:\n[1] True\n[0] False\n? ");
				option = input.getInteger();
				if (option == 1)
				{
					Program.getOptions().setAppendData(true);
				}
				else
				{
					Program.getOptions().setAppendData(false);
				}
				break;
			case 3:
				System.out.print("Show Delete Comfirmation:\n[1] True\n[0] False\n? ");
				option = input.getInteger();
				if (option == 1)
				{
					Program.getOptions().setShowDeleteDialog(true);
				}
				else
				{
					Program.getOptions().setShowDeleteDialog(false);
				}
				break;
			case 4:
				System.out.print("Show Error Messages:\n[1] True\n[0] False\n? ");
				option = input.getInteger();
				if (option == 1)
				{
					Program.getOptions().setShowError(true);
				}
				else
				{
					Program.getOptions().setShowError(false);
				}
				break;
			case 5:
				System.out.print("Add 'txt' extension is not present when creating a new file:\n[1] True\n[0] False\n? ");
				option = input.getInteger();
				if (option == 1)
				{
					Program.getOptions().setAddTxtExtension(true);
				}
				else
				{
					Program.getOptions().setAddTxtExtension(false);
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Please enter a valid Number in the Menu");
				break;
		}
	}
}
