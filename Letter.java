// This class represents a single letter that will be used
public class Letter {                                             
	
	// private variables
	private int label;                                             // for assigning state of the character
	private char letter;                                           // for storing character
	final int UNSET = 0,UNUSED = 1, USED = 2, CORRECT = 3;         // constants
	
	// Constructor
	public Letter(char c) {
		
		this.letter = c;                                           // set letter to c
		this.label = UNSET;		                                   // initialise label to UNSET
	}
	
	// This function overrides the default equal method of the Object class
	@Override
	public boolean equals(Object otherObject) {
		
		if (!(otherObject instanceof Letter)) return false;        // checks if otherObject is of the class Letter
		
		return this.letter == ((Letter)otherObject).letter;        // if true, then the letter attribute of otherObject and this object are compared (true if they are the same)
	}

	public String decorator() {
		
		String res = " ";                                          // if the "label" attribute is UNSET
		
		if (label == USED) res = "+";                              // if the "label" attribute is USED
		
		if (label == UNUSED) res = "-";                            // if the "label" attribute is UNUSED
		
		if (label == CORRECT) res = "!";                           // if the "label" attribute is CORRECT
		
		return res;                                                // return decorated string
	}
	
	// This is the override method of the default toString()
	@Override
	public String toString() {                                     // overridden method that gives a representation of letter
		
		return decorator() + letter + decorator();
	}
	
	// To set the UNUSED label
	public void setUnused(){
		label = UNUSED;
	}

	// To set the USED label
	public void setUsed(){
		label = USED;
	}

	// To set the CORRECT label
	public void setCorrect(){
		label = CORRECT;
	}

	public boolean isUnused() {
		if (label == UNUSED) return true;                          // if attribute "label" is set to UNUSED
		return false;
	}

	public static Letter[] fromString(String s) {                  // string argument from which characters to be extracted
		
		Letter arr[] = new Letter[s.length()];                     // an array stores Letter objects in the same order in which the corresponding characters appear in s
		
		for(int i = 0; i < s.length(); i++) {                      // for each character in s a Letter object is created and stored in the array
			arr[i] = new Letter(s.charAt(i));
		}
		
		return arr;                                                // returns an array of the Letter from the string s
	}
	
}
