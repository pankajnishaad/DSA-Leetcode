class Solution {
     public static boolean findMatch(char[][] mat, String word, int x, int y, int widx)
    {
        int wlen=word.length();
        int n=mat.length;
        int m=mat[0].length;
        
        if(widx==wlen) return true;
        
        if(x<0 || y<0 || x>=n || y>=m) return false;
        
        if(mat[x][y]==word.charAt(widx))
        {
            char temp=mat[x][y];
            mat[x][y]='X';
            boolean res=findMatch(mat, word, x+1, y, widx+1) ||
                        findMatch(mat, word, x-1, y, widx+1) ||
                        findMatch(mat, word, x, y+1, widx+1) ||
                        findMatch(mat, word, x, y-1, widx+1);
                        
            mat[x][y]=temp;
            return res;
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int wlen=word.length();
        int n=board.length;
        int m=board[0]. length;
        if(wlen>n*m) return false;
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(findMatch(board, word, i, j, 0))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}