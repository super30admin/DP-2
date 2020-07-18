
// time complexity of this problem is O(2^n) and space complexity O(1)
// the code works well its just that it is exceeding the time limit
// one problem that i have here is that i have some confusion regarding the time complexity ,there was some discussion in the class about whether the time complexity
// should be O(2^mn) or O(2^n *m) where m is the amount.I didn't understood this point
class Solution {
    public int change(int amount, int[] coins) {
        return helper(amount,coins,0);
    }
    public int helper (int amount,int [] coins, int i)
    {

        // edge case
        if(amount==0) return 1;
        if(amount<0 || i>coins.length-1)
        {
            return 0;
        }
        // choosing a coin
        int choose=helper(amount-coins[i], coins, i);
        //not choosing a coin
        int notchoose=helper(amount,coins,i+1);
        return choose+notchoose;
        // here is the main difference which lies between the previous coin chnage problem and this one since here we need no of possible ways so we are returing case1 and case2 sum whereas in that problem we need to return the minimum number of coins in both cases.
    }

}
