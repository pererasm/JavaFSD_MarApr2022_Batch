package smPackage.Modules;

import java.util.List;
import java.util.ArrayList;

public class EvenOddModule 
{
	public EvenOddModule(int number)
	{
		this.startRange = number;
		this.endRange = number;
		this.singleNumber = true;
		sortEvenNumbers();
	}
	
	public EvenOddModule(int startRange, int endRange)
	{
		if (startRange > endRange)
		{
			var temp = startRange;
			startRange = endRange;
			endRange = temp;
		}
		
		if (startRange == endRange)
		{
			this.singleNumber = true;
		}
		
		this.startRange = startRange;
		this.endRange = endRange;
		sortEvenNumbers();
	}
	
	private Boolean isEven = false;
	private Boolean singleNumber = false;
	private int startRange;
	private int endRange;
	private List<Integer> evenNumbers = new ArrayList<Integer>();
	private List<Integer> oddNumbers = new ArrayList<Integer>();
	
	public void sortEvenNumbers()
	{
		if (singleNumber == false)
		{
			for (int i = startRange; i <= endRange; i++)
			{
				if (i%2 == 0)
				{
					evenNumbers.add(i);
				}
				else
				{
					oddNumbers.add(i);
				}
			}
		}
		else
		{
			if (startRange%2 == 0)
			{
				isEven = true;
			}
			else
			{
				isEven = false;
			}
		}
	}
	
	public List<Integer> getEvenNumbers()
	{
		return evenNumbers;
	}
	
	public List<Integer> getOddNumbers()
	{
		return oddNumbers;
	}
	
	public Boolean isNumberEven()
	{
		return isEven;
	}
}
