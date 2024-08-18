
abstract class Vehicle {
	/* Instance variables */  
	private String make;      // Vehicle Manufacturer
	private String color;     // Vehicle Color
	private int numCylinder;  // Number of Cylinder
	private Person owner;     // Vehicle Owner
	
	
	/* Constructors */
	public Vehicle() {
		// TODO: Code here ...
		make = "N/A";
		numCylinder = 0;
		owner = new Person();
	}
	
	public Vehicle(String make, String color, int numCylinder, Person owner) {
		// TODO: Code here ...
		if(make == null || make.length()== 0)
			make = "N/A";
		else
			this.make = make;
		if(color == null || color.length()== 0)
			color = "N/A";
		else
			this.color = color;
		this.numCylinder = numCylinder;
		if(owner == null)
			this.owner = new Person();
		else
			this.owner = owner;
	}
	
	
	/* Accessors */
	public String getManufacturer() {
		// TODO: Code here ...
		return make;
	}

	public String getColor() {
		// TODO: Code here ...
		return color;
	}
	
	public int getCylinderNumber() {
		// TODO: Code here ...
		return numCylinder;
	}
	
	public Person getOwner() {
		return owner;
	}
	
	
	/* Mutators */
	public void setManufacturer(String make) {
		// TODO: Code here ...
		this.make = make;
	}
	
	public void setColor(String color) {
		// TODO: Code here ...
		this.color = color;
	}
	
	public void setCylinderNumber(int numCylinder) {
		// TODO: Code here ...
		this.numCylinder = numCylinder;
	}
	
	public void setOwner(Person owner) {
		// TODO: Code here ...
		this.owner = owner;
	}
	
	
	/* Abstract methods */
	public abstract void gas();
	
	public abstract void brake();
	
	   
	/* Overriding methods */
	public String toString() {
		// TODO: Code here ...
		
		// The return statement is not complete.
		return ("Vehicle Manufacturer: " + make + "\nVehicle Color: " + color + "\nNumber of Cylinders: " + numCylinder + "\nOwner: " + getOwner() + "\n");
	}
	
	public boolean equals(Object other) {
		// TODO: Code here ...
		// The return statement is not complete.
		return true;
	}
}
