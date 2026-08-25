class Solution {
    public int addDigits(int num) {
        // while(num>=10)
        // {
        //     int sum=0;
        //     while(num>0){
        //     int dig=num%10;
        //     sum+=dig;
        //     num/=10;
        //     }
        //     num=sum;
        // }
        // return num;

        if (num==0) {
            return 0;
        }
        // Digital root formula
        return 1+(num-1)%9;
    }
}