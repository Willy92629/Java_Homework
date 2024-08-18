import java.util.Arrays;
public class Lab11_2_4110056015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] students = new Student[5];
		
		students[0] = new Student("Lin" , 99);
		students[1] = new Student("Liu" , 99);
		students[2] = new Student("Chang" , 34);
		students[3] = new Student("Chiu" , 57);
		students[4] = new Student("Chen" , 63);
		
		Arrays.sort(students);
		
		for(int i=0;i< students.length;i++) {
			System.out.println( students[i].toString());
		}
	}

}

class Student implements Comparable<Object>{
	private String lastName;
	private int ID;
	
	public Student(String theName, int theID) {
		lastName = theName;
		ID = theID;
	}
	public int compareTo(Object other) {
		Student temp = (Student) other;
		if(ID > temp.ID) 
			return 1;
		else if(ID < temp.ID) 
			return -1;
		else
			return 0;
	}
	public String toString() {
		return (lastName +" "+ ID);
	}
}