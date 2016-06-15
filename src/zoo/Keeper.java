package zoo;

/**
 * Created by Matyas on 6/14/2016.
 */
public class Keeper extends Employee {

    private Cage the_cage;

    /**
     * Employee constructor
     *
     * @param number The unique employee number (3 digits)
     * @param name   His/Her name
     * @param age    His/Her age (between 0 and 100 inclusive)
     */
    public Keeper(int number, String name, int age) {
        super(number, name, age);
    }

    public void setThe_cage(Cage the_cage) {
        this.the_cage = the_cage;
    }

    public float getSalary(){
        return 2000 + the_cage.size() * 100;
    }
}
