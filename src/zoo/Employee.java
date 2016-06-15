package zoo;

import java.util.Vector;
// for saveFile at the end
import java.io.PrintWriter;


/**
 * The class representing various kinds of employees.
 * 
 * @author R.Akkersdijk
 */
public class Employee
{
	// Utility function

    /**
     * Test that a number can be a valid employee number (i.e. 3 digits)
     * @param a_number number to check
     * @return true if passes number is valid, false otherwise
     */
	public static final boolean isValidEmployeeNumber(int a_number) {
		return (100 <= a_number) && (a_number <= 999);
	}

	// ===========================

	// Employee function codes
	public static final int MANAGER = 1; // department manager
	public static final int ADMINISTRATOR = 2; // administrator
	public static final int KEEPER = 4; // animal cage keeper

	// ===========================

	// Common data for all types of employees
	//protected final int the_function; 	// i.e. ADMINISTRATOR, KEEPER, MANAGER
	protected final int the_number; 	// unique employee number (3 digits)
	protected final String the_name;	// his/her name
	protected int the_age; 				// his/her age
	protected Employee the_boss; 		// for whom he/she works

	// Only for zoo keepers
	private Cage the_cage;			// takes care of the animals in this cage

	// Only for managers
	private Vector<Employee> the_employees;	// all people being managed (include himself)


	/**
	 * Employee constructor
	 *
	 * @param number The unique employee number (3 digits)
	 * @param name His/Her name
	 * @param age His/Her age (between 0 and 100 inclusive)
	 */
	public Employee( int number, String name, int age) {
		//assert function == MANAGER || function == ADMINISTRATOR || function == KEEPER: "the function is valid value";
		assert isValidEmployeeNumber(number) : "not valid employee number";
		assert name != null :  "the name is null";
		assert age > 0 && age < 100 : "The age is out of range";


		//the_function = function; // should be: MANAGER, ADMINISTRATOR or KEEPER
		the_number = number;
		the_name = name;
		the_age = age;
		the_boss = null;
		the_cage = null;
		the_employees = null;
//		if (the_function == MANAGER) {
//			the_boss = this; // A manager manages himself !
//			the_employees = new Vector<Employee>();
//			the_employees.add(this); // add self to list
//		}
	}

	public int getNumber() {
		return the_number;
	}

	public boolean isEmployee(int number) {
		assert isValidEmployeeNumber(number) : "the number must contain three digits";

		return the_number == number;
	}

//	public int getFunction() {
//		return the_function;
//	}

	// for Managers only



	public void setManager(Employee boss) {
		assert boss != null : "the manager is null";
		assert boss instanceof Manager : "this employee is not manager";
		the_boss = boss;
	}

//	public float getSalary(Employee employee) {
//		float salary = 0;
//		if (employee instanceof Manager){
//
//		}
//		return salary;
//	}

	public String toString() {
		return String.format("%10s %3d", "employee", the_number);
	}

	void print() {
		System.out.print(this + "\t" + the_name + "\t" + the_age + "\t" + getSalary() + " euro");
		if (the_boss != null)
			System.out.print("\tworking for " + the_boss.getNumber());
		else
			System.out.print("\thas gone away");
		if (the_function == MANAGER)
			System.out.print("\thas " + the_employees.size() + " employees");
		if (the_function == KEEPER)
			System.out.print("\ttaking care of " + the_cage.getKind());
	}

	// =====================================
	public void saveFile(PrintWriter out) {
		assert out != null : "null printwriter";
		switch (the_function)
		{
		case ADMINISTRATOR:
			out.println("2\t2\t" // action 2=employee, function 2=administrator
					+ the_number + "\t" + the_name + "\t" + the_age + "\t" + the_boss.the_number);
			break;
		case MANAGER:
			out.println("2\t1\t" // action 2=employee, function 1=manager
					+ the_number + "\t" + the_name + "\t" + the_age);
			break;
		case KEEPER:
			out.println("2\t4\t" // action 2=employee, function 4=keeper
					+ the_number + "\t" + the_name + "\t" + the_age + "\t" + the_cage.getKind() + "\t" + the_boss.the_number);
			break;
		}
	}

}
