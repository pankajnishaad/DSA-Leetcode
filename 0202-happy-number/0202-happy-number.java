class Solution {
    HashSet<Integer> visited = new HashSet<>();
    public boolean isHappy(int n) {

        // Base case: agar n = 1 hai, number happy hai
        if (n == 1) {
            return true;
        }

        // Agar n pehle hi aa chuka hai,
        // iska matlab cycle mil gayi
        if (visited.contains(n)) {
            return false;
        }

        // Current number ko visited mein store karo
        visited.add(n);

        // Digits ke squares ka sum nikalo
        int sum = getSquareSum(n);

        // Recursively naye number par function call karo
        return isHappy(sum);
    }

    // Ye function digits ke squares ka sum calculate karta hai
    private int getSquareSum(int n) {

        // Agar number 0 ho gaya, sum complete ho gaya
        if (n == 0) {
            return 0;
        }

        // Last digit nikalo
        int digit = n % 10;

        // Last digit ka square + remaining digits ka result
        return digit * digit + getSquareSum(n / 10);
    }
}