class Solution {

    static void generatePermutaion(
        int n,
        int[] nums,
        ArrayList<Integer> current,
        boolean[] used,
        ArrayList<List<Integer>> res
    ) {

        // Agar current permutation complete ho gayi
        if (current.size()==n) {

            // Current permutation ki copy result mein add karo
            res.add(new ArrayList<>(current));

            // Current branch complete
            return;
        }

        // Har number ko ek baar try karo
        for (int i = 0; i < nums.length; i++) {

            // Agar number already use ho chuka hai
            if(used[i]) {
                continue;
            }

            // Number ko current permutation mein add karo
            current.add(nums[i]);

            // Number ko used mark karo
            used[i]=true;

            // Next position ke liye recursion
            generatePermutaion(n, nums, current, used, res);

            // BACKTRACK: last number remove karo
            current.remove(current.size() - 1);

            // BACKTRACK: number ko wapas available karo
            used[i]=false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        // Result store karne ke liye
        ArrayList<List<Integer>> res=new ArrayList<>();

        // Har index ka used status
        boolean[] used=new boolean[nums.length];

        // Current permutation
        ArrayList<Integer> current=new ArrayList<>();

        // Permutation generate karo
        generatePermutaion(
            nums.length,
            nums,
            current,
            used,
            res
        );

        // Final result return karo
        return res;
    }
}