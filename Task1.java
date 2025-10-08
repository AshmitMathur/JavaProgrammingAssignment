import java.util.*;

public class Task1 {

    // Appending Strings Method
    public static String append(String original, String toAppend) {
        return original + toAppend;
    }

    // Counting Number of Words in a String
    public static int countWords(String str) {
        if (str == null || str.isEmpty()) return 0;
	// Counting words when Empty Space between words.
        String[] words = str.trim().split("\\s+");
	// Return Length of word.
        return words.length;
    }

	// check if substring matches and return
     boolean matchesAt(String a, int idx) {
        if (idx + a.length() > currentString.length()) return false;

       for (int j = 0; j < a.length(); j++) {
          if (currentString.charAt(idx + j) != a.charAt(j)) {
            return false; 
           }
    }
    return true; 
}

// replaces occurences of string a with string b
    String replacestr(String a, String b) {

      String result = "";
       int idx = 0;

      while (idx < currentString.length()) {
        if (matchesAt(a, idx)) {
            result += b;
            idx += a.length(); 
        } else {
            result += currentString.charAt(idx);
            idx++;
        }
      }

       return result;
}


    // Checking Palindrome
    public static boolean isPalindrome(String str) {
	// First Convert all words into Lower Case
        String clean = str.replaceAll("\\s+", "").toLowerCase();
	// Build new string using StringBuilder
        StringBuilder sb = new StringBuilder(clean);
	// If Palindrome Reverse will be equal to use equals method for the same
        return clean.equals(sb.reverse().toString());
    }

    // Taking substring from Original Substring
    public static String splice(String str, int start, int end) {
	// Base Condition when invalid ranges of start and end given for string str
        if (start < 0 || end > str.length() || start >= end) return "Invalid range!";
	// Now return The newly obtained Substring
        return str.substring(start, end);
    }

    // Split the Entire String into Words
    public static void split(String str) {
	// Store Strings into a String array
        String[] words = str.split("\\s+");
        System.out.println("Split words:");
	// Start a Loop to print all the words present in the words array
        for (String word : words) {
            System.out.println(word);
        }
    }

    // Finding Max Repeating Character
    public static char maxRepeatingCharacter(String str) {
        int[] freq = new int[256];
	// Storing Frequency of all Ascii(0-255) characters in a frequency array
        for (char c : str.toCharArray()) freq[c]++;
        int max = 0;
        char result = ' ';
	// Using a loop to find the max number of character in the given frequency array
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                result = (char) i;
            }
        }
        return result;
    }

    // Sorting characters alphabetically in a string
    public static String sort(String str) {
	for(int i=0 ; i<str.length() ; i++){
			for(int j=0 ; j<str.length() - i - 1 ; i++) {
				if(s.charAt(j) > s.charAt(j+1)) {
					char t = s.charAt(j);
					s.setCharAt(j, s.charAt(j+1));
					s.setCharAt(j+1,t);
				}
			}
		}
    }

    // Shifting characters in a string left by the given
public static String shift(String str, int n) {
    int len = str.length();
	// Check whether the String is empty
    if (len == 0) return str; 
	// Make sure len of string is not more than size
    n = n % len;                     
	// Handling Negative 
    if (n < 0) n += len;             
    return str.substring(n) + str.substring(0, n);
}


    // Reversing of A string
    public static String reverse(String str) {
	// Reverse string using stringbuilder and reverse and convert to string
        StringBuilder first = new StringBuider();
		for(int i = str.length() - 1 ; i >= 0 ; i--) temp.insert(first.length(),s.charAt(i));
		str = first;
    }

    // Main Block for this Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\nChoose an operation:");
        System.out.println("1.Append, 2.CountWords, 3.Replace, 4.isPalindrome, 5.Splice, 6.Split, 7.MaxRepeatingCharacter, 8.Sort, 9.Shift, 10.Reverse");
        System.out.print("Enter operation: ");
        //String choice = sc.next();
	int choice = sc.nextInt();

        sc.nextLine(); // consume leftover newline

        switch (choice) {
            case 1:
                System.out.print("Enter string to append: ");
                String toAppend = sc.nextLine();
                System.out.println("Result: " + append(input, toAppend));
                break;

            case 2:
                System.out.println("Word Count: " + countWords(input));
                break;

            case 3:
                System.out.print("Enter target substring: ");
                String target = sc.nextLine();
                System.out.print("Enter replacement substring: ");
                String replacement = sc.nextLine();
                System.out.println("Result: " + replace(input, target, replacement));
                break;

            case 4:
                System.out.println(isPalindrome(input) ? "Palindrome" : "Not Palindrome");
                break;

            case 5:
                System.out.print("Enter start index: ");
                int start = sc.nextInt();
                System.out.print("Enter end index: ");
                int end = sc.nextInt();
                System.out.println("Spliced String: " + splice(input, start, end));
                break;

            case 6:
                split(input);
                break;

            case 7:
                System.out.println("Max Repeating Character: " + maxRepeatingCharacter(input));
                break;

            case 8:
                System.out.println("Sorted String: " + sort(input));
                break;

            case 9:
                System.out.print("Enter number of characters to shift: ");
                int n = sc.nextInt();
                System.out.println("Shifted String: " + shift(input, n));
                break;

            case 10:
                System.out.println("Reversed String: " + reverse(input));
                break;

            default:
                System.out.println("Invalid Operation!");
        }

        sc.close();
    }

}

