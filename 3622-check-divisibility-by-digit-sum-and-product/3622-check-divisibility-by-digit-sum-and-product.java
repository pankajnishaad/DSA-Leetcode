class Solution {
    // public static int sum(int n)
    // {
    //     int digSum=0;
    //     while(n>0)
    //     {
    //         int dig=n
    //     }
    // }
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        int original=n;
        while(n>0)
        {
            int dig=n%10;
            sum+=dig;
            product*=dig;
            n/=10;

        }
        int sumOfBoth=sum+product;
        if(original%sumOfBoth==0) return true;

        return false;
    }
}