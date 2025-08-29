public class StringArrays {

    // 1. Method to find the longest name
    public static String findLongestName(String[] names) {
        String longest = names[0]; // assume first is longest initially
        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }
        return longest;
    }

    // 2. Method to count names starting with a given letter (case-insensitive)
    public static int countNamesStartingWith(String[] names, char letter) {
        int count = 0;
        letter = Character.toLowerCase(letter); // make case-insensitive
        for (String name : names) {
            if (Character.toLowerCase(name.charAt(0)) == letter) {
                count++;
            }
        }
        return count;
    }

    // 3. Method to format names as "Last, First"
    // Assumes input like "First Last"
    public static String[] formatNames(String[] names) {
        String[] formatted = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String[] parts = names[i].split(" ");
            if (parts.length == 2) { 
                formatted[i] = parts[1] + ", " + parts[0]; // "Last, First"
            } else {
                formatted[i] = names[i]; // fallback if not "First Last"
            }
        }
        return formatted;
    }

    public static void main(String[] args) {
        String[] students = {
            "Koushik Rajan",
            "Akilesh",
            "Hari Charan",
            "Shravan",
            "Irshaad"
        };

        // Test findLongestName
        String longest = findLongestName(students);
        System.out.println("Longest Name: " + longest);

        // Test countNamesStartingWith
        char testLetter = 'B';
        int count = countNamesStartingWith(students, testLetter);
        System.out.println("Number of names starting with '" + testLetter + "': " + count);

        // Test formatNames
        String[] formatted = formatNames(students);
        System.out.println("Formatted Names (Last, First):");
        for (String name : formatted) {
            System.out.println(name);
        }
    }
}
