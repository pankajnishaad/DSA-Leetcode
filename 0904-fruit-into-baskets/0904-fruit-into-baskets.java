class Solution {
    public int totalFruit(int[] fruits) {

        int left = 0;              // Window ka starting point
        int max = 0;               // Maximum fruits ka answer

        HashMap<Integer, Integer> map = new HashMap<>();
        // map mein fruit type aur uski frequency store hogi

        for (int right = 0; right < fruits.length; right++) {

            // Current fruit ko window mein add karo
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // Agar 2 se zyada fruit types ho gaye
            while (map.size() > 2) {

                int fruit = fruits[left];
                // Left side ka fruit nikalo

                map.put(fruit, map.get(fruit) - 1);
                // Us fruit ki frequency 1 kam karo

                if (map.get(fruit) == 0) {
                    map.remove(fruit);
                }
                // Frequency 0 ho gayi to fruit type remove karo

                left++;
                // Window ko left se shrink karo
            }

            // Current valid window ki length
            int currentLength = right - left + 1;

            // Maximum answer update karo
            max = Math.max(max, currentLength);
        }

        return max;
    }
}