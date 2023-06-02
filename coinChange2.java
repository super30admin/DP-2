//exhaustive approach of coin change 2
//choose or dont choose at every point 
//return choose+not chose
class Solution {
    public int change(int amount, int[] coins) {
        //null
        if(coins == null)return 0;
        return helper(coins,0,amount);

    }
    private int helper(int [] coins, int idx, int amount)
    {
        //base
        if(amount ==0) return 1;
        if(amount <0 || idx ==coins.length) return 0;

        //logic
        //dont choose
        int case0 = helper(coins, idx+1,amount);



        //choose
        int case1 = helper(coins, idx, amount - coins[idx]);
        return case0+case1;
    }
}