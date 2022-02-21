// Time Complexity : Approach 1: O(n*A), Approach 2: O(n*A) where n = number of denominations, A = amount
// Space Complexity : Approach 1: O(n*A), Approach 2: O(A) where n = number of denominations, A = amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;
public class Problem2 {
    
    // Memoization Approach (Top-Down)

    private static int[][] dp;
    public static int change1(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        // dp[row][col] == -1 represents that the calculation has not been done via recursion yet
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = change1(amount, 0, coins);
        return ans;
    }
    
    private static int change1(int amount, int index, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || index==coins.length) {
            return 0;
        }
        
        if (dp[index][amount] > -1) {
            return dp[index][amount];
        }
        
        // If I don't select the current denomination, increment index by 1
        int notchoose = change1(amount, index+1, coins);
        
        // If I select the current denomination, decrease amount by coins[index].
        int choose = change1(amount-coins[index], index, coins);
        
        // Set the calculated value (sum of choose and notchoose) at corresponmding row and column in the dp array
        dp[index][amount] = choose + notchoose;
        return dp[index][amount];
    }


    // Iterative Approach (Bottom-up)

    public static int change2(int amount, int[] coins) {
        int[] prev = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            prev[i] = 0;
        }
        for (int index = coins.length-1; index >= 0; index--) {
            int[] curr = new int[amount + 1];
            curr[0] = 1;
            for (int i = 1; i <= amount; i++) {
                // If I don't select the current denomination, the value is equal to the value at index i in prev array
                int notselect = prev[i];
                // If I select the current denomination, decrease amount by coins[index].
                int select = i >= coins[index] ? curr[i-coins[index]] : 0;
                // Set the calculated value (sum of select and notselect) at corresponmding index in the curr array
                curr[i] = notselect + select;
            }
            // Set prev to curr
            prev = curr;
        }
        return prev[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        int ans1 = change1(amount, coins);
        int ans2 = change2(amount, coins);
        System.out.println("Answer for Approach-1(Top-down approach) is : " + ans1);
        System.out.println("Answer for Approach-2(Bottom-up approach) is : " + ans2);

    }

}
