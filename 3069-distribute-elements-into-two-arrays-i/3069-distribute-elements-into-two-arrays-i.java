class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        int[] arr1=new int[n];
        int[] arr2=new int[n];
        int[] res=new int[n];
        arr1[0]=nums[0];
        arr2[0]=nums[1];
        int size1=1;
        int size2=1;
        for(int i=2; i<n; i++)
        {
            int last1=arr1[size1-1];
            int last2=arr2[size2-1];
            if(last1>last2)
            {
                 arr1[size1] = nums[i];
                size1++;
            }
            else{
                arr2[size2]=nums[i];
                size2++;
            }
        }
        int index = 0;
        for (int i = 0; i < size1; i++) {
            res[index++] = arr1[i];
        }

        for (int i = 0; i < size2; i++) {
            res[index++] = arr2[i];
        }

        return res;
    }
}