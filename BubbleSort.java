/*
 * Java Programming Language
 */
 
public class BubbleSort
{

	public static void main (String[] args)
   {
		// An array of integers
		int[] array = {34, 56, 4, 10, 77, 51, 93, 30, 5, 52 };
		int arraySize = array.length;

		// Print the unsorted array
		System.out.println("Unsorted Array");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		
		// Bubble Sort		
		for (int i = 0; i < array.length-1; i++)
		{
			for (int j = i+1; j < array.length; j++)
			{
				if (array[i] > array[j])
				{
					// Swap elements
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

		// Print the sorted array
		System.out.println("\n\nSorted Array");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		System.out.println(" ");
		// System.out.println("Size: " + arraySize);
				
	}
}