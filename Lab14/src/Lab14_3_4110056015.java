import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
public class Lab14_3_4110056015
{
	public static void main(String[] args)
	{
		HashMap<Integer, ArrayList<String>> students =
			new HashMap<Integer, ArrayList<String>>();
		String line;
		int studentID;
		String course;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter student ID followed by course number, -1 to exit.");
		do
		{
			line = keyboard.nextLine();
			// code here
			String[] a = line.split(" ");
			studentID = Integer.parseInt(a[0]);
			course = a[1];
			if(students.containsKey(studentID))
				students.get(studentID).add(course);
			else {
				ArrayList<String> c = new ArrayList<String>();
				c.add(course);
				students.put(studentID,c);
			}
			
		} while (!line.equals("-1"));

		System.out.println();
		for (Integer key : students.keySet())
		{
			System.out.println("For student: " + key);
			for (String cls : students.get(key))
			{
				System.out.print(cls + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
}
