package zoo;

import java.util.Vector;

/**
 * Created by Matyas on 6/14/2016.
 */
public class Manager extends Employee {
    private Vector<Employee> the_employees;
    /**
     * Employee constructor
     *
     *
     * @param number   The unique employee number (3 digits)
     * @param name     His/Her name
     * @param age      His/Her age (between 0 and 100 inclusive)
     */
    public Manager( int number, String name, int age) {
        super(number, name, age);
    }


    public Vector<Employee> getEmployees() {
        return the_employees;
    }

    public float getSalary(){
        return 5000 + the_employees.size() * 500;
    }
}
