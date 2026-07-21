class Solution {
    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);

        return ch == 'a' || ch == 'e' || ch == 'i' ||
               ch == 'o' || ch == 'u';
    }
    public String reverseVowels(String s) {
        List<Character> vowels = new ArrayList<>();

        // Store all vowels
        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        // Reverse the vowel list
        Collections.reverse(vowels);

        StringBuilder ans = new StringBuilder();

        int index = 0;

        // Replace vowels with reversed vowels
        for (char ch : s.toCharArray()) {

            if (isVowel(ch)) {
                ans.append(vowels.get(index));
                index++;
            } else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}