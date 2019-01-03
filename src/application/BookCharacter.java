package application;

/**
 * A character that can appear in a book
 * 
 * @author Mantas Rajackas
 *
 */
public class BookCharacter {
	
	
	// FIELDS
	
	private String name = "";
	private String gender = "";
	private int age = 0;			 // Age in years
	private String description = ""; // The character's description
	
	// Contains hash codes of books the character is in
	private LinkList<Integer> booksAppearsIn = new LinkList<>(); 
	
	
	// CONSTRUCTORS
	
	public BookCharacter() {
		
	}
	
	public BookCharacter(String name, String gender, int age, String description) {
		this.name = name;
		this.gender = gender;
		if (age >= 0) this.age = age;
		this.description = description;
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

	public LinkList<Integer> getBooksAppearsIn() {
		return booksAppearsIn;
	}

	public void setBooksAppearsIn(LinkList<Integer> booksAppearsIn) {
		this.booksAppearsIn = booksAppearsIn;
	}
	
	
	@Override
	public String toString() {
		String characterString = "";
		
		characterString += "Name: " + this.name + "\n";
		characterString += "Gender: " + this.gender + "\n";
		characterString += "Age: " + this.age + "\n";
		characterString += "Description: " + this.description + "\n";
		
		return characterString;
	}
	
	@Override
	public int hashCode() {
		
		int hashCode = 0;
		
		for (int i = 0; i < name.length(); i++) { 
			hashCode += name.charAt(i);
		}
		
		return hashCode;	
	}
	
}
