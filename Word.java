// This class represents a word in the game that is comprised of any number of letters
public class Word {                                               
	
	// private variable
	private LinearNode<Letter> firstLetter;                       // a reference to the first node in the linked list
	
	// Constructor
	public Word(Letter[] letters) {
		
		firstLetter = new LinearNode<Letter>();                   // instance variable pointing to the first node of the linked list
		
		for (Letter iter : letters) {
			
			LinearNode<Letter> node = new LinearNode<Letter>(iter);
			LinearNode<Letter> ptr = firstLetter;
			
			while (ptr.getNext() != null) {
				ptr = ptr.getNext();
			}
			
			ptr.setNext(node);
		}
	}

	// This is the override method of the default toString()
	@Override
	public String toString() {
		
		String res = "Word: ";
		LinearNode<Letter> iter = firstLetter;
		
		while (iter != null) {
			
			try {
				res += iter.getElement().toString() + " ";
			} catch (NullPointerException e) {
				iter = iter.getNext();
				continue;
			}
			
			iter = iter.getNext();
		}
		
		return res;
	}

	// Takes a mystery word as a parameter and updates each of Letters "label" attribute contained in this Word object with respect to the mystery word
	private boolean Exists(Word w, Letter l) {
		
		LinearNode<Letter> iter = w.firstLetter.getNext();
		
		while (iter != null) {
			
			try {
				// iter.getElement().print();
				if (iter.getElement().equals(l))
					return true;
			} catch (NullPointerException e) {
				iter = iter.getNext();
				continue;
			}
			iter = iter.getNext();
		}
		return false;
	}

	public boolean labelWord(Word mystery) {                                 // mystery Word identifier to be checked and update
		LinearNode<Letter> iter = firstLetter.getNext();
		LinearNode<Letter> iter2 = mystery.firstLetter.getNext();
		
		while (iter != null) {
			Letter l = iter.getElement();
			iter.getElement().setUnused();
			
			if (Exists(mystery, iter.getElement()))
				l.setUsed();
			
			if (l.equals(iter2.getElement()))
			l.setCorrect();
			iter = iter.getNext();
			
			if (iter2.getNext() == null) continue;
			iter2 = iter2.getNext();
			
		}
		
		if (this.equals(mystery))
			return true;                                                     // return true if both word contains same values
		return false;
	}
}
