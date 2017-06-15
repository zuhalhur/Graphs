import java.util.ArrayList;

public class Book {
	
	public int weight;
	public int value;
	
	public Book(int weight, int value) 
	{
		this.weight = weight;
		this.value = value;
	}
	
	@Override
	public String toString() 
	{
		return "Weight : " + weight + ", Value : " + value;
	}
	
}
