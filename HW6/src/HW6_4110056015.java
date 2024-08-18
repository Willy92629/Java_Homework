
public class HW6_4110056015 {

	public static void main(String[] args) {
		/* Create objects */
		Person jason = new Person("Jason");
		Person mike = new Person("Mike");
		
		Car car_1 = new Car("Toyota", "Maroon", 4, jason, "RAV4");
		Truck truck_1 = new Truck("Ford", "Black", 6, mike, 5.5, 10000);
		Truck truck_2 = new Truck("Volvo", "Silver", 8, jason, 7, 13000);
		Truck truck_3 = new Truck("Ford", "Black", 6, mike, 5.5, 10000);
		
		
		/* Print objects */
		System.out.println(car_1);
		System.out.println(truck_1);
		System.out.println(truck_2);
		
		
		/* Execute objects */
		truck_1.gas();
		truck_2.gas();
		car_1.gas();
		truck_2.brake();
		car_1.brake();
		truck_1.brake();
		
		
		/* Compare objects */
		System.out.println("\nIs car_1 equals to truck_1? \n" + car_1.equals(truck_1));
		System.out.println("\nIs truck_1 equals to truck_2? \n" + truck_1.equals(truck_2));
		System.out.println("\nIs truck_1 equals to truck_3? \n" + truck_1.equals(truck_3));
	}
}
