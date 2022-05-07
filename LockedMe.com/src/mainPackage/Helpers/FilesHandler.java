package mainPackage.Helpers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mainPackage.Program;
import mainPackage.Models.Options;
import mainPackage.Resources.UserInput;

public class FilesHandler
{
	private String directoryPath = "";
	
	private Options option = null;
	
	public String getDirectoryPath() {
		return directoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}
	
	public FilesHandler()
	{
		this.option = Program.getOptions();
		setDirectoryPath(option.getCurrentPath());
	}
	
	public File[] getFiles()
	{
		try
		{
		File directoryPath = new File(getDirectoryPath());
		File filesList[] = directoryPath.listFiles();
		return filesList;
		}
		catch (Exception e)
		{
			Errors.printError("Invaild Directory path or Do not have access to the Directory", e.getMessage(), option.getShowError());
			return null;
		}
	}
	
	public void checkFileExistByName(String fileName)
	{
		File file = new File(getDirectoryPath() + File.separatorChar + fileName);
		if (file.exists())
		{
			System.out.println("File Exist");
		}
		else
		{
			System.out.println("File Do Not Exist");
		}
	}
	
	public File[] getFilesCaseSensitive(String search)
	{
		try
		{
		File directoryPath = new File(getDirectoryPath());
		File filesList[] = directoryPath.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.contains(search);
		    }
		});
		return filesList;
		}
		catch (Exception e)
		{
			Errors.printError("Invaild Directory path or Do not have access to the Directory", e.getMessage(), option.getShowError());
			return null;
		}
	}
	
	public List<String> getListOfFileNames()
	{
		var files = getFiles();
		var fileList = new ArrayList<String>();
		
		if (files != null)
		{
			for(var file : files)
			{
				fileList.add(file.getName());
			}
		}
		
		return fileList;
	}
	
	public List<String> getListOfFileNamesCaseSensitive(String search)
	{
		var files = getFilesCaseSensitive(search);
		var fileList = new ArrayList<String>();
		
		if (files != null)
		{
			for(var file : files)
			{
				fileList.add(file.getName());
			}
		}
		
		return fileList;
	}
	
	public void addTxtFile(String fileName, String fileContent)
	{
		try
		{
			if (!fileName.contains("."))
			{
				if (option.getAddTxtExtension())
				{
					fileName += ".txt";
				}
			}
			FileWriter fw = new FileWriter(option.getCurrentPath() + File.separatorChar + fileName, option.getAppendData());
		    BufferedWriter bw = new BufferedWriter(fw);
		    bw.write(fileContent);
		    bw.newLine();
		    bw.close();
		}
		catch (IOException e)
		{
			Errors.printError("There was an error while adding the file", e.getMessage(), option.getShowError());
		}
		catch (Exception e)
		{
			Errors.printError("Some unknow error occurred", e.getMessage(), option.getShowError());
		}
	}
	
	public void deleteFile(String fileName)
	{
		var file = new File(option.getCurrentPath() + File.separatorChar + fileName);
		try {
			if (file.exists())
			{
				var ivalue = deleteDialog(fileName);
				
				if (ivalue == 1)
				{
					file.delete();
				}
			}
			else
			{
				System.out.println("File Not Found");
			}
		}
		catch (Exception e)
		{
			Errors.printError("Error while deleting the file", e.getMessage(), option.getShowError());
		}
	}
	
	public Integer deleteDialog(String fileName)
	{
		if (option.getShowDeleteDialog())
		{
			System.out.println("\nDo you want to delete the file: " + fileName + "\n[1] Yes\n[9] No\n\n? ");
			UserInput input = new UserInput();
			return input.getInteger();
			
		}
		
		else
		{
			return 1;
		}
	}
}
