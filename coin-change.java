/*
Did it run on leetcode: Yes
Time Complexity: 0(N*M)
Space Complexity: 0(N)
Problems faced: 
Initially started with 2-d matrix but did not work out.
required modifications from paper to 1-d matrix

Algorithm:
We create a `change` array equal to size of amount.

Lets say we have coins {1,2,5} amount=5
initially we will find how many ways we can form with coin-1.
Then we find in how many ways we can form amoun-5 combined of {1,2}.
Then we find in how many ways we can form amoun-5 combined of {1,2,3}.

Which will give us the answer.


*/



class Solution {
    public int change(int amount, int[] coins) {
        
        
        int[] ways = new int[amount+1];
        ways[0] = 1;
        for(int i=0;i<coins.length;++i){
            int coin = coins[i];
            for(int j=coin;j<=amount;++j){
                ways[j]+=ways[j-coin];
            }
        }
        
        return ways[amount];
    }
}