package zoo;

import java.util.TreeMap;
// for saveFile at the end
import java.io.PrintWriter;


/**
 * A cage for all animals of a specific kind.
 * 
 * @author R.Akkersdijk
 */
public class Cage
{
	// The kind of animals in this cage
	private final String the_kind;

	// The collection of animals in this cage
	private final TreeMap<String,Animal> the_animals;

	/**
	 * @param kind What kind of animals are allowed in this cage
	 */
	public Cage(String kind) {


		assert kind != null : "null kind";
		assert !kind.isEmpty() : "kind is empty";


		the_kind = kind;
		the_animals = new TreeMap<String,Animal>();



	}

	/**
	 * What kind of animals in this cage?
	 * 
	 * @return The animal kind
	 */
	public String getKind() { // Needed for Keeper.print()
		return the_kind;
	}

	/**
	 * To calculate the salary of a zoo keeper.
	 * 
	 * @return the number of animals in this cage
	 */
	public int size() {

		return the_animals.size();
	}

	// Add animal to the cage itself
	public void addAnimal(Animal animal){
		assert animal != null : "the animal is null";
		assert the_animals.get(animal.getName()) == null : "this animal is already exist";
		the_animals.put(animal.getName(), animal);
	}

	public void removeAnimal(String animal){
		assert animal != null : "the animal is null";
		the_animals.remove(animal);
		System.out.println(animal + "removed");
	}

	public int getCageSize(){
		return the_animals.size();
	}

	/**
	 * Reveal the list of animals
	 * 
	 * @return the animal list
	 */
	@Deprecated
	public TreeMap<String,Animal> getAnimals() {
		return the_animals;
	}
	// Second assignment: Exposing private attributes
	// opens the door for unpleasant surprises.

	public void print() {
		System.out.println("Cage " + the_kind);
		System.out.println("kind\tname\tage");
		for (Animal animal : the_animals.values()) {
			animal.print();
		}
	}

	public String toString() {
		return "Cage " + the_kind;
	}

	// =====================================
	public void saveFile(PrintWriter out) {
		assert out != null : "null PrintWriter";		// M
		for (Animal animal : the_animals.values()) {
			animal.saveFile(out);
		}
	}

}
