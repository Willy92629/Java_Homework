import java.util.ArrayList;
import java.util.Iterator;

public class Lab14_2_4110056015 {
	public static void main(String[] args)
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		// Generate numbers from 2 to 100
		for (int i=2; i<=100; i++)
		{
			/*code here*/
			numbers.add(i);
		}

		// Start the sieve
		for (int i=0; i < numbers.size()-1; i++)
		{
			// Get the number at position i
			int currentVal = numbers.get(i);
			// Get an iterator for the next number
			Iterator<Integer> scanIterator = numbers.listIterator(i+1);
			// Scan through remainder of list for multiples, removing
			// the element if it is a multiple if currentVal
			while (scanIterator.hasNext())
			{
				/*code here*/
				if(scanIterator.next() % currentVal ==0) {
					scanIterator.remove();
				}
			}
		}

		// Output all values remaining in the ArrayList
		System.out.println("Prime numbers from 2 to 100:");
	    /*code here*/
		System.out.print(numbers);
	}
}
