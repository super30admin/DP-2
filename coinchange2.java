//Time Complexity: O(n * m) -where n = totalAmount, m = number of coin denominations, loops through each coin and each amount.
//Space Complexity: O(n) - Only a 1D array of size totalAmount + 1 is used.

//Initialize a ways[] array where ways[i] stores the number of combinations to make amount i, with ways[0] = 1.
//For each coin, update all amounts amt from that coin's value up to totalAmount using ways[amt] += ways[amt - coin].
//Return ways[totalAmount] which gives the total number of ways to form the target amount.

class Solution {
    public int change(int totalAmount, int[] denominations) {
        int numCoins = denominations.length;
        int[] ways = new int[totalAmount + 1];
        ways[0] = 1;

        for (int i = 0; i < numCoins; i++) {
            for (int amt = 0; amt <= totalAmount; amt++) {
                if (amt >= denominations[i]) {
                    ways[amt] += ways[amt - denominations[i]];
                }
            }
        }

        return ways[totalAmount];
    }
}
