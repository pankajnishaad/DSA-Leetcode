class Solution {
    public String[] createGrid(int m, int n) {
       String[] res=new String[m];
        for (int i=0; i<m; i++) 
        {
            StringBuilder row=new StringBuilder();
            // Traverse each column
            for (int j=0; j<n; j++) 
            {
                // Keep first row and last column free
                if(i==0 || j==n-1) 
                {
                    row.append('.');
                } 
                // Block all other cells
                else 
                {
                    row.append('#');
                }
            }
            // Store the constructed row
            res[i]=row.toString();
        }
        // Return the final grid
        return res; 
    }
}