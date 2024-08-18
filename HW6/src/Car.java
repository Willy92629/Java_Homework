public class Car extends Vehicle {
	/* Instance variables */
	// TODO: Code here ...
	private String model;

	/* Constructors */
	public Car() {
		// TODO: Code here ...
		super();
		model = "N/A";
	}

	public Car(String make, String color, int numCylinder, Person owner, String model) {
		// TODO: Code here ...
		super(make, color, numCylinder, owner);
		this.model = model;
	}

	/* Accessor */
	// TODO: Code here ...
	public String getModel() {
		return model;
	}

	/* Mutator */
	// TODO: Code here ...
	public void setModel(String model) {
		this.model = model;
	}

	/* Overriding abstract methods */
	@Override
	public void gas() {
		// TODO: Code here ...
		System.out.println("A " + getColor() + " " + getManufacturer() + " " + model + " is accelerating ...");
	}

	@Override
	public void brake() {
		// TODO: Code here ...
		System.out.println("A " + getColor() + " " + getManufacturer() + " " + model + " is slowing down ...");
	}

	/* Overriding methods */
	// TODO: Code here ...
	public String toString() {
		// TODO: Code here ...
		// The return statement is not complete.
		return "Vehicle Type: Car\n"+ super.toString() + "Model: " + model + "\n";
	}

	public boolean equals(Object other) {
		// TODO: Code here ...
		try {
			Car car1 = (Car) other;
			if (getManufacturer().equals(car1.getManufacturer()) && getColor().equals(car1.getColor())
					&& getCylinderNumber() == car1.getCylinderNumber() && getOwner().equals(car1.getOwner())
					&& model.equals(car1.model))
				return true;
			else
				return false;
		} catch (ClassCastException e) {
			return false;
		}
	}

}
