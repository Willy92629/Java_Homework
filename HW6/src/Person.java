
public class Person {
	/* Instance variables */
	private String name;

	/* Constructor */
	public Person() {
		// TODO: Code here ...
		name = "N/A";
	}

	public Person(String name) {
		// TODO: Code here ...
		if(name == null)
			name = "N/A";
		else
			this.name = name;
	}

	public Person(Person theObject) {
		// TODO: Code here ...
		if(theObject == null)
			name = "N/A";
		else
			this.name =theObject.name;
	}

	/* Accessor */
	public String getName() {
		// The return statement is not complete.
		return name;
	}

	/* Mutator */
	public void setName(String name) {
		// TODO: Code here ...
		this.name = name;
	}

	/* Overriding methods */
	public String toString() {
		// TODO: Code here ...

		// The return statement is not complete.
		return "Name: " + name;
	}

	public boolean equals(Object other) {
		// TODO: Code here ...
		try {
			Person oth = (Person) other;
			if (name.equals(oth.getName()))
				return true;
			else
				return false;
		} catch (ClassCastException e) {
			return false;
		}
	}
}
