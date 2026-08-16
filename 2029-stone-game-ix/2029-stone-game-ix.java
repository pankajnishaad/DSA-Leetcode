class Solution {

    public boolean stoneGameIX(int[] stones) {

        // count[0] = number of stones where stone % 3 == 0
        // count[1] = number of stones where stone % 3 == 1
        // count[2] = number of stones where stone % 3 == 2
        int[] count = new int[3];

        // Count stones according to their remainder.
        for (int stone : stones) {
            count[stone % 3]++;
        }

        // Alice tries taking a remainder-1 stone first.
        boolean startWithOne = check(count[0], count[1], count[2]);

        // Alice tries taking a remainder-2 stone first.
        boolean startWithTwo = check(count[0], count[2], count[1]);

        // If either starting strategy guarantees Alice's win,
        // Alice wins.
        return startWithOne || startWithTwo;
    }

    private boolean check(int zero, int one, int two) {

        // Alice wants to start by taking a remainder-1 stone.
        // If there is no such stone, this strategy is impossible.
        if (one == 0) {
            return false;
        }

        // Alice takes one remainder-1 stone.
        one--;

        // Now the game follows an alternating pattern.
        // Take matching pairs of remainder-1 and remainder-2 stones.
        int turns = 1 + Math.min(one, two) * 2;

        // Remainder-0 stones do not change sum % 3,
        // but they consume turns.
        turns += zero;

        // If extra remainder-1 stones are available,
        // one additional safe move can be made.
        if (one > two) {
            one--;
            turns++;
        }

        // Alice wins if:
        // 1. The number of turns is odd.
        // 2. Some remainder-1 or remainder-2 stone is still left.
        return turns % 2 == 1 && one != two;
    }
}