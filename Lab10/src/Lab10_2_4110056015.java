

public class Lab10_2_4110056015 {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cash payment1 = new Cash(100);
		Check payment2 = new Check(50, "1501234121", "Joe King");
		CreditCard payment3 =
		   new CreditCard(1000, "Barry Schmelly", "5142-4123-4231-3231", "10/06");

		System.out.println(payment1.toString());
		System.out.println(payment2.toString());
		System.out.println(payment3.toString());
	}
	
}

abstract class Payment
{
	protected double amount;
	Payment(double amount){
		this.amount = amount;
	}
	public String toString() {
		return null;
	}
}

/**
* The cash class simply extends Payment.
*/
class Cash extends Payment
{
	Cash(double amount){
		super(amount);
	}
	public String toString() {
		return("Cash Amount: "+ amount);
	}
}

/**
* The check class extends Payment and adds some new member variables
*/
class Check extends Payment
{
	private String RoutingNumber;
	private String Name;
	Check(double amount, String number, String name){
		super(amount);
		RoutingNumber = number;
		Name = name;
	}
	String getNumber() {
		return RoutingNumber;
	}
	void setNumber(String newNumber) {
		RoutingNumber = newNumber;
	}
	
	String getName(){
		return Name;
	}
	void setName(String newName) {
		Name = newName;
	}
	public String toString() {
		return("Check routing number: " + RoutingNumber + ". Name on check: " + Name + ". Amount: "+ amount);
	}
}

class CreditCard extends Payment
{
	private String Expiration;
	public String Name;
	public String Number;
	CreditCard(double amount,String name,String number,String Expiration){
		super(amount);
		Name = name;
		Number = number;
		this.Expiration = Expiration;
	}
	String getNumber() {
		return Number;
	}
	void setNumber(String newNumber) {
		Number = newNumber;
	}
	String getExpiration(){
		return Expiration;
	}
	void setExpiration(String newExpiration) {
		Expiration = newExpiration;
	}
	
	String getName(){
		return Name;
	}
	void setName(String newName) {
		Name = newName;
	}
	public String toString() {
		return("Chredit Card number: " + Number + ". Name on card: " + Name +". Expiration Date: "+ Expiration + ". Amount: "+ amount);
	}
}