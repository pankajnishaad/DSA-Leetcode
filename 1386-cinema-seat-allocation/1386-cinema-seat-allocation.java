import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, boolean[]> map = new HashMap<>();

        for(int[] seat : reservedSeats)
        {
            int row = seat[0];
            int col = seat[1];

            if(!map.containsKey(row))
                map.put(row, new boolean[11]);

            map.get(row)[col] = true;
        }

        int group = (n - map.size()) * 2;

        for(int row : map.keySet())
        {
            boolean[] reserved = map.get(row);

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for(int j = 2; j <= 5; j++)
            {
                if(reserved[j])
                {
                    left = false;
                    break;
                }
            }

            for(int j = 4; j <= 7; j++)
            {
                if(reserved[j])
                {
                    middle = false;
                    break;
                }
            }

            for(int j = 6; j <= 9; j++)
            {
                if(reserved[j])
                {
                    right = false;
                    break;
                }
            }

            if(left && right)
                group += 2;
            else if(left || middle || right)
                group += 1;
        }

        return group;
    }
}