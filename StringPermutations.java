import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringPermutations {

    // Method to generate all unique permutations of a string
    public static List<String> generatePermutations(String str) {
        Set<String> resultSet = new HashSet<>();
        
        if (str == null || str.isEmpty()) {
            System.out.println("Input string is empty.");
            return new ArrayList<>(resultSet);
        }
        
        permute(str.toCharArray(), 0, resultSet);
        return new ArrayList<>(resultSet);
    }

    // Helper method to perform permutation
    private static void permute(char[] chars, int index, Set<String> resultSet) {
        if (index == chars.length - 1) {
            resultSet.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            permute(chars, index + 1, resultSet);
            swap(chars, index, i);  // Backtrack
        }
    }

    // Utility method to swap two characters in a char array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}