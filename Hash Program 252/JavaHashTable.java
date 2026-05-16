/*
 * This class is a Hash Table using Java HashMap that implements the StringCounter interface.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class JavaHashTable implements StringCounter
{

	private HashMap<String, Integer> table = new HashMap<String, Integer> ();
	private int numEntries;
	
	// IncCount increments the count for a particular string
	public void IncCount(String s)
	{
    if(table.containsKey(s)){
      int value = table.get(s);
      value++;
      table.put(s, value);
    }else{
      table.put(s, 1);
    }
	}

	// GetSize returns the number of strings
	public int GetSize()
	{
		return table.size();
	}

	// GetCounts returns an array of all the string-count pairs
	// in the dictionary, sorted lexicographically by strings.
	// We've defined a StringCount container class
	// above to store the String-int pairs.
	public StringCount[] GetCounts()
	{
    numEntries = table.size();
    int entries = 0;
		StringCount[] counts = new StringCount[numEntries];
    Set set = table.entrySet();
    Iterator iterator = set.iterator();

    while(iterator.hasNext()){
      Map.Entry entry = (Map.Entry)iterator.next();
      String key = (String)entry.getKey();
      int value = (int)entry.getValue();
      insertionSort(new StringCount(key, value), counts, entries);
      entries++;
    }
		return counts;
	}

	// insertionSort inserts the string count s into the proper place in the array
	public void insertionSort(StringCount s, StringCount[] array, int entries)
	{
		int insert = 0;

		for (int i = 0; i < entries; i++, insert++)
		{
			if(s.str.compareTo(array[i].str) <= 0)
				break;
		}

		if(insert == entries)
			array[insert] = s;
		else
		{
			for(int i = entries; i > insert; i--)
				array[i] = array[i-1];

			array[insert] = s;
		}
	}

	// main for unit testing
	public static void main(String[] args)
	{
		System.out.println("Hash Table Testing");

		JavaHashTable table = new JavaHashTable();

		table.IncCount("hello");
		table.IncCount("hello");

		table.IncCount("world");
		table.IncCount("world");
		table.IncCount("world");
		table.IncCount("world");

		table.IncCount("Happy Thanksgiving!");
		table.IncCount("Happy Thanksgiving!");
		table.IncCount("Happy Thanksgiving!");

		table.IncCount("Food");
		table.IncCount("Food");
		table.IncCount("Food");
		table.IncCount("Food");
		table.IncCount("Food");
		table.IncCount("Food");
		table.IncCount("Food");

		table.IncCount("cool");

		table.IncCount("Assignment due");
		table.IncCount("Assignment due");

		table.IncCount("Wednesday");

		table.IncCount("night");
		table.IncCount("night");

		table.IncCount("at");

		table.IncCount("TWELVE!!!");
		table.IncCount("TWELVE!!!");
		table.IncCount("TWELVE!!!");
		table.IncCount("TWELVE!!!");
		table.IncCount("TWELVE!!!");

		StringCount[] counts = table.GetCounts();
		String output = "";

		for(int i = 0; i < counts.length; i++)
		{
			if(counts[i] != null)
			{
				System.out.print("[" + counts[i].str +"," + counts[i].cnt + "], ");
				output += "[" + counts[i].str +"," + counts[i].cnt + "], ";
			}
			else
				System.out.print("NULL!!!!! " + i);
		}

		System.out.println();

		if(output.compareTo("[Assignment due,2], [Food,7], [Happy Thanksgiving!,3], [TWELVE!!!,5], [Wednesday,1], [at,1], [cool,1], [hello,2], [night,2], [world,4], ") == 0)
			System.out.println("Success! Output is correct.");
		else
			System.out.println("Failure! The output wasn't correct. Output was: \"" + output +"\"");
	}
}
