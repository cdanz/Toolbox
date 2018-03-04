/*
 * Craig Danz
 * CPSC 5011, Seattle University
 * This is a free and unencumbered software released into the public domain.
 */
//package danz_p5;

import java.util.*;

/**
 * This class demonstrates the functionality of three different objects 
 * (SequenceEnum, SeqExtract, SpasEnum) which all extend the functionality 
 * of their base/parent class Sequence. Sequence also implements Inverter. 
 * The interplay of the relationships amongst these 5 classes is what is being
 * looked at here. 
 * @author danzc
 */
public class P5 {
	private static Scanner keyboard = new Scanner(System.in);
	private static final int SIZE = 12; //Size of collection

	/**
	 * This main method acts as the driver of the program.
	 */
	public static void main(String[] args) {
		/*welcome();
		do {
			String providedWord; //user determined word
			do {
				System.out.print("What word would you like to use that is "
						+ "at least 3 characters long?: ");
				providedWord = keyboard.nextLine();
			} while (providedWord.length() < 3);
			Inverter [] collection = new Inverter[SIZE];
			for(int i = 0; i < collection.length; i++) {
				if (i % 4 == 0) //4 because I have 4 class types I would 
					//like to cycle through to demonstrate
					collection[i] = new Sequence();
				else if (i % 4 == 1)
					collection[i] = new SequenceEnum();
				else if (i % 4 == 2)
					collection[i] = new SeqExtract();
				else 
					collection[i] = new SpasEnum();
			}
			System.out.println("\nAll objects should be inactive initially.");
			for(int i = 0; i < collection.length; i++) {
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Active?: " + 
						collection[i].isOn());
			}
			System.out.println("\nNow initialize with the word " + 
							providedWord + ".");
			for(int i = 0; i < collection.length; i++) {
				collection[i].setWord(providedWord);
			}
			System.out.println("\nAnd all objects should now be active.");
			for(int i = 0; i < collection.length; i++) {
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Active?: " + 
						collection[i].isOn());
			}
			System.out.println("\nLet's see what each emits.");
			for(int i = 0; i < collection.length; i++) {
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - " + 
						collection[i].emit());
			}
			System.out.println("\nMany functions common to all objects are "
					+ "not defined in the \ninterface so they can't be "
					+ "called directly from the collection but \nthere is a "
					+ "work around for testing.");
			System.out.println("\nTest Guess:");
			for(int i = 0; i < collection.length; i++) {
				Sequence s = (Sequence)collection[i];
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Guess " + 
						providedWord + " - " + s.guess(providedWord));
			}
			System.out.println("\nTest Reset:");
			for(int i = 0; i < collection.length; i++) {
				Sequence s = (Sequence)collection[i];
				s.reset();
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Reset. Active? - " + s.isOn());
			}
			for(int i = 0; i < collection.length; i++) {
				collection[i].setWord(providedWord);
			}
			System.out.println("\nTwo classes have functions unique to them.");
			System.out.println("\nFind them and test them:");
			SeqExtract q = new SeqExtract();
			SpasEnum p = new SpasEnum();
			for(int i = 0; i < collection.length; i++) {
				if (collection[i].getClass() == q.getClass()) {
					//test overloaded emit
					SeqExtract s = (SeqExtract)collection[i];
					System.out.println("Element " + (i + 1) + " - " + 
							collection[i].getClass() + " - Overloaded emit: " +
							s.emit(subSequence(providedWord)));
				}
				else if (collection[i].getClass() == p.getClass()) {
					//test overloaded emit
					SpasEnum s = (SpasEnum)collection[i];
					System.out.println("Element " + (i + 1) + " - " + 
							collection[i].getClass() + " - Alternative emit: "
							+ s.emitTrunc());
				}
				else
				System.out.println("Element " + (i + 1) + " - " + 
						collection[i].getClass() + " - Nothing special.");
			}
			System.out.println("\nThat's all the functionality to test.");
		} while (repeat("\nWould you like to run through this again? Y/N: "));
		farewell();*/
		s = ".glyphicon-align-left:before{content:\"\\e052\"}.glyphicon-align-center:before{content:\"\\e053\"}.glyphicon-align-right:before{content:\"\\e054\"}.glyphicon-align-justify:before{content:\"\\e055\"}.glyphicon-list:before{content:\"\\e056\"}.glyphicon-indent-left:before{content:\"\\e057\"}.glyphicon-indent-right:before{content:\"\\e058\"}.glyphicon-facetime-video:before{content:\"\\e059\"}.glyphicon-picture:before{content:\"\\e060\"}.glyphicon-map-marker:before{content:\"\\e062\"}.glyphicon-adjust:before{content:\"\\e063\"}.glyphicon-tint:before{content:\"\\e064\"}.glyphicon-edit:before{content:\"\\e065\"}.glyphicon-share:before{content:\"\\e066\"}.glyphicon-check:before{content:\"\\e067\"}.glyphicon-move:before{content:\"\\e068\"}.glyphicon-step-backward:before{content:\"\\e069\"}.glyphicon-fast-backward:before{content:\"\\e070\"}.glyphicon-backward:before{content:\"\\e071\"}.glyphicon-play:before{content:\"\\e072\"}.glyphicon-pause:before{content:\"\\e073\"}.glyphicon-stop:before{content:\"\\e074\"}.glyphicon-forward:before{content:\"\\e075\"}.glyphicon-fast-forward:before{content:\"\\e076\"}.glyphicon-step-forward:before{content:\"\\e077\"}.glyphicon-eject:before{content:\"\\e078\"}.glyphicon-chevron-left:before{content:\"\\e079\"}.glyphicon-chevron-right:before{content:\"\\e080\"}.glyphicon-plus-sign:before{content:\"\\e081\"}.glyphicon-minus-sign:before{content:\"\\e082\"}.glyphicon-remove-sign:before{content:\"\\e083\"}.glyphicon-ok-sign:before{content:\"\\e084\"}.glyphicon-question-sign:before{content:\"\\e085\"}.glyphicon-info-sign:before{content:\"\\e086\"}.glyphicon-screenshot:before{content:\"\\e087\"}.glyphicon-remove-circle:before{content:\"\\e088\"}.glyphicon-ok-circle:before{content:\"\\e089\"}.glyphicon-ban-circle:before{content:\"\\e090\"}.glyphicon-arrow-left:before{content:\"\\e091\"}.glyphicon-arrow-right:before{content:\"\\e092\"}.glyphicon-arrow-up:before{content:\"\\e093\"}.glyphicon-arrow-down:before{content:\"\\e094\"}.glyphicon-share-alt:before{content:\"\\e095\"}.glyphicon-resize-full:before{content:\"\\e096\"}.glyphicon-resize-small:before{content:\"\\e097\"}.glyphicon-exclamation-sign:before{content:\"\\e101\"}.glyphicon-gift:before{content:\"\\e102\"}.glyphicon-leaf:before{content:\"\\e103\"}.glyphicon-fire:before{content:\"\\e104\"}.glyphicon-eye-open:before{content:\"\\e105\"}.glyphicon-eye-close:before{content:\"\\e106\"}.glyphicon-warning-sign:before{content:\"\\e107\"}.glyphicon-plane:before{content:\"\\e108\"}.glyphicon-calendar:before{content:\"\\e109\"}.glyphicon-random:before{content:\"\\e110\"}.glyphicon-comment:before{content:\"\\e111\"}.glyphicon-magnet:before{content:\"\\e112\"}.glyphicon-chevron-up:before{content:\"\\e113\"}.glyphicon-chevron-down:before{content:\"\\e114\"}.glyphicon-retweet:before{content:\"\\e115\"}.glyphicon-shopping-cart:before{content:\"\\e116\"}.glyphicon-folder-close:before{content:\"\\e117\"}.glyphicon-folder-open:before{content:\"\\e118\"}.glyphicon-resize-vertical:before{content:\"\\e119\"}.glyphicon-resize-horizontal:before{content:\"\\e120\"}.glyphicon-hdd:before{content:\"\\e121\"}.glyphicon-bullhorn:before{content:\"\\e122\"}.glyphicon-bell:before{content:\"\\e123\"}.glyphicon-certificate:before{content:\"\\e124\"}.glyphicon-thumbs-up:before{content:\"\\e125\"}.glyphicon-thumbs-down:before{content:\"\\e126\"}.glyphicon-hand-right:before{content:\"\\e127\"}.glyphicon-hand-left:before{content:\"\\e128\"}.glyphicon-hand-up:before{content:\"\\e129\"}.glyphicon-hand-down:before{content:\"\\e130\"}.glyphicon-circle-arrow-right:before{content:\"\\e131\"}.glyphicon-circle-arrow-left:before{content:\"\\e132\"}.glyphicon-circle-arrow-up:before{content:\"\\e133\"}.glyphicon-circle-arrow-down:before{content:\"\\e134\"}.glyphicon-globe:before{content:\"\\e135\"}.glyphicon-wrench:before{content:\"\\e136\"}.glyphicon-tasks:before{content:\"\\e137\"}.glyphicon-filter:before{content:\"\\e138\"}.glyphicon-briefcase:before{content:\"\\e139\"}.glyphicon-fullscreen:before{content:\"\\e140\"}.glyphicon-dashboard:before{content:\"\\e141\"}.glyphicon-paperclip:before{content:\"\\e142\"}.glyphicon-heart-empty:before{content:\"\\e143\"}.glyphicon-link:before{content:\"\\e144\"}.glyphicon-phone:before{content:\"\\e145\"}.glyphicon-pushpin:before{content:\"\\e146\"}.glyphicon-usd:before{content:\"\\e148\"}.glyphicon-gbp:before{content:\"\\e149\"}.glyphicon-sort:before{content:\"\\e150\"}.glyphicon-sort-by-alphabet:before{content:\"\\e151\"}.glyphicon-sort-by-alphabet-alt:before{content:\"\\e152\"}.glyphicon-sort-by-order:before{content:\"\\e153\"}.glyphicon-sort-by-order-alt:before{content:\"\\e154\"}.glyphicon-sort-by-attributes:before{content:\"\\e155\"}.glyphicon-sort-by-attributes-alt:before{content:\"\\e156\"}.glyphicon-unchecked:before{content:\"\\e157\"}.glyphicon-expand:before{content:\"\\e158\"}.glyphicon-collapse-down:before{content:\"\\e159\"}.glyphicon-collapse-up:before{content:\"\\e160\"}.glyphicon-log-in:before{content:\"\\e161\"}.glyphicon-flash:before{content:\"\\e162\"}.glyphicon-log-out:before{content:\"\\e163\"}.glyphicon-new-window:before{content:\"\\e164\"}.glyphicon-record:before{content:\"\\e165\"}.glyphicon-save:before{content:\"\\e166\"}.glyphicon-open:before{content:\"\\e167\"}.glyphicon-saved:before{content:\"\\e168\"}.glyphicon-import:before{content:\"\\e169\"}.glyphicon-export:before{content:\"\\e170\"}.glyphicon-send:before{content:\"\\e171\"}.glyphicon-floppy-disk:before{content:\"\\e172\"}.glyphicon-floppy-saved:before{content:\"\\e173\"}.glyphicon-floppy-remove:before{content:\"\\e174\"}.glyphicon-floppy-save:before{content:\"\\e175\"}.glyphicon-floppy-open:before{content:\"\\e176\"}.glyphicon-credit-card:before{content:\"\\e177\"}.glyphicon-transfer:before{content:\"\\e178\"}.glyphicon-cutlery:before{content:\"\\e179\"}.glyphicon-header:before{content:\"\\e180\"}.glyphicon-compressed:before{content:\"\\e181\"}.glyphicon-earphone:before{content:\"\\e182\"}.glyphicon-phone-alt:before{content:\"\\e183\"}.glyphicon-tower:before{content:\"\\e184\"}.glyphicon-stats:before{content:\"\\e185\"}.glyphicon-sd-video:before{content:\"\\e186\"}.glyphicon-hd-video:before{content:\"\\e187\"}.glyphicon-subtitles:before{content:\"\\e188\"}.glyphicon-sound-stereo:before{content:\"\\e189\"}.glyphicon-sound-dolby:before{content:\"\\e190\"}.glyphicon-sound-5-1:before{content:\"\\e191\"}.glyphicon-sound-6-1:before{content:\"\\e192\"}.glyphicon-sound-7-1:before{content:\"\\e193\"}.glyphicon-copyright-mark:before{content:\"\\e194\"}.glyphicon-registration-mark:before{content:\"\\e195\"}.glyphicon-cloud-download:before{content:\"\\e197\"}.glyphicon-cloud-upload:before{content:\"\\e198\"}.glyphicon-tree-conifer:before{content:\"\\e199\"}.glyphicon-tree-deciduous:before{content:\"\\e200\"}.glyphicon-cd:before{content:\"\\e201\"}.glyphicon-save-file:before{content:\"\\e202\"}.glyphicon-open-file:before{content:\"\\e203\"}.glyphicon-level-up:before{content:\"\\e204\"}.glyphicon-copy:before{content:\"\\e205\"}.glyphicon-paste:before{content:\"\\e206\"}.glyphicon-alert:before{content:\"\\e209\"}.glyphicon-equalizer:before{content:\"\\e210\"}.glyphicon-king:before{content:\"\\e211\"}.glyphicon-queen:before{content:\"\\e212\"}.glyphicon-pawn:before{content:\"\\e213\"}.glyphicon-bishop:before{content:\"\\e214\"}.glyphicon-knight:before{content:\"\\e215\"}.glyphicon-baby-formula:before{content:\"\\e216\"}.glyphicon-tent:before{content:\"\\26fa\"}.glyphicon-blackboard:before{content:\"\\e218\"}.glyphicon-bed:before{content:\"\\e219\"}.glyphicon-apple:before{content:\"\\f8ff\"}.glyphicon-erase:before{content:\"\\e221\"}.glyphicon-hourglass:before{content:\"\\231b\"}.glyphicon-lamp:before{content:\"\\e223\"}.glyphicon-duplicate:before{content:\"\\e224\"}.glyphicon-piggy-bank:before{content:\"\\e225\"}.glyphicon-scissors:before{content:\"\\e226\"}.glyphicon-bitcoin:before{content:\"\\e227\"}.glyphicon-btc:before{content:\"\\e227\"}.glyphicon-xbt:before{content:\"\\e227\"}.glyphicon-yen:before{content:\"\\00a5\"}.glyphicon-jpy:before{content:\"\\00a5\"}.glyphicon-ruble:before{content:\"\\20bd\"}.glyphicon-rub:before{content:\"\\20bd\"}.glyphicon-scale:before{content:\"\\e230\"}.glyphicon-ice-lolly:before{content:\"\\e231\"}.glyphicon-ice-lolly-tasted:before{content:\"\\e232\"}.glyphicon-education:before{content:\"\\e233\"}.glyphicon-option-horizontal:before{content:\"\\e234\"}.glyphicon-option-vertical:before{content:\"\\e235\"}.glyphicon-menu-hamburger:before{content:\"\\e236\"}.glyphicon-modal-window:before{content:\"\\e237\"}.glyphicon-oil:before{content:\"\\e238\"}.glyphicon-grain:before{content:\"\\e239\"}.glyphicon-sunglasses:before{content:\"\\e240\"}.glyphicon-text-size:before{content:\"\\e241\"}.glyphicon-text-color:before{content:\"\\e242\"}.glyphicon-text-background:before{content:\"\\e243\"}.glyphicon-object-align-top:before{content:\"\\e244\"}.glyphicon-object-align-bottom:before{content:\"\\e245\"}.glyphicon-object-align-horizontal:before{content:\"\\e246\"}.glyphicon-object-align-left:before{content:\"\\e247\"}.glyphicon-object-align-vertical:before{content:\"\\e248\"}.glyphicon-object-align-right:before{content:\"\\e249\"}.glyphicon-triangle-right:before{content:\"\\e250\"}.glyphicon-triangle-left:before{content:\"\\e251\"}.glyphicon-triangle-bottom:before{content:\"\\e252\"}.glyphicon-triangle-top:before{content:\"\\e253\"}.glyphicon-console:before{content:\"\\e254\"}.glyphicon-superscript:before{content:\"\\e255\"}.glyphicon-subscript:before{content:\"\\e256\"}.glyphicon-menu-left:before{content:\"\\e257\"}.glyphicon-menu-right:before{content:\"\\e258\"}.glyphicon-menu-down:before{content:\"\\e259\"}.glyphicon-menu-up:before{content:\"\\e260\"}";
		System.out.print(parseHard(s));
	}
	
	
	/**
	 * Welcomes the user with a friendly message.
	 */
	public static void welcome() {
		System.out.println("\n--------------------------------\n\n" +
	                       "   P5 - The Final Frontier\n\n" +
				           "---------------------------------\n\n" +
	                       "A Craig Danz Production\n");
	}
	
	/**
	 * This helper method creates a subsequence of a string parameter. 
	 * @param s				String to pull a subsequence from
	 * @return String		Subsequence of string.
	 */
	public static String subSequence(String s) {
		Random random = new Random();
		String newString = "";
		int atSubStart = random.nextInt(s.length() - 1);
		int atSubEnd = 0;
		do {
			atSubEnd = random.nextInt(s.length());
		} while (atSubEnd <= atSubStart); //Make sure you get a character index
		// greater than the start.
		
		for (int j = 0; j < (atSubEnd - atSubStart + 1); j++) {
			newString += s.charAt(atSubStart + j);
		}
		return newString;
	}
	
	/**
	 * This method checks to see if the user wants to perform an action again
	 * specified by the message passed to it. 
	 * @param msg			What do you want them to repeat? 
	 * @return boolean		If a desire to repeat : true else false.
	 */
	public static boolean repeat(String msg) {
		String input;
		char repeat;
		
		System.out.print(msg);
		input = keyboard.nextLine();
		repeat = input.charAt(0);
		if (repeat == 'y' || repeat == 'Y')
			return true;
		return false;
	}
	
	/**
	 * Bids the user farewell before exiting the program.
	 */
	public static void farewell()
	{
		keyboard.close();
		System.out.println("\n\nWe hope you enjoyed playing with some classes!\n\n");
	}
	public static String parseHard(String s)
	{
		for(int i = 0; i<s.length(); i++) {
			if (s.charAt(i) == '{') {
				s = s.substring(0, i) + "\n\t" + s.substring(i, s.length());
			}
			else if (s.charAt(i) == '}') {
				s = s.substring(0, i) + ";\n" + s.substring(i, s.length());
			}
		}
	}
}
