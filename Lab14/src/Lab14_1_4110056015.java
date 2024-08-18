import java.util.*;

public class Lab14_1_4110056015 {

	public static void main(String[] args) {
		HashSet<Integer> hset = new HashSet<Integer>();
		hset.add(36);
		hset.add(15);
		TreeSet<Integer> tset = new TreeSet<Integer>();
		tset.add(52);
		tset.add(23);
		tset.add(32);
		tset.add(69);
		tset.add(10);
		tset.add(7);
		tset.add(36);
		tset.add(15);
		
		System.out.println("HashSet:" + hset);
		System.out.println("TreeSet:" + tset);
		tset.remove(32);
		System.out.println("element 32 of tset has been deleted...");
		System.out.println("tset content after deletion:" + tset);
		System.out.println("Is tset contains all the elements in hset?");
		if(tset.containsAll(hset))
			System.out.print("Yes!");
		else
			System.out.print("No!");

	}

}
