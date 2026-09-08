class Solution {
    public int countCommas(int n) {
      
    int count=0;
    for(int i=1; i<=n; i++) {

            if (i>=1000) {
                count++;
            }
            // 1,000,000 se comma 2 ho jaate hain
            if (i>=1000000) {
                count++;
            }

            // 1,000,000,000 se comma 3 ho jaate hain
            if(i>=1000000000) {
                count++;
            }
        }
      return count;
    }
    
}