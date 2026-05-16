/*
 * The WordCount class is designed to count the frequency of each word
 * in a given file.
 */
import java.io.IOException;

public class WordCount {

	/*
	 * This is method takes the given file name, data structure, and booleans to
	 * open the file, store the frequency information in the data structure
	 * and uses the booleans to determine if it needs to print out
	 * the words in descending frequency order and secondarily by lexiographical order.
	 *
	 * @param file The name of the file to read.
	 * @param ADT The type of data structure to use.
	 * @param freq To determine if it needs to print out the word/frequency pairs.
	 * @param unique To determine if it needs to print out how many unique words are in the file.
	 */
   public static void countWords(String file, StringCounter ADT, boolean freq, boolean unique, boolean timing) throws IOException
   {
      String word;
      FileWordReader fwr = new FileWordReader(file);

      long startTime = System.nanoTime();

      while((word = fwr.nextWord()) != null)
         ADT.IncCount(word);

      long endTime = System.nanoTime();

      StringCount[] cnt = ADT.GetCounts();
      if (cnt != null && freq)
      {
    	   cnt = mergeSort(cnt);

         for (int i = 0; i < cnt.length; i++)
            System.out.println(cnt[i].cnt + " \t" + cnt[i].str);

      }
      else if (freq)
         System.out.println("No words found!");

      if (unique)
         System.out.println( "Total number of unique words: " + cnt.length );

      if(timing)
         System.out.println("Time " + (endTime-startTime));
   }

   /*
    * This is an internal method used for the merge sort algorthim.
    * This divides the list in half and then performs a mergesort
    * on each respective half. After each half has been "sorted" correctly
    * the halves are re united to create a sorted list.
    *
    * @param list a list that is needed to be sorted
    * @return an StringCount array which is the sorted version of the given list.
    */
   private static StringCount[] mergeSort( StringCount[] list )
   {
      //base case, if there is one item left, then there is no need to divide
      if ( list.length <=1 )
         return list;

      int mid = list.length / 2;

      StringCount[] left = new StringCount[mid];
      StringCount[] right = new StringCount[list.length - mid];

      for (int i=0; i < list.length; i++) {
         if ( i < mid  )
            left[i] = list[i];
         else
            right[i - mid] = list[i];
      }

      left = mergeSort(left);
      right = mergeSort(right);

      return merge(left, right);
   }

   /*
    * This is an internal method used for the merge sort algorthim.
    * This combines two arrays into one in descending order.
    *
    * @param left This represents the left list
    * @param right This represents the right list
    * @return This returns a new list containing the merged list of left and right.
    */
   private static StringCount[] merge(StringCount[] left, StringCount[] right)
   {
      StringCount[] list = new StringCount[ left.length  + right.length ];

      //counter used for merged list
      int listCounter = 0;

      //counters for the left and right list
      int i = 0, j = 0;

      while (i < left.length && j < right.length)
      {
         if (left[i].cnt > right[j].cnt)
         {
            list[listCounter] = left[i];
            i++;
         }
         else
         {
            list[listCounter] = right[j];
            j++;
         }

         listCounter++;
      }

	  	//appends the remaining of any list (left or right) to the main list.
      if ( i != left.length )
      {
         for ( ; i < left.length; i++)
         {
            list[listCounter] = left[i];
				listCounter++;
			}
      }

      if ( j != right.length )
      {
			for ( ; j < right.length; j++)
         {
				list[listCounter] = right[j];
				listCounter++;
			}

		}

      return list;
   }

   public static void main(String[] args) throws IOException
   {

      StringCounter ADT = null;

      long startTime, endTime;

      boolean freq = false;
      boolean unique = false;
      boolean timing = false;

      int i = 0;

      //Checks to make sure at least a data structure and file is specified.
      if (args.length < 2)
      {
         printUsage();
         System.exit(1);
      }

      if(args[0].equals("-m"))
         ADT = new MyHashTable();

      else if(args[0].equals("-j"))
         ADT = new JavaHashTable();

   	else
      {
   		printUsage();
   		return;
   	}

      i++;

      if (args[i].equals("-frequency"))
      {
    	   i++;
    	   freq = true;
      }

      if (args[i].equals("-unique"))
      {
         i++;
    	   unique = true;
      }

      if (args[i].equals("-time"))
      {
         i++;
    	   timing = true;
      }

      //counts the number of words in the given file.
      countWords(args[i], ADT, freq, unique, timing);
   }

	/*
	 * Prints the usage of this application to standard error.
	 */
   private static void printUsage()
   {
		System.err.println( " java WordCount [ -m | -j ] [ -frequency | -unique | -time] <filename>" );
		System.err.println("\t-m My Hash Table");
		System.err.println("\t-j Java Hash Table");
		System.err.println("\t-frequency Print all the word/frequency pairs, ordered by frequency, and then by the words in lexicographic order");
		System.err.println("\t-unique Print the number of unique words in the document.");
		System.err.println("\t-time Print the time required for the hashing alogorithm.");
		System.err.println("");

	}
}
