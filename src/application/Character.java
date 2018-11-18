package application;

/**
 * A character that can appear in a book, whether real or fictional.
 * @author Mantas Rajackas
 *
 */
public class Character {
	
	
	// FIELDS
	
	private String name = "";	// The character's name
	private String gender = "";		// The character's gender
	private int age = 0;		// The character's age (years)
	
	
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
	
	
	
	
}
