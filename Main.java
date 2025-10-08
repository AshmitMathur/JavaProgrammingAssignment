import java.util.*;

/** 
* @Filename - MyString.java
* @description - This will perform most of the string operations
* @author - Ashmit Mathur
*/ 
public class MyString {

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

	// Verify whether the original string contains replacing string
	public static boolean match(String str, String a, int idx) {
		if (idx + a.length() > str.length()) return false;
		for (int j = 0; j < a.length(); j++) {
			if (str.charAt(idx + j) != a.charAt(j)) return false;
		}
		return true;
	}

    // Replacing the Substring
    public static String replace(String original, String target, String replacement) {
		StringBuilder result = new StringBuilder();
		int idx = 0;

		while (idx < original.length()) {
			// Check if target substring matches starting from index idx
			if (idx + target.length() <= original.length() && match(original, target, idx)) {
				result.append(replacement);
				idx += target.length();
			} else {
				result.append(original.charAt(idx));
				idx++;
			}
		}
		return result.toString();
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

    // Split the Entire String into Words and return as ArrayList
    public static ArrayList<String> split(String str) {
        ArrayList<String> wordsList = new ArrayList<>();
        // Split the string by whitespace
        String[] words = str.split("\\s+");
        // Add each word to the ArrayList
        for (String word : words) {
            wordsList.add(word);
        }
        return wordsList;
    }

    // Finding Max Repeating Character
    public static char maxRepeatingCharacter(String str) {
        int[] freq = new int[256];
	    // Storing Frequency of all Ascii characters in a frequency array
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
        // Convert string to character array
        char[] chars = str.toCharArray();
	    // Bubble Sort logic
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length - i - 1; j++) {
                if (chars[j] > chars[j + 1]) {
                    char t = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = t;
                }
            }
        }
	    // Convert back to String
        return new String(chars);
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
	    // Reverse string using StringBuilder and convert to string
        StringBuilder reversed = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			reversed.append(str.charAt(i));
		}
		return reversed.toString();
    }

    // Main Block for this Program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("\nChoose an operation:");
        System.out.println("1.Append, 2.CountWords, 3.Replace, 4.isPalindrome, 5.Splice, 6.Split, 7.MaxRepeatingCharacter, 8.Sort, 9.Shift, 10.Reverse 11.Exit");
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
                ArrayList<String> words = split(input);
                //System.out.println("Split words:");
		//System.out.print("[");
                //for (String word : words) {
                //    System.out.print(word);
                //}
		//System.out.print("]");
		System.out.print(words);
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
		
	    // case 11 : System.exit(0);

            default:
                System.out.println("Invalid Operation!");
        }

        sc.close();
    }
}
