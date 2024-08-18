class Product {
	private int id;
	private String name;
	private int inventory;
	private int numSold;
	private String description;
	private double totalPaid;
	private static int counter = 0;
	
	public Product(int productID, String productName)
	{
		this.id=productID;
		this.inventory=0;
		this.numSold=0;
		this.totalPaid=0.0;
		setName(productName);
	}

	public final int getID()
	{
		return id;
	}

	public final String getName()
	{
		return name;
	}

	public final void setName(String productName)
	{
		if(productName.length()==0)
		{
			counter++;
			name="Product "+counter;
		}
		else
		{
			name=productName;
		}
	}

	public final String getDescription()
	{
		return description;
	}

	public final void setDescription(String description)
	{
		this.description=description;
	}

	public final int getNumberSold()
	{
		return numSold;
	}

	public final double getTotalPaid()
	{
		return totalPaid;
	}

	public final int getInventoryCount()
	{
		return inventory;
	}

	public final boolean addShipment(int shipmentQuantity, double shipmentCost)
	{
		if(shipmentQuantity<0||shipmentCost<0)
		{
			return false;
		}
		else
		{
			this.inventory+=shipmentQuantity;
			this.totalPaid+=shipmentCost;
			return true;
		}
	}

	public final boolean reduceInventory(int purchaseQuantity)
	{
		if(purchaseQuantity<0)
		{
			return false;
		}
		else if(purchaseQuantity>inventory)
		{
			return false;
		}
		else
		{
			inventory-=purchaseQuantity;
			numSold+=purchaseQuantity;
			return true;
		}
	}

	public final double getPrice()
	{
		if(inventory+numSold==0)
		{
			return -1;
		}
		else
		{
			/*System.out.println(totalPaid);
			System.out.println(numSold);
			System.out.println(numSold);*/
			return 1.25*totalPaid/(inventory+numSold);
		}
	}
}


class Customer {
	private int id;
	private String name;
	private boolean credit;
	private double balance;
	private String[] recentPurchases = new String[5];
	private int numPurchased;
	private static int counter = 0;
	
	public Customer(int customerID, String name, boolean credit) {
		id=customerID;
		this.credit=credit;
		balance=0;
		numPurchased=0;
		setName(name);
	}

	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String customerName) {
		if(customerName.length()==0)
		{
			counter++;
			name="Customer "+counter;
		}
		else
		{
			name=customerName;
		}
	}

	public boolean getCredit() {
		return credit;
	}

	public void setCredit(boolean hasCredit) {
		credit=hasCredit;
	}

	public double getBalance() {
		return balance;
	}
	
	public boolean processPayment(double amount) {
		if(amount<0)
		{
			return false;
		}
		else
		{
			balance+=amount;
			return true;
		}
				
	}

	public boolean processPurchase(double amount, Product product) {
		if(amount<0)
		{
			return false;
		}
		else if(credit==true||balance>=amount)
		{
			balance-=amount;
		}
		else
		{
			return false;
		}
		for(int i=0;i<5;i++)
		{
			if(product.getName().equals(recentPurchases[i]))
			{
				return true;
			}
		}
		for(int i=4;i>0;i--)
		{
			recentPurchases[i]=recentPurchases[i-1];
		}
		recentPurchases[0]=product.getName();
		return true;
	}

	public void outputRecentPurchases() {
		for(int i=0;i<5;i++)
		{
			if(recentPurchases[i]!=null)
			{
				System.out.println(recentPurchases[i]);
			}
		}
	}
}


class Store {
	private String name;
	private Product[] products = new Product[100];
	private Customer[] customers = new Customer[100];
	private int numProducts;
	private int numCustomers;
	private static int counter = 0;

	public Store() {
		numProducts=0;
		numCustomers=0;
		setName("");
	}
	
	public Store(String name) {
		numProducts=0;
		numCustomers=0;
		setName(name);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String storeName) {
		if(storeName.length()==0)
		{
			counter++;
			name="Store "+counter;
		}
		else
		{
			name=storeName;
		}
	}

	public boolean addProduct(int productID, String productName) {
		if(numProducts==100)
		{
			return false;
		}
		for(int i=0;i<numProducts;i++)
		{
			if(productID==products[i].getID())
			{
				return false;
			}
		}
		products[numProducts]=new Product(productID,productName);
		numProducts++;
		return true;
	}

	public Product getProduct(int productID) {
		for(int i=0;i<numProducts;i++)
		{
			if(productID==products[i].getID())
			{
				return products[i];
			}
		}
		return null;
	}

	public boolean addCustomer(int customerID, String customerName, boolean credit) {
		if(numCustomers==100)
		{
			return false;
		}
		for(int i=0;i<numCustomers;i++)
		{
			if(customerID==customers[i].getID())
			{
				return false;
			}
		}
		customers[numCustomers]=new Customer(customerID,customerName,credit);
		numCustomers++;
		return true;
	}
	
	public boolean addCustomer(int customerID, String customerName) {
		boolean credit=false;
		if(numCustomers==100)
		{
			return false;
		}
		for(int i=0;i<numCustomers;i++)
		{
			if(customerID==customers[i].getID())
			{
				return false;
			}
		}
		customers[numCustomers]=new Customer(customerID,customerName,credit);
		numCustomers++;
		return true;
	}
	public Customer getCustomer(int customerID) {
		for(int i=0;i<numCustomers;i++)
		{
			if(customerID==customers[i].getID())
			{
				return customers[i];
			}
		}
		return null;
	}


	public boolean takeShipment(int productID, int quantity, double cost) {
		if(getProduct(productID)==null)
		{
			return false;
		}
		getProduct(productID).addShipment(quantity, cost);
		return true;
	}

	public boolean sellProduct(int customerID, int productID, int quantity) {
		if(getCustomer(customerID)==null||getProduct(productID)==null)
		{
			return false;
		}
		if(quantity>=0&&getProduct(productID).getPrice()!=-1.0&&quantity<=getProduct(productID).getInventoryCount()&&(getCustomer(customerID).getCredit()==true||getCustomer(customerID).getBalance()>=quantity*getProduct(productID).getPrice()))
		{
			getProduct(productID).reduceInventory(quantity);
			getCustomer(customerID).processPurchase(quantity*getProduct(productID).getPrice(),getProduct(productID));
			return true;
		}
		return false;
	}

	public boolean takePayment(int customerID, double amount) {
		if(getCustomer(customerID)==null)
		{
			return false;
		}
		getCustomer(customerID).processPayment(amount);
		return true;
	}

	public void outputProducts(Product product) {
		System.out.println("Product Name: "+product.getName());
		System.out.println("Product ID: "+product.getID());
		System.out.println("Description: "+product.getDescription());
		System.out.println("Inventory: "+product.getInventoryCount());
		System.out.println("Number Sold: "+product.getNumberSold());
		System.out.println("Total Paid: "+product.getTotalPaid());
		System.out.println("Price: "+product.getPrice());
	}

	public void outputCustomers(Customer customer) {
		System.out.println("Customer Name: "+customer.getName());
		System.out.println("Customer ID: "+customer.getID());
		System.out.println("Has Credit: "+customer.getCredit());
		System.out.println("Balance: "+customer.getBalance());
		System.out.println("Products Purchased --");
		customer.outputRecentPurchases();
	}
}

public class HW5_4109056015 {

	public static void main(String[] args) {

	}
}
