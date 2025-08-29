import java.util.*;

public class TextProcessor {

    public static String cleanInput(String input) {
        input = input.trim();
        input = input.replaceAll("\\s+", " ");
        if (input.length() > 0) {
            input = input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
        }
        return input;
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;

        String[] sentences = text.split("[.!?]");
        int sentenceCount = 0;
        for (String s : sentences) {
            if (!s.trim().isEmpty()) {
                sentenceCount++;
            }
        }

        int charCount = text.replace(" ", "").length();

        String longestWord = "";
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                mostCommonChar = entry.getKey();
            }
        }

        System.out.println("\n=== TEXT ANALYSIS ===");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Sentence Count: " + sentenceCount);
        System.out.println("Character Count (no spaces): " + charCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Most Common Character: '" + mostCommonChar + "' (" + maxFreq + " times)");
    }

    public static String[] getWordsSorted(String text) {
        String[] words = text.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
        Arrays.sort(words);
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT PROCESSOR ===");
        System.out.print("Enter a paragraph of text: ");
        String input = scanner.nextLine();

        String cleaned = cleanInput(input);
        System.out.println("\nCleaned Text: " + cleaned);

        analyzeText(cleaned);

        String[] sortedWords = getWordsSorted(cleaned);
        System.out.println("\n=== WORDS IN ALPHABETICAL ORDER ===");
        for (String word : sortedWords) {
            System.out.print(word + " ");
        }
        System.out.println();

        System.out.print("\nEnter a word to search: ");
        String searchWord = scanner.next().toLowerCase();
        boolean found = Arrays.asList(sortedWords).contains(searchWord);
        if (found) {
            System.out.println("Word '" + searchWord + "' is present in the text.");
        } else {
            System.out.println("Word '" + searchWord + "' not found in the text.");
        }

        scanner.close();
    }
}
