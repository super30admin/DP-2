// Time Complexity : O(2pow(amount+(amount/smallest coin))
// Space Complexity : O(2pow(amount+(amount/smallest coin))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : TLE


// Your code here along with comments explaining your approach
// We follow the before approach either to take or not take the current coin in recursion
class Solution {
    public int change(int amount, int[] coins) {
        int[][] mem = new int[coins.length][amount+1];
        return helper(amount,coins,0,mem);
    }

    private int helper(int amount, int[] coins, int index, int[][] mem)
    {
        //base case
        if(amount==0)
        {
            return 1;
        }
        if(amount<0 || index>=coins.length)
        {
            return 0;
        }
        if(mem[index][amount]){}
        //if current coin is taken
        int case1 = helper(amount-coins[index],coins,index);
        //if current coin is not taken
        int case2 = helper(amount,coins,index+1);
        return case1+case2;
    }
}

// Time Complexity : O(coins len * amount)
// Space Complexity : O(coins len * amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : TLE


// Your code here along with comments explaining your approach
// We follow the before approach either to take or not take the current coin in recursion with memorization
// still TLE
class Solution {
    public int change(int amount, int[] coins) {
        int[][] mem = new int[coins.length][amount+1];
        return helper(amount,coins,0,mem);
    }

    private int helper(int amount, int[] coins, int index,int[][] mem)
    {
        //base case
        if(amount==0)
        {
            return 1;
        }
        if(amount<0 || index>=coins.length)
        {
            return 0;
        }
        //use memorized solution if exists
        if(mem[index][amount]!=0)
        {
            return mem[index][amount];
        }
        //if current coin is taken
        int case1 = helper(amount-coins[index],coins,index,mem);
        //if current coin is not taken
        int case2 = helper(amount,coins,index+1,mem);
        int pathPossible =  case1+case2;
        //put to memorized solution
        mem[index][amount] = pathPossible;
        return pathPossible;
    }
}

// Time Complexity : O( amount)
// Space Complexity : O(amount)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes
class Solution {
    public int change(int amount, int[] coins) {
        int[] mem = new int[amount+1];
        mem[0] = 1;
        for(int coin : coins)
        {
            for(int i = coin;i<=amount;i++)
            {
                mem[i]+=mem[i-coin];
            }
        }
        return mem[amount];
    }
}