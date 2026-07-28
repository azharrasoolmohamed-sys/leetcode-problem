class Solution {
    public boolean checkIfPangram(String sentence) {
        // A string with fewer than 26 characters cannot contain all letters
        if (sentence.length() < 26) {
            return false;
        }

        boolean[] seen = new boolean[26];
        int uniqueCount = 0;

        for (char c : sentence.toCharArray()) {
            int index = c - 'a';
            if (!seen[index]) {
                seen[index] = true;
                uniqueCount++;
                // Early exit if all 26 letters are found
                if (uniqueCount == 26) {
                    return true;
                }
            }
        }

        return uniqueCount == 26;
    }
}
