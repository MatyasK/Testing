package zoo;

/**
 * Created by Matyas on 6/14/2016.
 */
public class Administrator extends Employee {
    /**
     * Employee constructor
     *
     * @param number The unique employee number (3 digits)
     * @param name   His/Her name
     * @param age    His/Her age (between 0 and 100 inclusive)
     */
    public Administrator(int number, String name, int age) {
        super(number, name, age);
    }

    public float getSalary(){
        return 1000 + the_age * 50;
    }

}
