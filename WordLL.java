// This class keeps a history of the past word guesses in a linked structure
public class WordLL {                                                        
	
	// private variables
	private Word mysteryWord;
	private LinearNode<Word> history;

	// Constructor
	public WordLL(Word mystery) {
		
		history = new LinearNode<Word>();                                    // initialise an empty history
		mysteryWord = mystery;                                               // set the mysteryWord attribute to the parameter mystery
	}

	// Takes a Word as an argument to test against this games' mystery word
	public boolean tryWord(Word guess) {                                     // guess a word identifier to be checked
		
		guess.labelWord(mysteryWord);
		LinearNode<Word> el = new LinearNode<Word>(guess);
		LinearNode<Word> ptr = history;
		
		while (ptr.getNext() != null)
			ptr = ptr.getNext();
		ptr.setNext(el);
		mysteryWord.labelWord(guess);
		
		if (guess.toString().equals(mysteryWord.toString())) return true;    // returns true if guessed word and mysteryWord is identical
		return false;
	}

	// This is the override method of the default toString()
	@Override
	public String toString() {
		
		String res = "";
		LinearNode<Word> iter = history.getNext();
		
		while (iter != null) {
			res += iter.getElement().toString() + "\n";
			iter = iter.getNext();
		}
		return res;
	}
}
