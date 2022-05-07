package mainPackage.Models;

import java.io.File;
import java.nio.file.Paths;

public class Options 
{
	private Boolean showError = true;
	private Boolean appendData = true;
	private Boolean showDeleteDialog = true;
	private Boolean addTxtExtension = true;
	private String currentPath = Paths.get(new File("").getAbsolutePath(), "SearchDirectory").toString();
	
	public Boolean getShowError()
	{
		return showError;
	}
	
	public void setShowError(Boolean showError)
	{
		this.showError = showError;
	}
	
	public Boolean getAppendData()
	{
		return appendData;
	}
	
	public void setAppendData(Boolean appendData)
	{
		this.appendData = appendData;
	}
	
	public Boolean getShowDeleteDialog()
	{
		return showDeleteDialog;
	}
	
	public void setShowDeleteDialog(Boolean showDeleteDialog)
	{
		this.showDeleteDialog = showDeleteDialog;
	}
	
	public Boolean getAddTxtExtension() {
		return addTxtExtension;
	}

	public void setAddTxtExtension(Boolean addTxtExtension) {
		this.addTxtExtension = addTxtExtension;
	}

	public String getCurrentPath()
	{
		return currentPath;
	}
	
	public void setCurrentPath(String currentPath)
	{
		this.currentPath = currentPath;
	}
}
