// This class is a subclass of Letter and extends the functionality
public class ExtendedLetter extends Letter {                        
	
	// private variables and constants
	private String content;
	private int family;
	private boolean related;
	private int SINGLETON = -1;
	
	// Constructor
	public ExtendedLetter(String s) {
		super('\0');
		this.content = s;
		this.related = false;
		this.family = this.SINGLETON;
	}

	// Constructor
	public ExtendedLetter(String s, int fam) {
		super('\0');
		this.content = s;
		this.related = false;
		this.family = fam;
	}

	// This function overrides the default equal method of the Object class
	@Override
	public boolean equals(Object other) {
		
		if (!(other instanceof ExtendedLetter)) return false;                           // returns false if the parameter other is not an instanceOf ExtendedLetter
		ExtendedLetter obj = (ExtendedLetter)other;
		
		if (this.family == obj.family) {
				this.related = true;                                                         // set related to true if the family instance variable of other is the same as this.family
		}
		
		if (this.content.equals(obj.content)) return true;                              // returns true if the instance variable content of other is equal to the instance variable content of this object
		return false;
	}
	
	
	// This is the override method of the default toString()
	@Override
	public String toString() {
		
		if (this.isUnused() && this.related)
			return "." + this.content + ".";
		
		return decorator() + this.content + decorator();
	}

	public static Letter[] fromStrings(String[] content, int[] codes) {                 // content is String array of the Word String, codes contains the family of the Word
		Letter[] letters = new Letter[content.length];
		
		for (int i = 0; i < content.length; i++) {
				letters[i] = codes == null ? new ExtendedLetter(content[i]) : new ExtendedLetter(content[i], codes[i]);
		}
		
		return letters;                                                                 // returns an array of the Letter from the content
	}
}
