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
		this.id = productID;
		this.inventory = 0;
		this.numSold = 0;
		this.totalPaid = 0.0;
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
		if (productName.length() > 0)
		{
			this.name = productName;
		}
		else
		{
			counter++;
			this.name = "Product "+counter;
		}
	}

	public final String getDescription()
	{
		return description;
	}

	public final void setDescription(String description)
	{
		this.description = description;
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
		if (shipmentQuantity < 0 || shipmentCost < 0)
		{
			return false;
		}
		else
		{
			inventory += shipmentQuantity;
			totalPaid += shipmentCost;
		}
		
		return true;
	}

	public final boolean reduceInventory(int purchaseQuantity)
	{
		if (purchaseQuantity < 0)
		{
			return false;
		}
		if (inventory < purchaseQuantity)
		{
			return false;
		}
		inventory -= purchaseQuantity;
		numSold += purchaseQuantity;
		
		return true;
	}

	public final double getPrice()
	{
		if ((inventory + numSold) == 0)
		{
			return -1;
		}
		return 1.25 * totalPaid / (inventory + numSold);
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
		// TODO Complete your code here.
		id = customerID;
		this.credit = credit;
		balance = 0;
		numPurchased = 0;
		setName(name);
	}

	public int getID() {
		// TODO Complete your code here. 
		// TODO You can change or move the following return statement if necessary.
		return id;
	}
	
	public String getName() {
		// TODO Complete your code here.
		// TODO You can change or move the following return statement if necessary.
		return name;
	}
	
	public void setName(String customerName) {
		// TODO Complete your code here.
		if(customerName.length() == 0) {
			counter++;
			name = "Customer" + counter;
		}else {
			name = customerName;
		}
	}

	public boolean getCredit() {
		// TODO Complete your code here.
		// TODO You can change or move the following return statement if necessary.
		return credit;
	}

	public void setCredit(boolean hasCredit) {
		// TODO Complete your code here.
		credit = hasCredit;
	}

	public double getBalance() {
		// TODO Complete your code here.
		// TODO You can change or move the following return statement if necessary.
		return balance;
	}
	
	public boolean processPayment(double amount) {
		// TODO Complete your code here.
		if(amount < 0.0 ) 
			return false;
		else
			balance+=amount;
		// TODO You can change or move the following return statement if necessary.
		return true;
	}

	public boolean processPurchase(double amount, Product product) {
		// TODO Complete your code here.
		if(amount < 0)
			return false;
		if(credit || balance >= amount )
			balance-=amount;
		else 
			return false;
		for(int i=0 ;i<numPurchased;i++) {
			if(product.getName().equals(recentPurchases[i]))
				return true;
		}
		for(int i=3 ;i>=0;i--) {
			recentPurchases[i+1] = recentPurchases[i];
		}
		recentPurchases[0] = product.getName();
		numPurchased++;
		// TODO You can change or move the following return statement if necessary.
		return true;
	}

	public void outputRecentPurchases() {
		// TODO Complete your code here.
		for(int i=0; i<5 ; i++) {
			if(recentPurchases[i] != null)
				System.out.println(recentPurchases[i]);
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
		// TODO Complete your code here.
		numProducts = 0;
		numCustomers = 0;
		setName("");
	}
	
	public Store(String name) {
		// TODO Complete your code here.
		numProducts = 0;
		numCustomers = 0;
		setName(name);
	}
	
	public String getName() {
		// TODO Complete your code here.
		// TODO You can change or move the following return statement if necessary.
		return name;
	}
	
	public void setName(String storeName) {
		// TODO Complete your code here.
		if(storeName.length() == 0) {
			counter++;
			name = "Store" + counter;
		}else {
			name = storeName;
		}
	}

	public boolean addProduct(int productID, String productName) {
		// TODO Complete your code here.
		if(numProducts == 100)
			return false;
		for(int i = 0;i<numProducts;i++) {
			if(products[i].getID() == productID)
				return false;
		}
		products[numProducts] = new Product(productID,productName);
		numProducts++;
		// TODO You can change or move the following return statement if necessary.
		return true;
	}

	public Product getProduct(int productID) {
		// TODO Complete your code here.
		for(int i = 0;i<numProducts;i++) {
			if(products[i].getID() == productID)
				return products[i];
		}
		// TODO You can change or move the following return statement if necessary.
		return null;
	}

	public boolean addCustomer(int customerID, String customerName, boolean credit) {
		// TODO Complete your code here.
		if(numCustomers == 100)
			return false;
		for(int i = 0;i<numCustomers;i++) {
			if(customers[i].getID() == customerID)
				return false;
		}
		customers[numCustomers] = new Customer(customerID,customerName,credit);
		numCustomers++;
		// TODO You can change or move the following return statement if necessary.
		return true;
	}

	public Customer getCustomer(int customerID) {
		// TODO Complete your code here.
		for(int i = 0;i<numCustomers;i++) {
			if(customers[i].getID() == customerID)
				return customers[i];
		}
		// TODO You can change or move the following return statement if necessary.
		return null;
	}


	public boolean takeShipment(int productID, int quantity, double cost) {
		// TODO Complete your code here.
		if(getProduct(productID) == null)
			return false;
		getProduct(productID).addShipment(quantity, cost);
		// TODO You can change or move the following return statement if necessary.
		return true;
	}

	public boolean sellProduct(int customerID, int productID, int quantity) {
		// TODO Complete your code here.
		if(getProduct(productID) == null || getCustomer(customerID) == null)
			return false;
		if(quantity >= 0 && getProduct(productID).reduceInventory(quantity)&&getCustomer(customerID).processPurchase(quantity*getProduct(productID).getPrice(),getProduct(productID))){
			getProduct(productID).reduceInventory(quantity);
			getCustomer(customerID).processPurchase(quantity*getProduct(productID).getPrice(),getProduct(productID));
			return true;
		}
		// TODO You can change or move the following return statement if necessary.
		return false;
	}

	public boolean takePayment(int customerID, double amount) {
		// TODO Complete your code here.
		if(getCustomer(customerID) == null)
			return false;
		getCustomer(customerID).processPayment(amount);
		// TODO You can change or move the following return statement if necessary.
		return true;
	}

	public void outputProducts(Product product) {
		// TODO Complete your code here.
		if(product != null) {
			System.out.println("Product Name: " + product.getName());
			System.out.println("Product ID: " + product.getID());
			System.out.println("Description: " + product.getDescription());
			System.out.println("Inventory: " + product.getInventoryCount());
			System.out.println("Number Sold:" + product.getNumberSold());
			System.out.println("Total Paid:" + product.getTotalPaid());
			System.out.println("Price:" + product.getPrice());
		}
		
	}

	public void outputCustomers(Customer customer) {
		// TODO Complete your code here.
		if(customer != null) {
			System.out.println("Customer Name: " + customer.getName());
			System.out.println("Customer ID: " + customer.getID());
			System.out.println("Has Credit: " + customer.getCredit());
			System.out.println("Balance: " + customer.getBalance());
			System.out.println("Products purchased --");
			customer.outputRecentPurchases();
		}
	}
}


public class HW5_4110056015 {
	public static void main(String[] args) {
		Product p = new Product(17, "Jill");
		System.out.println("p (id): "+p.getID());
		System.out.println("p (name): "+p.getName());
		System.out.print("\n");

		Product q = new Product(183, "Tom");
		System.out.println("q (id): "+q.getID());
		System.out.println("q (name): "+q.getName());
		System.out.print("\n");

		Product badP = new Product(222, "");
		System.out.println("badP (id): "+badP.getID());
		System.out.println("badP (name): "+badP.getName());
		System.out.print("\n");

		p.setName("Jill Extreme");
		System.out.println("p (name): "+p.getName());
		q.setName("");
		System.out.println("q (name): "+q.getName());
		p.setDescription("This is a fantastic product.");
		System.out.println("p (description): "+p.getDescription());
		q.setDescription("");
		System.out.println("q (description): "+q.getDescription());
		System.out.print("\n");

		System.out.println("Before 1st shipment");
		System.out.println("inventory: "+p.getInventoryCount());
		System.out.println("totalPaid: "+p.getTotalPaid());
		System.out.println("price: "+p.getPrice());
		System.out.println("numSold: "+p.getNumberSold());
		System.out.print("\n");

		p.addShipment(88, 230.44);
		System.out.println("After 1st shipment");
		System.out.println("inventory: "+p.getInventoryCount());
		System.out.println("totalPaid: "+p.getTotalPaid());
		System.out.println("price: "+p.getPrice());
		System.out.println("numSold: "+p.getNumberSold());
		System.out.print("\n");

		p.addShipment(133, 142.11);
		System.out.println("After 2nd shipment");
		System.out.println("inventory: "+p.getInventoryCount());
		System.out.println("totalPaid: "+p.getTotalPaid());
		System.out.println("price: "+p.getPrice());
		System.out.println("numSold: "+p.getNumberSold());
		System.out.print("\n");

		System.out.println("Testing negative quantity");

		if (!p.addShipment(-5, 22.55))
			System.out.println("shipment failed");
		else
			System.out.println("shipment passed");

		System.out.println("After failed shipment (nothing should change from last output)");
		
		System.out.println("--------Customer--------");
		
		Customer r = new Customer(17, "Jill",true);
		System.out.println("r (id): "+r.getID());
		System.out.println("r (name): "+r.getName());
		System.out.println("r (credit): "+r.getCredit());
		System.out.println("r (balance): "+r.getBalance());
		System.out.print("\n");

		Customer s = new Customer(183, "Tom",false);
		System.out.println("s (id): "+s.getID());
		System.out.println("s (name): "+s.getName());
		System.out.println("s (credit): "+s.getCredit());
		System.out.println("s (balance): "+s.getBalance());
		System.out.print("\n");

		Customer badR = new Customer(-222, "",false);
		System.out.println("badR (id): "+badR.getID());
		System.out.println("badR (name): "+badR.getName());
		System.out.println("badR (credit): "+badR.getCredit());
		System.out.println("badR (balance): "+badR.getBalance());
		System.out.print("\n");

		r.setName("Jill Extreme");
		System.out.println("r (name): "+r.getName());
		s.setName("");
		System.out.println("s (name): "+s.getName());
		r.setCredit(false);
		System.out.println("r (sredit): "+r.getCredit());
		s.setCredit(true);
		System.out.println("s (credit): "+s.getCredit());
		System.out.print("\n");
		
		System.out.println("ProcessPayment");
		r.processPayment(600.0);
		System.out.println("r (balance): "+r.getBalance());
		r.processPayment(-600.35);
		System.out.println("r (balance): "+r.getBalance());
		s.processPayment(-712.35);
		System.out.println("s (balance): "+s.getBalance());
		System.out.print("\n");
		
		System.out.println("ProcessPurchase");
		if(r.processPurchase(200,p))
			System.out.println("true r (balance): "+r.getBalance());
		if(r.processPurchase(400,q))
			System.out.println("true r (balance): "+r.getBalance());
		if(r.processPurchase(300,p))
			System.out.println("true r (balance): "+r.getBalance());
		else
			System.out.println("false r (balance): "+r.getBalance());
		
		if(s.processPurchase(200,p))
			System.out.println("true r (balance): "+s.getBalance());
		if(s.processPurchase(400,q))
			System.out.println("true r (balance): "+s.getBalance());
		else
			System.out.println("false r (balance): "+s.getBalance());
		if(s.processPurchase(-300,p))
			System.out.println("true r (balance): "+s.getBalance());
		else
			System.out.println("false r (balance): "+s.getBalance());
		System.out.print("\n");
		
		System.out.println("outputRecentPurchase");
		r.outputRecentPurchases();
		System.out.print("\n");
		s.outputRecentPurchases();
		System.out.print("\n");
		
		System.out.println("--------Store--------");
		Store t = new Store();
		System.out.println("t (name): "+t.getName());

		Store v = new Store("Tom");
		System.out.println("v (name): "+v.getName());

		Store badT = new Store("");
		System.out.println("badT (name): "+badT.getName());
		
		t.setName("Seven");
		v.setName("");
		badT.setName("Tom");
		
		System.out.println("t (name): "+t.getName());
		System.out.println("v (name): "+v.getName());
		System.out.println("badT (name): "+badT.getName());
		
		System.out.println("addProduct");
		t.addProduct(17, "Apple");
		t.addProduct(20, "Apple2");
		t.addProduct(17, "Apple3");
		t.addProduct(170, "Apple4");
		
		System.out.println("17 (name): "+ t.getProduct(17).getName());
		System.out.println("20 (name): "+ t.getProduct(20).getName());
		System.out.println("170(name): "+ t.getProduct(170).getName());
		System.out.println("234 (name): "+ t.getProduct(234));
		System.out.print("\n");
		
		System.out.println("addCustomer");
		t.addCustomer(15, "Cloud",true);
		t.addCustomer(26, "Can",false);
		t.addCustomer(15, "Lan",true);
		t.addCustomer(180, "Dan",false);
	
		System.out.println("15 (name): "+ t.getCustomer(15).getName());
		System.out.println("26 (name): "+ t.getCustomer(26).getName());
		System.out.println("180(name): "+ t.getCustomer(180).getName());
		System.out.println("234 (name): "+ t.getCustomer(234));
		System.out.print("\n");
		
		System.out.println("takeShipment");
		if(t.takeShipment(17, 20, 600))
			System.out.println("true");
		if(t.takeShipment(204, 3, 60))
			System.out.println("true");
		else
			System.out.println("false");
		if(t.takeShipment(170, -3, 60))
			System.out.println("true");
		else
			System.out.println("false");
		System.out.print("\n");
		
		System.out.println("sellProduct");
		if(t.sellProduct(15, 17, 10))
			System.out.println("true");
		else
			System.out.println("false");
		if(t.sellProduct(15, 15, 10))
			System.out.println("true");
		else
			System.out.println("false");
		if(t.sellProduct(15, 17, -10))
			System.out.println("true");
		else
			System.out.println("false");
		if(t.sellProduct(17, 17, 10))
			System.out.println("true");
		else
			System.out.println("false");
		if(t.sellProduct(15, -15, 10))
			System.out.println("true");
		else
			System.out.println("false");
		System.out.print("\n");
		
		
		System.out.println("takePayment");
		if(t.takePayment(15, 300))
			System.out.println("true");
		if(t.takePayment(-2, 0))
			System.out.println("true");
		else
			System.out.println("false");
		if(t.takePayment(180, -100))
			System.out.println("true");
		else
			System.out.println("false");
		System.out.print("\n");
				
		System.out.println("outputProduct");
		t.outputProducts(t.getProduct(17));
		System.out.print("\n");
		v.outputProducts(t.getProduct(15));
		System.out.print("\n");
		
		System.out.println("outputCustomer");
		t.outputCustomers(t.getCustomer(15));
		System.out.print("\n");
		v.outputCustomers(t.getCustomer(17));
		System.out.print("\n");
		
		System.out.println("All tests finished!");
	}
}
