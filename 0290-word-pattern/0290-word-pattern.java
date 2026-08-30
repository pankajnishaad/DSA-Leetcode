class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");

        // Pattern characters aur words ki count same honi chahiye
        if (pattern.length()!=words.length) {
            return false;
        }
        HashMap<Character, String>charToWord=new HashMap<>();
        HashMap<String, Character>wordToChar=new HashMap<>();

        // Har character aur word ko check karo
        for (int i=0; i<pattern.length(); i++) {

            char ch=pattern.charAt(i);
            String word=words[i];

            // Check karo character pehle se kisi word ko map hai ya nahi
            if (charToWord.containsKey(ch)) {

                // Agar mapped word current word se different hai
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            }

            // Check karo word pehle se kisi character ko map hai ya nahi
            if (wordToChar.containsKey(word)) {

                // Agar mapped character current character se different hai
                if (wordToChar.get(word) != ch) {
                    return false;
                }
            }

            // Character -> Word mapping store karo
            charToWord.put(ch, word);

            // Word -> Character mapping store karo
            wordToChar.put(word, ch);
        }

        return true;
    }
}