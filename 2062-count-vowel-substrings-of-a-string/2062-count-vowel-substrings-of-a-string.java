class Solution {

    public int countVowelSubstrings(String word) {
        int ans=0;
        for (int i=0; i<word.length(); i++) {
            Set<Character> set=new HashSet<>();
            for(int j=i; j<word.length(); j++) {
                char ch=word.charAt(j);
                if (!isVowel(ch)) {
                    break;
                }
                set.add(ch);
                if (set.size()==5) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // Check karta hai ki character vowel hai ya nahi
    boolean isVowel(char ch) {
        // Allowed five vowels check karo
        return ch == 'a' ||
               ch == 'e' ||
               ch == 'i' ||
               ch == 'o' ||
               ch == 'u';
    }
}