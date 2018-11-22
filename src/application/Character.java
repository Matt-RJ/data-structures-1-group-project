package application;

/**
 * A character that can appear in a book, whether real or fictional.
 * @author Mantas Rajackas
 *
 */
public class Character {
	
	
	// FIELDS
	
	private String name = "";
	private String gender = "";
	private int age = 0;			 // Age in years
	private String description = ""; // The character's description
	
	// CONSTRUCTORS
	
	public Character() {
		
	}
	
	public Character(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		if (age >= 0) this.age = age;
	}
	
	
	// GETTERS / SETTERS
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 0) this.age = age;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
