class Solution {
    public static void nQueenUtility(
        int j, int n, List<Integer>board, boolean[] row, boolean[] di1, boolean[] di2,
        List<List<String>>res 
    )
    {
        if(j>n)
        {
            // res.add(new ArrayList<>(board));

            List<String> sol=new ArrayList<>();
            // Convert [2,4,1,3] into actual board
            for(int i=0; i<n; i++) 
            {
                StringBuilder sb=new StringBuilder();
                for(int col=1; col<=n; col++) 
                {
                    if(board.get(col-1)==i+1) 
                    {
                        sb.append('Q');
                    } 
                    else 
                    {
                        sb.append('.');
                    }
                }
                sol.add(sb.toString());
            }
            res.add(sol);
            return;
        }
        for(int i=1; i<=n; i++)
        {
            if(!row[i] && !di1[i+j] && !di2[i-j+n])
            {
                row[i]=di1[i+j]=di2[i-j+n]=true;
                board.add(i); //change yahi karunga

                nQueenUtility(j+1, n, board, row, di1, di2, res);

                board.remove(board.size()-1);
                row[i]=di1[i+j]=di2[i-j+n]=false;
            }
            
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        List<Integer> board=new ArrayList<>();
        boolean[] row=new boolean[n+1];
        boolean[] di1=new boolean[2*n+1];
        boolean[] di2=new boolean[2*n+1];
        nQueenUtility(1, n, board, row, di1, di2, res);
        return res;
    }
}