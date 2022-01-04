// Time Complexity :o(2^(m,n))
// Space Complexity :0(m+n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approachclass Solution {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0;
        //return helper(amount , coins , 0);
        return helper(amount , coins , coins.length - 1);
    }
    private int helper(int amount,int[] coins,int index){
        //base
        if(amount == 0)return 1;
        //if(amount < 0 || index == coins.length) return 0;
        if(amount < 0 || index < 0) return 0;
        //logic
        //choose
        int case1 = helper(amount - coins[index], coins, index);
        //not choose
        //int case2 = helper(amount , coins, index + 1);
        int case2 = helper(amount , coins, index - 1);
        return case1 + case2;
    }
}