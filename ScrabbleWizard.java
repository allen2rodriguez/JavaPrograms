package ScrabbleWizard;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScrabbleWizard {
	private static ArrayList<String> words;

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Character> univ = new ArrayList<>();
		words = readWords();

		Scanner in = new Scanner(System.in);

		System.out.println("Scrabble Wizard 2 - Allen Rodriguez\n");
		System.out.print("Letters: ");
		String letters = in.next().toLowerCase();
		addToLetters(letters, univ);

		TestClass<Character> tc = new TestClass<>();

		ArrayList<String> possibleWords = tc.findWords(letters);

		for (String word : possibleWords) {
			System.out.println(word);
		}

		in.close();
	}

	private static class TestClass<C> implements PuzzleTest<C> {
		private int bestScore = -1;
		private static final int[] letterScore = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};

		@Override
		public boolean test(ArrayList<C> candidate) {
			return true;
		}

		@Override
		public void foundSolution(ArrayList<C> solution) {
			int score = calcScore(solution);
			if (score > 0) {
				if (score > bestScore) {
					bestScore = score;
				}
			}
		}

		public ArrayList<String> findWords(String letters) {
			ArrayList<String> possibleWords = new ArrayList<>();

			char[] lettersArray = letters.toCharArray();
			Arrays.sort(lettersArray);

			for (String word : words) {
				char[] wordArray = word.toCharArray();
				Arrays.sort(wordArray);

				if (Arrays.equals(lettersArray, wordArray)) {
					possibleWords.add(word);
				}
			}

			return possibleWords;
		}

		public int calcScore(ArrayList<C> solution) {
			int score = 0;

			StringBuilder builder = new StringBuilder(solution.size());
			for (C ch : solution) {
				builder.append(ch);
				score += val(ch);
			}
			if (Collections.binarySearch(words, builder.toString()) > 0) {
				return score;
			}
			return 0;
		}

		private int val(C c) {
			Character ch = (Character) c;
			return letterScore[(int) ch - 97];
		}

		public void reset() {
			bestScore = -1;
		}
	}

	private static void addToLetters(String n, ArrayList<Character> letters) {
		for (int i = 0; i < n.length(); i++) {
			letters.add(n.charAt(i));
		}
	}

	private static ArrayList<String> readWords() throws FileNotFoundException {
		ArrayList<String> words = new ArrayList<>();

		File inputFile = new File("words.txt");
		Scanner in = new Scanner(inputFile);
		while (in.hasNext()) {
			words.add(in.next());
		}
		Collections.sort(words);

		in.close();

		return words;
	}
}
