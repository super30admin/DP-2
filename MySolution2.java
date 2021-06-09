class Solution2 {
    public int change(int amount, int[] coins) {

        if(coins.length == 0){
            return 0;
        }
        return helper(amount,coins,0);

    }
    private int helper(int amount, int[] coins,int index){
        if (amount == 0){
            return 1;
        }
        else if (amount < 0 || index >= coins.length ){
            return 0;
        }
        //Case 0 not choosing coin
        int case1 = helper(amount, coins, index + 1);
        int case2 = helper(amount - coins[index], coins, index);

        return case1 + case2;
    }
}