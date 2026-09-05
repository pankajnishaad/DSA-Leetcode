class Solution {
    public static boolean isSafe(char[][] board, int row, int col, char ch)
    {
        for(int i=0; i<9; i++)
        {
            if(board[row][i]==ch) return false;
        }
        for(int i=0; i<9; i++)
        {
            if(board[i][col]==ch) return false;
        }
        int startRow=row-(row%3);
        int startCol=col-(col%3);
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(board[i+startRow][j+startCol]==ch)
                return false;
            }
        }
        return true;
    }
    public static boolean solveSudokuRec(char[][] board, int row, int col)
    {
        if(row==8 && col==9) return true;
        if(col==9)
        {
            row++;
            col=0;
        }
        if(board[row][col]!='.')
        {
            return solveSudokuRec(board, row, col+1);
        }
        for(int i=1; i<=9; i++)
        {
            char ch=(char)('0'+i);
            if(isSafe(board, row, col, ch))
            {
                board[row][col]=ch;
                if(solveSudokuRec(board, row, col+1))
                {
                    return true;
                }
                board[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solveSudokuRec(board, 0, 0);
    }
}