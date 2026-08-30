class Solution {
    public boolean isUgly(int n) {
        if(n<1) return false;
        while(n%2==0) {
            n = n/2;
        }

        // Jab tak 3 se completely divide ho raha hai
        while(n%3==0) {
            n=n/3;
        }

        // Jab tak 5 se completely divide ho raha hai
        while(n%5==0) {
            n=n/5;
        }

        // Agar 1 bach gaya, to sirf 2,3,5 ke factors the
        return n==1;
    }
}