
public class Lab10_1_4110056015 {
	
	
	public static void main(String[] args) {
		Movie central = new Movie("Central Station", 113, 1998, 14.99);
		Movie hannibal = new Movie("Hannibal", 120, 2005, 16.99);
		central.printDescription();
		hannibal.printDescription();
	}

}
class Movie{
	private String title = new String();
	private int minutes;
	private int year;
	protected double price;
	Movie(String title,int minute, int year, double price){
		this.title = title;
		minutes = minute;
		this.year = year;
		this.price = price;
	}
	String getTitle() {
		return(title);
	}
	void setTitle(String newTitle) {
		title = newTitle;
	}
	void printDescription() {
		System.out.println("Movie title: " + title);
		System.out.println("Length in minutes: " + minutes);
		System.out.println("Year of release: " + year);
		System.out.println("Price: " + price + "\n");
	}
}