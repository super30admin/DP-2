// Time Complexity : O(m*n) (m=number of coins, n=amount)
// Space Complexity : O(n) (n = array of size amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class CoinChange2 {
    // Take an array of length amount+1
    // Fill the zer-th place with 0
    // From place 1 to amount, to get the ways to calculate current amount, follow this algorithm
    // 1. If the amount is less than coin, do nothing
    // 2. Else, add the value of combination of [amount - coin] in the value of [amount]
    // return the last entry in combinations array
    public static int change(int amount, int[] coins) {

        int[] combinations = new int[amount+1];

        combinations[0] = 1;

        for(int c : coins){
            for(int i = 1; i <= amount; i++){
                if(i >= c){
                    combinations[i] += combinations[i - c];
                }
            }
        }

        return combinations[amount];
    }

    public static void main(String args[]){
        int amount = 5;
        int[] coins = new int[]{1, 2, 5};
        System.out.println(change(amount,coins));
    }
}
