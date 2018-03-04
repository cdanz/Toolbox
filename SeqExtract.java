/*
 * Craig Danz
 * CPSC 5011, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */
package danz_p5;

/**
 * This class extends the Sequence class inheriting all of its functionality
 * only a single extra overloaded version of emit is added that takes in a 
 * parameter.
 * @author danzc
 */
public class SeqExtract extends Sequence{

	/**
	 * This emit method has a parameter unlike the base class so instead of 
	 * overriding that emit function it simply inherits it when emit is 
	 * called without a parameter and this one is used when it is called with 
	 * a string parameter. This emit function extracts a subsequence from the 
	 * encapsulated word, if the subsequence parameter is found. For example, 
	 * if the word ‘believe’ is stored with the parent and the subsequence 
	 * ‘beli’ proffered, ‘eve’ would be emitted; likewise, if the word 
	 * ‘evening’ were encapsulated and the subsequence ‘ning’ proffered, 
	 * ‘eve’ would be emitted.
	 * Note: if the substring proffered appears more than once in the 
	 * encapsulated string than only the first instance will be removed.
	 * Precondition - Object must be active to use.
	 * Post condition - no change from precondition
	 * @exception 			Return string literal "ERROR" if illegally called
	 * @exception 			Return string literal "No Match" if argument is 
	 * 						not valid subsequence. 
	 * @param in 			An attempt to offer a subsequence of characters 
	 * 						in the encapsulated word.
	 * @return String		All remaining characters from encapsulated word 
	 * 						not in the parameter's subsequence.
	 */
	String emit(String in) {
		boolean match = false;
		String newString = ""; //built string of characters not in parameter
		int atSubStart = 0, atSubEnd = 0; //first and last index of where substring
										// is found
		
		if (active && (in.length() < word.length())) { //substring can't be longer
			for (int k = 0; k < word.length(); k++) { //go through char by char
				if ((word.charAt(k) == in.charAt(0)) &&
						((k + in.length()) <= word.length())) { //must match and have
										// enough remaining characters to evaluate.
					match = true;
					atSubStart = k;
					atSubEnd = atSubStart + in.length() - 1;
					for (int j = 0, m = k; j < in.length(); j++, m++) {
						if (word.charAt(m) == in.charAt(j) && match) {
							match = true;
						} else
							match = false;
						
						}
					}
					if (match) {
						for (int n = 0; n < word.length(); n++) {
							if (n < atSubStart || n > atSubEnd)
								newString += word.charAt(n);
						}
						return newString;
					}
			}
			return "No Match";
		}
		return "ERROR";
	}
}
