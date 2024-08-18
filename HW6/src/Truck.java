
public class Truck extends Vehicle {
	/* Instance variables */
	private double loadCapacity; // in ton
	private int towingCapacity; // in pound

	/* Constructors */
	public Truck() {
		// TODO: Code here ...
		super();
		loadCapacity = 0;
		towingCapacity = 0;
	}

	public Truck(String make, String color, int numCylinder, Person owner, double ton, int pound) {
		// TODO: Code here ...
		super(make, color, numCylinder, owner);
		loadCapacity = ton;
		towingCapacity = pound;
	}

	/* Accessor */
	public double getLoadCapacity() {
		// TODO: Code here ...
		// The return statement is not complete.
		return loadCapacity;
	}

	public int getTowingCapacity() {
		// TODO: Code here ...

		// The return statement is not complete.
		return towingCapacity;
	}

	/* Mutator */
	public void setLoadCapacity(double ton) {
		// TODO: Code here ...
		loadCapacity = ton;
	}

	public void setTowingCapacity(int pound) {
		// TODO: Code here ...
		towingCapacity = pound;
	}

	/* Overriding abstract methods */
	@Override
	public void gas() {
		// TODO: Code here ...
		System.out.println("A " + getColor() + " " + getManufacturer() + " truck is accelerating ...");
	}

	@Override
	public void brake() {
		// TODO: Code here ...
		System.out.println("A " + getColor() + " " + getManufacturer() + " truck is slowing down ...");
	}

	/* Overriding methods */
	public String toString() {
		// TODO: Code here ...
		// The return statement is not complete.
		return "Vehicle Type: Truck\n" + super.toString()
				+ "The Load Capacity in Ton: " + loadCapacity + "\nThe Towing Capacity in Pounds: " + towingCapacity + "\n";
	}

	public boolean equals(Object other) {
		// TODO: Code here ...
		try {
			Truck car1 = (Truck) other;
			if (getManufacturer().equals(car1.getManufacturer()) && getColor().equals(car1.getColor())
					&& getCylinderNumber() == car1.getCylinderNumber() && getOwner().equals(car1.getOwner())
					&& loadCapacity == car1.loadCapacity && towingCapacity == car1.towingCapacity)
				return true;
			else
				return false;
		} catch (ClassCastException e) {
			return false;
		}
	}

}
