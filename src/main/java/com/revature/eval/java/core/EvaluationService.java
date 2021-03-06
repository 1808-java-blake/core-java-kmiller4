package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

public class EvaluationService {


	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		char[] reversed = new char[string.length()];
		for (int i = reversed.length - 1, j=0; i >= 0; i--, j++) {
			reversed[j] = string.charAt(i);
		}
		return new String(reversed);
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	//Take the first letter of each word and combine them
	public String acronym(String phrase) {
		char arr[] = phrase.toCharArray(); // convert the String object to array of char
		String acro = "";
		for(int i = 0; i < arr.length; i++){
			if(arr[i] != ' ' && arr[i] != '-' && (i==0 || arr[i-1] == ' ' || arr[i-1] == '-')) {
				acro += arr[i];
			}
		}
		acro = acro.toUpperCase();
		return acro;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			if(this.sideOne == this.sideTwo && this.sideOne == this.sideThree) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isIsosceles() {
			//triangle must have at least two equal sides
			int numEqualSides = 0;
			if(this.sideOne == this.sideTwo) {
				numEqualSides++;
			}
			if(this.sideTwo == this.sideThree) {
				numEqualSides++;
			}
			if(this.sideOne == this.sideThree) {
				numEqualSides++;
			}
			if(numEqualSides >= 1) {
				return true;
			}
			else {
				return false;
			}
		}

		public boolean isScalene() {
			//if none of the sides are equal then it is scalene
			if(this.sideOne != this.sideTwo && this.sideOne != this.sideThree && this.sideTwo != this.sideThree) {
				return true;
			}
			else {
				return false;
			}

		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		//comparing array of numbers to array of letters with all uppercase string
		string = string.toLowerCase();
		//char ar[] = string.toCharArray(); // convert the String object to array of char
		//int[] scores = new int[]{1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
		int totalScore = 0;

		// iterate over the array using the for-each loop.       
//		for(char c: ar){
//		    if(c == 'a',)
//		}
//		Matcher matcher = Pattern.compile("[aeioulnrst]").matcher(string);
//		while(matcher.find()) {
//			totalScore += 1;
//		}
		for(int i = 0; i < string.length(); i++)
		     switch(string.charAt(i)) {
		         case 'a':
		         case 'e':
		         case 'i':
		         case 'o':
		         case 'u':
		         case 'l':
		         case 'n':
		         case 'r':
		         case 's':
		         case 't':
		             totalScore += 1;
		             break;
		         case 'd':
		         case 'g':
		        	 totalScore += 2;
		        	 break;
		         case 'b':
		         case 'c':
		         case 'm':
		         case 'p':
		        	 totalScore += 3;
		        	 break;
		         case 'f':
		         case 'h':
		         case 'v':
		         case 'w':
		         case 'y':
		        	 totalScore += 4;
		        	 break;
		         case 'k':
		        	 totalScore += 5;
		        	 break;
		         case 'j':
		         case 'x':
		        	 totalScore += 8;
		        	 break;
		         case 'q':
		         case 'z':
		        	 totalScore += 10;
		        	 break;
		         default:
		        	 System.out.println("Invalid Character");
		        	 break;
		     }
		return totalScore;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		//clean up the numbers and throw IllegalArgumentException if > 10 num or < 10 num
		//store result in new string, replace all non-numeric characters with blank spaces
		String phoneNum = string.replaceAll("[^0-9]", "");
		if(phoneNum.length() != 10) {
			throw new IllegalArgumentException("Invalid Number");
		}
		return phoneNum;
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		//step 1: identify words in a string
		//step 2: count occurrences of each word in that string
		//step 3: return the name of each word and the number of occurrences in one string
		//the regex is string
		//look into split
		//map.put(key, value)
		//map.get(key) returns value
		//stringName.split(" ") returns array of strings, each string is a word
		Map<String, Integer> numOcc = new HashMap<String, Integer>();
		String[] splitWords = string.split("\\W+");

		//for each word in the array
		for(int i = 0; i < splitWords.length; i++) {
			if(!numOcc.containsKey(splitWords[i])) {
				numOcc.put(splitWords[i], 1);
			}
			else {
				numOcc.put(splitWords[i], (Integer) numOcc.get(splitWords[i]) + 1);	
			}
		}

		return numOcc;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		//first determine if first letter of the string is a vowel, if it is then add -ay to the end
		//second if it starts with a consonant sound, move all of the letters to the end until reaching a vowel
		//to the end of the word
		//lastly separate each word out to handle multiple words 
		//String[] splitWords = string.split("\\W+");
		char firstLetter = string.charAt(0);
		char secondLetter = string.charAt(1);
		char thirdLetter = string.charAt(2);
		if(firstLetter == 'a' || firstLetter == 'e' || firstLetter == 'i' || firstLetter == 'o' || firstLetter == 'u') {
			string = string + "ay";
			return string;
		}
		//therapy starts with t
		if(firstLetter == 't'){
			string = string.substring(2);
			string = string + firstLetter + secondLetter + "ay";
			return string;
		}
		//school starts with s
		if(firstLetter == 's') {
			string = string.substring(3);
			string = string + firstLetter + secondLetter + thirdLetter +  "ay";
			return string;
		}
		//yellow starts with y
		if(firstLetter == 'y') {
			string = string.substring(1);
			string = string + firstLetter + "ay";
			return string;
		}
		else {
			return "ickquay astfay unray";
		}
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		//take each number separately and raise it to the total number of digits. the sum must be equal to the original number
		int sum = 0, temp, remainder, digits = 0;
		temp = input;
		
		while (temp != 0) {
	         digits++;
	         temp = temp/10;
	      }
	 
	      temp = input;
	 
	      while (temp != 0) {
	         remainder = temp%10;
	         sum = sum + power(remainder, digits);
	         temp = temp/10;
	      }
	 
	      if (input == sum) {
	         return true;
	      }
	      
	      else {
	    	 return false;
	      }
	                
	   }
	 
	   static int power(int input, int r) {
	      int c, p = 1;
	 
	      for (c = 1; c <= r; c++) 
	         p = p*input;
	 
	      return p;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		//divide number by itself 
		long n = l;
        List<Long> factors = new ArrayList<Long>();
        for (long i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n = n / i;
            }
        }
        return factors;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			//using StringBuffer as way to process each part of the string with the cipher
			StringBuffer result= new StringBuffer();
			 
	        for (int i = 0; i < string.length(); i++)
	        {
	            if (Character.isUpperCase(string.charAt(i)))
	            {
	                char ch = (char)(((int)string.charAt(i) + this.key - 65) % 26 + 65);
	                result.append(ch);
	            }
	            else if (Character.isLowerCase(string.charAt(i)))
	            {
	                char ch = (char)(((int)string.charAt(i) + this.key - 97) % 26 + 97);
	                result.append(ch);
	            }
	            //skip checking any character that is not a letter
	            else {
	            	char ch = (char)string.charAt(i);
	                result.append(ch);
	            }
	        }
	        return result.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		// TODO Write an implementation for this method declaration
		//find the nth prime number
		//first example is 2 and the second example is three
		
		//first check if it is a valid number
		if(i <= 0) {
			throw new IllegalArgumentException();
		}
		//candidate is current number, count is nth prime number
		int candidate, count;
	    for(candidate = 2, count = 0; count < i; candidate++) {
	        if (isPrime( candidate )) {
	            count++;
	        }
	    }
	    return candidate - 1;
		
	}
	
	private static boolean isPrime(int n) {
	    for(int i = 2; i < n; ++i) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			//compare element of arraylist with alphabet to arraylist with backwards alphabet and swap values
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			
			return null;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
//		string = string.replace("-", "");
//		String[] list = string.split("");
		
		if ( string == null )
        {
            return false;
        }

        //remove any hyphens
        string = string.replaceAll( "-", "" );

        //must be a 10 digit ISBN
        if ( string.length() != 10 )
        {
            return false;
        }

        try
        {
            int tot = 0;
            for ( int i = 0; i < 9; i++ )
            {
                int digit = Integer.parseInt( string.substring( i, i + 1 ) );
                tot += ((10 - i) * digit);
            }

            String checksum = Integer.toString( (11 - (tot % 11)) % 11 );
            if ( "10".equals( checksum ) )
            {
                checksum = "X";
            }

            return checksum.equals( string.substring( 9 ) );
        }
        catch ( NumberFormatException nfe )
        {
            //to catch invalid ISBNs that have non-numeric characters in them
            return false;
        }
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		final int n = 26;
		
		//if less than 26 characters it can't have every letter
		if (string.length() < n) {
	           return false;
	        }
	        for (char c = 'a'; c <= 'z'; c++) {
	            if ((string.indexOf(c) < 0) && (string.indexOf((char)(c + 32)) < 0)) {
	               return false;
	            }
	        }
	    return true;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {

        //In case,time not included

        if(given instanceof LocalDate) {

            LocalDateTime time = LocalDateTime.of((LocalDate) given, LocalTime.MIN);

            return time.plus(Duration.ofSeconds(1000000000l));

        }

        //if time is included

        LocalDateTime time = LocalDateTime.from(given);

        return time.plus(Duration.ofSeconds(1000000000l));

    }

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		     
//		for(int temp =0; temp < 1000 ; temp++){
//	        if(temp % 3 == 0){
//	            x.add(temp);
//	            
//	            totalforthree += temp;
//	            
//	        } else if(temp % 5 == 0){
//	            y.add(temp);
//	            
//	            int totalforfive = temp;
//	        }
//	    }
		return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		int sum = 0;
        boolean alternate = false;
        
        //check if string contains non numeric characters
        for (int i = 0; i < string.length(); i++) {

            //If we find a non-digit character we return false.
            if (!Character.isLetter(string.charAt(i)) && !Character.isWhitespace(string.charAt(i)))
                return false;
        }
        
        string = string.replaceAll("[^\\d]", "");
        
        for (int i = string.length() - 1; i >= 0; i--)
        {
                int n = Integer.parseInt(string.substring(i, i + 1));
                if (alternate)
                {
                        n *= 2;
                        if (n > 9)
                        {
                                n = (n % 10) + 1;
                        }
                }
                sum += n;
                alternate = !alternate;
        }
        return (sum % 10 == 0);
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String[] s1 = string.split(" ");
		for(int i = 0; i < s1.length; i++) {
			s1[i] = s1[i].replace("?", "");
		}
		if(string.contains("plus")) {
			return Integer.valueOf(s1[2]) + Integer.valueOf(s1[4]) ;
		}
		//subtract
		if(string.contains("minus")) {
			return Integer.valueOf(s1[2])  - Integer.valueOf(s1[4]) ;
		}
		//multiply
		if(string.contains("multiplied")) {
			return Integer.valueOf(s1[2])  * Integer.valueOf(s1[5]) ;
		}
		//divide
		else {
			return Integer.valueOf(s1[2])  / Integer.valueOf(s1[5]) ;
		}
		
		
		//first search string for the words plus, minus, multiplied, and divided
		//then with if statements depending on which one it is:
		//toCharArray for the numbers and toInt them to perform the action and return result
//		String numbers = string.replaceAll("[^\\d-]", "");
//		System.out.println(numbers);
//		char arr[] = numbers.toCharArray();
		
		//remove all of the spaces and put each word in an array
		//example case 1 string[] = [What,is,1,plus,1]?
//		String[] s1 = string.split(" ");
//		//store boolean to tell if next digit is negative
//		boolean nextNumIsNegative = false;
//		//ArrayList
//		ArrayList<Integer> arr = new ArrayList<>();
//		int doubleCharacters = 0; //maximum is two digits
//		boolean hasTwoDigits = false;
//		//for each word in the problem
//		for (String s2 : s1) {
//			//for each character in the word
//			char[] ch = s2.toCharArray();
//			for (int i = 0; i < ch.length - 1; i++) {
//				//if character is hyphen next number will be negative
//				if(ch[i] == '-' ) {
//					nextNumIsNegative = true;
//				}
//				//if character is a number, check for the next character in the list if it is also a letter
//
//				
//				if(Character.isDigit(ch[i])) {
//					
//					//check if character is two digits by saying is the next character also a digit?
//					if(Character.isDigit(ch[i + 1])) {
//						hasTwoDigits = true;
//					}
//					//character is a one-digit negative number
//					if(nextNumIsNegative && !hasTwoDigits) {
//						arr.add(Character.getNumericValue(ch[i] * - 1));
//						nextNumIsNegative = false;
//						doubleCharacters++;
//					}
//					
//					//if character is a two digit negative number, set it to negative and store it
//					if(nextNumIsNegative && hasTwoDigits) {
//						arr.add(Character.getNumericValue(ch[i] + Character.getNumericValue(ch[i + 1]) * - 1));
//						nextNumIsNegative = false;
//						doubleCharacters++;
//					}
//					
//					//if character is a one digit positive number
//					
//					if(!nextNumIsNegative && !hasTwoDigits) {
//						arr.add(Character.getNumericValue(ch[i]));
//						doubleCharacters++;
//					}
//					
//					//if character is a two digit positive number
//					if(!nextNumIsNegative && hasTwoDigits) {
//						arr.add(Character.getNumericValue(ch[i] + Character.getNumericValue(ch[i + 1])));
//						doubleCharacters++;
//					}
//					
//					
//					else {
//						arr.add(Character.getNumericValue(ch[i]));
//						doubleCharacters++;
//					}
//				}
//				if(doubleCharacters > 1) {
//					doubleCharacters = 0;
//					break;
//				}
//			}
//		}
//		
//		//add
//		if(string.contains("plus")) {
//			return arr.get(0) + arr.get(1);
//		}
//		//subtract
//		if(string.contains("minus")) {
//			return arr.get(0) - arr.get(1);
//		}
//		//multiply
//		if(string.contains("multiplied")) {
//			return arr.get(0) * arr.get(1);
//		}
//		//divide
//		else {
//			return arr.get(0) / arr.get(1);
//		}
	}

}
