import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map each letter ('a' to 'z') to its corresponding keyboard row index (1, 2, or 3)
        int[] charToRow = new int[26];
        
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        
        for (char c : row1.toCharArray()) charToRow[c - 'a'] = 1;
        for (char c : row2.toCharArray()) charToRow[c - 'a'] = 2;
        for (char c : row3.toCharArray()) charToRow[c - 'a'] = 3;

        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.isEmpty()) continue;
            
            // Get the row index of the first character (case-insensitive)
            int targetRow = charToRow[Character.toLowerCase(word.charAt(0)) - 'a'];
            boolean isValid = true;

            // Check if all other characters belong to the same row
            for (int i = 1; i < word.length(); i++) {
                int currentRow = charToRow[Character.toLowerCase(word.charAt(i)) - 'a'];
                if (currentRow != targetRow) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
