

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess functio(n.
		System.out.println(preProcess("What? No way!!!"));
		
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		str1= preProcess(str1);
		str2= preProcess(str2);
		
		String processedStr1 = "";
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != ' ') {
				processedStr1 = processedStr1 + str1.charAt(i);
			}
		}
		String processedStr2 = "";
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) != ' ') {
				processedStr2 = processedStr2 + str2.charAt(i);
			}
		}
		str1 = processedStr1;
		str2 = processedStr2;

		if (str1.length()!=str2.length())
		{
			return false;
		}

		for (char c = 'a' ; c <= 'z' ; c++)
			{
				int count1= 0;
				int count2= 0;
				for (int i=0 ; i<str1.length(); i++)
				{
					if (str1.charAt(i)== c)
					{
						count1++;
					}	
				}
				for (int i=0 ; i<str2.length(); i++)
				{
					if (str2.charAt(i)== c)
					{
						count2++;
					}
				}
				if (count1!=count2)
				{
					return false;
				}
			}
			return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		str = str.toLowerCase();
            String word = "";
		for (int i=0; i<str.length(); i++)
		{
			if ((str.charAt(i)>= 'a' && str.charAt(i)<= 'z' || str.charAt(i)== ' '))
			{
				word = word + str.charAt(i);
			}
		}
		return word;
	} 
	  
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		//System.out.println((int)(Math.random()*(str.length())-1));
		int ran;
		String str1 = "";
		String temp = "";
		
		while (str.length()>0)
		{
			ran = (int)(Math.random()*(str.length()));
			str1 = str1 + str.charAt(ran);
			for (int i=0; i<str.length(); i++)
			{
				if (i!= ran)
				{
					temp = temp + str.charAt(i);
				}
			}
			str = temp;
			temp = "";
		}
		return str1;
	}
}
