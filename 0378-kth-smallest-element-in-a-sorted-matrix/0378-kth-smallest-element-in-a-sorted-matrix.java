class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        // List<Integer>list=new ArrayList<>();
        //  for(int[] row:matrix) 
        //  {
        //     for(int num:row) 
        //     {
        //         list.add(num);
        //     }
        // }
        // Collections.sort(list);
        // return list.get(k-1);


        int n=matrix.length;
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                minHeap.offer(matrix[i][j]);
            }
        }
        for(int i=1; i<k; i++)
        {
            minHeap.poll();
        }
        return minHeap.poll();
    }
}