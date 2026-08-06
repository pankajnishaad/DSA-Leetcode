class Solution {
    public static int findProduct(int n)
    {
        int product=1;
        while(n>0)
        {
            int dig=n%10;
            product*=dig;
            n/=10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        while(true)
        {
            int ans=findProduct(n);
            if(ans%t==0)
            {
                return n;
            }
            n++;
        }
       
    }
}