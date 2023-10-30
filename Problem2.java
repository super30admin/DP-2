// Tree height= amount/minimum denomination
// Time Complexity :  2^height
// Space Complexity :  height
// Did this code successfully run on Leetcode : Time Limit exceed
// Any problem you faced while coding this : No


// Brute Force Simple Recursion

class Solution1 {
    int findAns(int amount, int[] coins, int index){
        if(amount==0){
            return 1;
        }
        if(amount<0 || index==coins.length){
            return 0;
        }
        int nChosen= findAns(amount,coins,index+1);
        int Chosen= findAns(amount-coins[index],coins, index);
        return nChosen+Chosen;
    }
    public int change(int amount, int[] coins) {
        int ans= findAns(amount,coins,0);
        return ans;
    }
}


// Tree height= amount/minimum denomination
// Time Complexity :  amount*no.of coins
// Space Complexity :  amount*no.of coins
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Dp with memozation:  Top-down Approach

class Solution2 {

    int[][] dp= new int[300][5001];

    int findAns(int amount, int[] coins, int index){
        if(amount==0){
            return 1;
        }
        if(amount<0 || index==coins.length){
            return 0;
        }

        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }

        int nChosen= findAns(amount,coins,index+1);
        int Chosen= findAns(amount-coins[index],coins, index);

        dp[index][amount]=nChosen+Chosen;

        return dp[index][amount];
    }

    public int change(int amount, int[] coins) {
        for (int[] row: dp)
            Arrays.fill(row, -1);
        int ans= findAns(amount,coins,0);
        return ans;
    }
}



// Time Complexity :  amount*no.of coins
// Space Complexity :  amount
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Dp with memozation:  Bottom-Up Approach


class Solution3 {
    public int change(int amount, int[] coins) {
        int[] prev= new int[amount+1];
        prev[0]=1;

        for(int i=0; i<coins.length; i++){
            int[] curr= new int[amount+1];
            curr[0]=1;
            for(int j=1; j<=amount; j++){
                int NotSelect= prev[j];
                int select= j-coins[i]<0 ? 0 : curr[j-coins[i]];
                curr[j]=NotSelect+select;
            }
            prev=curr;
        }
        return prev[amount];
    }
}

// eliminating the curr[]

class Solution4 {
    public int change(int amount, int[] coins) {
        int[] prev= new int[amount+1];
        prev[0]=1;

        for(int i=0; i<coins.length; i++){
            for(int j=1; j<=amount; j++){
                if(j-coins[i]>=0){
                    prev[j]+= prev[j-coins[i]];
                }
            }
        }
        return prev[amount];
    }
}