class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate("", n, ans);
        return ans;
    }
    void generate(String current, int n, List<String> ans) {

        // String complete ho gayi
        if (current.length() == 2 * n) {

            if (isValid(current)) {
                ans.add(current);
            }

            return;
        }

        // '(' add karo
        generate(current + "(", n, ans);

        // ')' add karo
        generate(current + ")", n, ans);
    }
    boolean isValid(String s) {

        int balanced = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                balanced++;
            }
            else {
                balanced--;
            }

            // Closing bracket zyada ho gaya
            if (balanced < 0) {
                return false;
            }
        }

        return balanced == 0;
}}