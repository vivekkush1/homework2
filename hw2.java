import java.io.*;
import java.util.*;

public class hw2 {
	// function to sort array of string lexicographically using bubble sort
	public static void sort(String[] str1) {
		// store size of str1 in variable i
		int i = str1.length;
		for (int j = 0; j < i; j++) {
			for (int p = 0; p < i - j - 1; p++) {
				// if compareTo return 0 means both string are equal.
				// else if greater than 0 then argument string is lexicographically smaller
				// else if less than 0 then argument string is lexicographically greater
				if (str1[p].compareTo(str1[p + 1]) > 0) {
					String s = str1[p];
					str1[p] = str1[p + 1];
					str1[p + 1] = s;
				}
			}
		}
	}

	// function to write word in output file
	public static void write(PrintWriter writer, String[] str1) {
		int k = str1.length;
		for (int j = 0; j < k; j++) {
			writer.println(str1[j]);
		}
	}

	// function to find word in dictionary using binary search
	// if present return true else false
	public static boolean find(String st, String[] str1) {
		int k = str1.length;
		int l = 0, mid;
		// binary search to find word in dictionary
		while (l <= k) {
			mid = l + (k - l) / 2;
			// if found at mid then return true
			if (str1[mid].compareTo(st) == 0) {
				return true;
			}
			// if mid string is greater then search in left of mid
			else if (str1[mid].compareTo(st) > 0) {
				k = mid - 1;
			}
			// else in right of mid
			else {
				l = mid + 1;
			}
		}
		// if not found return false
		return false;
	}

	// function to write output file
	public static void output(String[] str2, PrintWriter writer, String[] str1) {
		int i = str2.length;
		int count = 0;
		// call find() for each word in str2
		for (int y = 0; y < i; y++) {
			// if find() return false then write word in output file
			if (!find(str2[y], str1)) {
				writer.println("keyword not found : " + str2[y]);
				count++;
			}
		}
		// write number of word not found
		writer.println("\n\nNumber of keyword not found = " + count);
	}

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		File file = new File("C:\\Users\\hp\\Desktop\\csx-351-hw2-vikashkumar317-master\\HW2-dictionary.txt");
		Scanner sc = new Scanner(file);
		File file2 = new File("C:\\Users\\hp\\Desktop\\csx-351-hw2-vikashkumar317-master\\HW2-keywords.txt");
		Scanner sc2 = new Scanner(file2);

		PrintWriter writer = new PrintWriter("C:\\Users\\hp\\Desktop\\out2.txt", "UTF-8");
		// PrintWriter writer1 = new PrintWriter("C:\\Users\\hp\\Desktop\\out3.txt",
		// "UTF-8");

		String[] str1 = new String[16000];
		String[] str2 = new String[84];

		int i = 0;
		while (sc.hasNextLine())
		{
			str1[i++] = sc.nextLine();
			//System.out.println(str1[i-1]);
		}

		i = 0;
		while (sc2.hasNextLine())
			str2[i++] = sc2.nextLine();

		sort(str1);
		sort(str2);

		// write(writer1, str1);
		// write(writer1, str2);

		output(str2, writer, str1);

		writer.close();
		// writer1.close();
		sc.close();
		sc2.close();
	}
}
