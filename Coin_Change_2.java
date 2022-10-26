// Time Complexity : O(N*amount)  where N is the length of the coins array
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class Solution {
    public int change(int amount, int[] coins) {
        int[] prev = new int[amount+1];
        prev[0] = 1;

        for(int coin : coins){
            int[] curr = new int[amount+1];
            curr[0] = 1;

            for(int a = 1; a <= amount; ++a){
                
                //select
                int select = a-coin < 0 ? 0 : curr[a-coin];

                //not select
                int notSelect = prev[a];

                curr[a] = select + notSelect;
            }

            prev = curr;
        }

        return prev[amount];
    }
}